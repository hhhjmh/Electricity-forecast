package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.DeviceRelationship;
import com.example.power_prediction.entity.PowerBillByDay;
import com.example.power_prediction.entity.PowerPriceTime;
import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.repository.*;
import com.example.power_prediction.service.PowerBillByDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingDouble;

@Service
public class ImplPowerBillByDayService implements PowerBillByDayService {
    @Autowired
    PowerBillByDayRepository powerBillByDayRepository;
    @Autowired
    DeviceRelationshipRepository deviceRelationshipRepository;
    @Autowired
    PowerPriceTimeRepository powerPriceTimeRepository;
    @Autowired
    PowerRealtimeRepository powerRealtimeRepository;

    private final ZoneId zoneId = ZoneId.of("Asia/Shanghai");

    @Override
    public List<PowerBillByDay> findAllByDeviceIdAndDateTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerBillByDayRepository.findAllByDeviceIdAndDateTimeBetween(deviceId, start, end);
    }


    /**
     * 根据输入数据，查询PowerRealtime计算出结果录入数据表
     *
     * @param deviceId 设备ID
     * @param time     时间戳
     */
    private PowerBillByDay insertDay(Integer deviceId, Integer time) {
        //如果一天还没过完则不计算
        if ((System.currentTimeMillis() / 1000 - time) < 86400) {
            return null;
        }

        //获得设备类型
        DeviceRelationship deviceRelationship = deviceRelationshipRepository.findByDeviceId(deviceId);
        Integer type = deviceRelationship.getType();

        //获取当天的电费计价信息
        PowerPriceTime powerPriceTime = powerPriceTimeRepository.
                findFirstByDeviceTypeIdAndStartTimeLessThanEqualOrderByStartTimeDesc(type, time);

        //获得当天的所有电量数据
        List<PowerRealtime> powerRealtimes = powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(
                deviceId, time, time + 86399);

        //初始化表格
        PowerBillByDay powerBillByDay = new PowerBillByDay();
        powerBillByDay.setDeviceId(deviceId);
        powerBillByDay.setDateTime(time);


        double f_power = powerRealtimes.stream().
                filter(s -> s.getDataTime() % 86400 >= powerPriceTime.getF_power_startAt() % 86400 &&
                        s.getDataTime() % 86400 < powerPriceTime.getF_power_endAt() % 86400).
                map(PowerRealtime::getTotalLoad).collect(averagingDouble(Double::parseDouble)) *
                (powerPriceTime.getF_power_endAt() % 86400 - powerPriceTime.getF_power_startAt() % 86400) / 3600.0;
        double f_power_price = f_power * Double.parseDouble(powerPriceTime.getF_power_price());

        double g_power = powerRealtimes.stream().
                filter(s -> s.getDataTime() % 86400 >= powerPriceTime.getG_power_startAt() % 86400 &&
                        s.getDataTime() % 86400 < powerPriceTime.getG_power_endAt() % 86400).
                map(PowerRealtime::getTotalLoad).collect(averagingDouble(Double::parseDouble)) *
                (powerPriceTime.getG_power_endAt() % 86400 - powerPriceTime.getG_power_startAt() % 86400) / 3600.0;
        double g_power_price = g_power * Double.parseDouble(powerPriceTime.getG_power_price());

        double p_power = powerRealtimes.stream().
                filter(s -> s.getDataTime() % 86400 >= powerPriceTime.getP_power_startAt() % 86400 &&
                        s.getDataTime() % 86400 < powerPriceTime.getP_power_endAt() % 86400 + 86400).
                map(PowerRealtime::getTotalLoad).collect(averagingDouble(Double::parseDouble)) *
                (powerPriceTime.getP_power_endAt() % 86400 + 86400 - powerPriceTime.getP_power_startAt() % 86400) / 3600.0;
        double p_power_price = p_power * Double.parseDouble(powerPriceTime.getP_power_price());

        double j_power = powerRealtimes.stream().
                filter(s -> s.getDataTime() % 86400 >= powerPriceTime.getJ_power_startAt() % 86400 &&
                        s.getDataTime() % 86400 < powerPriceTime.getJ_power_endAt() % 86400).
                map(PowerRealtime::getTotalLoad).collect(averagingDouble(Double::parseDouble)) *
                (powerPriceTime.getJ_power_endAt() % 86400 - powerPriceTime.getJ_power_startAt() % 86400) / 3600.0;
        double j_power_price = j_power * Double.parseDouble(powerPriceTime.getJ_power_price());

        powerBillByDay.setF_power(String.format("%.2f", f_power));
        powerBillByDay.setG_power(String.format("%.2f", g_power));
        powerBillByDay.setP_power(String.format("%.2f", p_power));
        powerBillByDay.setJ_power(String.format("%.2f", j_power));
        powerBillByDay.setF_power_price(String.format("%.2f", f_power_price));
        powerBillByDay.setG_power_price(String.format("%.2f", g_power_price));
        powerBillByDay.setP_power_price(String.format("%.2f", p_power_price));
        powerBillByDay.setJ_power_price(String.format("%.2f", j_power_price));

        powerBillByDayRepository.save(powerBillByDay);
        return powerBillByDay;
    }

    @Override
    public Map<String, Object> queryByMonth(Integer deviceId, Integer year, Integer month) {
        Map<String, Object> map = new HashMap<>(); //总容器
        try {
            YearMonth yearMonth = YearMonth.of(year, month);

            //从数据库中查找该月数据
            List<PowerBillByDay> powerBillByDays = findAllByDeviceIdAndDateTimeBetween(
                    deviceId,
                    (int) yearMonth.atDay(1).atStartOfDay(zoneId).toEpochSecond(),
                    (int) yearMonth.atEndOfMonth().atStartOfDay(zoneId).toEpochSecond());

            Map<Integer, Object> dayData; //每天的数据容器

            //天数不够则寻找不存在的天数并插入数据后返回
            if (powerBillByDays.size() != yearMonth.lengthOfMonth()) {
                for (LocalDate localDate = LocalDate.of(year, month, 1); localDate.getMonthValue() == month && localDate.compareTo(LocalDate.now(zoneId)) < 0; localDate = localDate.plusDays(1)) {
                    Integer dateTime = (int) localDate.atStartOfDay(zoneId).toEpochSecond();
                    if (powerBillByDays.stream().noneMatch(p -> Objects.equals(p.getDateTime(), dateTime))) {
                        powerBillByDays.add(insertDay(deviceId, dateTime));
                    }
                }
            }
            //从对象中提取数据注入Map
            dayData = powerBillByDays.stream().filter(Objects::nonNull).collect(Collectors.toMap(
                    p -> ZonedDateTime.ofInstant(Instant.ofEpochSecond(p.getDateTime()), zoneId).getDayOfMonth(),
                    p -> {
                        Map<String, Object> tmp = new HashMap<>();
                        tmp.put("f_power", p.getF_power());
                        tmp.put("f_power_price", p.getF_power_price());
                        tmp.put("g_power", p.getG_power());
                        tmp.put("g_power_price", p.getG_power_price());
                        tmp.put("p_power", p.getP_power());
                        tmp.put("p_power_price", p.getP_power_price());
                        tmp.put("j_power", p.getJ_power());
                        tmp.put("j_power_price", p.getJ_power_price());
                        return tmp;
                    }));

            map.put("dayData", dayData);
            map.put("state", "Success");
        } catch (Exception e) {
            map.put("state", "Fail");
            e.printStackTrace();
        }
        return map;
    }


}
