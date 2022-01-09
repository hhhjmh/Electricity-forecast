package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.PowerBillByDay;
import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.repository.*;
import com.example.power_prediction.service.PowerBillByDayService;
import com.example.power_prediction.service.PowerPriceTimeService;
import com.example.power_prediction.service.UtilService;
import com.example.power_prediction.util.TimeOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
public class ImplPowerBillByDayService implements PowerBillByDayService {
    @Autowired
    PowerBillByDayRepository powerBillByDayRepository;

    @Autowired
    PowerRealtimeRepository powerRealtimeRepository;

    @Autowired
    PowerPriceTimeService powerPriceTimeService;

    @Autowired
    UtilService utilService;


    /**
     * 判断该时间处在哪个计时段
     * @param powerPriceTime getDevicePowerPriceInTime得到的Map对象
     * @param time 时间
     * @return “f”“g”“p”“j”
     */
    private String getTimeZone(Map<String, Object> powerPriceTime, LocalTime time) {
        String[] keys = {"f", "g", "p", "j"};
        for (String key : keys) {
            Map<String, Object> timeAndPrice = (Map<String, Object>) powerPriceTime.get(key);
            List<LocalTime> starts = (List<LocalTime>) timeAndPrice.get("start");
            List<LocalTime> ends = (List<LocalTime>) timeAndPrice.get("end");
            for (int i = 0; i < starts.size(); i++) {
                if (TimeOperation.isBetween(time, starts.get(i), ends.get(i), ChronoUnit.SECONDS)) {
                    return key;
                }
            }
        }
        return "error";
    }

    //返回各个计时段持续的时间以及电费单价
    private Map<String, Double[]> getPriceZone(Map<String, Object> powerPriceTime) {
        String[] keys = {"f", "g", "p", "j"};
        Map<String, Double[]> map = new HashMap<>();
        for (String key : keys) {
            Map<String, Object> timeAndPrice = (Map<String, Object>) powerPriceTime.get(key);
            List<LocalTime> starts = (List<LocalTime>) timeAndPrice.get("start");
            List<LocalTime> ends = (List<LocalTime>) timeAndPrice.get("end");
            double price = Double.parseDouble((String) timeAndPrice.get("price"));
            double tmp = 0;
            for (int i = 0; i < starts.size(); i++) {
                double t=ChronoUnit.SECONDS.between(starts.get(i), ends.get(i));
                if (t<0)t=86400+t;
                tmp += t;
            }
            map.put(key, new Double[]{tmp/3600, price});
        }
        return map;
    }


    /**
     * 根据输入数据，查询PowerRealtime计算出结果录入数据表
     *
     * @param deviceId 设备ID
     * @param time     时间戳
     */
    private PowerBillByDay insertDay(Integer deviceId, Integer time,ZoneId zoneId) {
        //如果一天还没过完则不计算
        if ((System.currentTimeMillis() / 1000 - time) < 86400) {
            return null;
        }

        //获得当天电费计价信息
        Map<String, Object> powerPriceTime = powerPriceTimeService.getDevicePowerPriceInTime(deviceId, time);

        //获得当天的所有电量数据
        List<PowerRealtime> powerRealtimes = powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(
                deviceId, time, time + 86399);


        //初始化表格
        PowerBillByDay powerBillByDay = new PowerBillByDay();
        powerBillByDay.setDeviceId(deviceId);
        powerBillByDay.setDateTime(TimeOperation.getZonedDateTime(time, zoneId).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        //利用stream流分割，将各个时间段内的负载求平均值
        Map<String, Double> stringDoubleMap = powerRealtimes.stream().collect(groupingBy(
                s -> getTimeZone(powerPriceTime, LocalTime.from(TimeOperation.getZonedDateTime(s.getDataTime(), zoneId))),
                averagingDouble(s -> Double.parseDouble(s.getTotalLoad()))));

        //将负载乘时间和电价，得出电量和电费
        Map<String, Double[]> priceZone = getPriceZone(powerPriceTime);
        String[] keys = {"f", "g", "p", "j"};
        Map<String, Double> power = new HashMap<>();
        Map<String, Double> price = new HashMap<>();
        for (String key : keys) {
            stringDoubleMap.putIfAbsent(key, 0.0);
            power.put(key, stringDoubleMap.get(key) * priceZone.get(key)[0]);
            price.put(key, stringDoubleMap.get(key) * priceZone.get(key)[0] * priceZone.get(key)[1]);
        }


        powerBillByDay.setF_power(String.format("%.2f", power.get("f")));
        powerBillByDay.setG_power(String.format("%.2f", power.get("g")));
        powerBillByDay.setP_power(String.format("%.2f", power.get("p")));
        powerBillByDay.setJ_power(String.format("%.2f", power.get("j")));
        powerBillByDay.setF_power_price(String.format("%.2f", price.get("f")));
        powerBillByDay.setG_power_price(String.format("%.2f", price.get("g")));
        powerBillByDay.setP_power_price(String.format("%.2f", price.get("p")));
        powerBillByDay.setJ_power_price(String.format("%.2f", price.get("j")));

        powerBillByDayRepository.save(powerBillByDay);
        return powerBillByDay;
    }

    @Override
    public Map<String, Object> queryByMonth(Integer deviceId, Integer year, Integer month) {
        final ZoneId zoneId = utilService.getZoneId();
        Map<String, Object> map = new HashMap<>(); //总容器
        try {
            YearMonth yearMonth = YearMonth.of(year, month);

            //从数据库中查找该月数据
            List<PowerBillByDay> powerBillByDays = powerBillByDayRepository.findAllByDeviceIdAndDateTimeStartingWith(
                    deviceId,
                    yearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM"))
            );

            Map<String, Object> dayData; //每天的数据容器

            //天数不够则寻找不存在的天数并插入数据后返回
            if (powerBillByDays.size() != yearMonth.lengthOfMonth()) {
                for (LocalDate localDate = LocalDate.of(year, month, 1); localDate.getMonthValue() == month && localDate.compareTo(LocalDate.now(zoneId)) < 0; localDate = localDate.plusDays(1)) {
                    Integer dateTime = (int) localDate.atStartOfDay(zoneId).toEpochSecond();
                    LocalDate finalLocalDate = localDate;
                    if (powerBillByDays.stream().noneMatch(p -> Objects.equals(p.getDateTime(), finalLocalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))) {
                        powerBillByDays.add(insertDay(deviceId, dateTime,zoneId));
                    }
                }
            }
            //从对象中提取数据注入Map
            dayData = powerBillByDays.stream().filter(Objects::nonNull).collect(Collectors.toMap(
                    PowerBillByDay::getDateTime,
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
