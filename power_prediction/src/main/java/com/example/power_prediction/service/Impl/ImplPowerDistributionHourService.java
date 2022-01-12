package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.Device;
import com.example.power_prediction.entity.PowerDistributionHour;
import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.repository.DeviceRepository;
import com.example.power_prediction.repository.PowerDistributionHourRepository;
import com.example.power_prediction.repository.PowerRealtimeRepository;
import com.example.power_prediction.service.PowerDistributionHourService;
import com.example.power_prediction.service.UtilService;
import com.example.power_prediction.util.TimeOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingDouble;


@Service
public class ImplPowerDistributionHourService implements PowerDistributionHourService {
    @Autowired
    PowerRealtimeRepository powerRealtimeRepository;

    @Autowired
    PowerDistributionHourRepository powerDistributionHourRepository;

    @Autowired
    UtilService utilService;

    @Autowired
    DeviceRepository deviceRepository;

    /**
     * 根据输入数据，查询PowerRealtime计算出结果录入数据表
     *
     * @param deviceId 设备ID
     * @param time     时间戳
     */
    private PowerDistributionHour insertHour(Integer deviceId, Integer time) {
        try {
            //获得这一小时的所有电量数据
            List<PowerRealtime> powerRealtimes = powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(
                    deviceId, time, time + 3599);

            //初始化表格
            PowerDistributionHour powerDistributionHour = new PowerDistributionHour();
            powerDistributionHour.setDeviceId(deviceId);
            powerDistributionHour.setDataTime(time);


            //利用stream，求出该小时的电量
            Double totalKWh = powerRealtimes.stream().collect(averagingDouble(p -> Double.parseDouble(p.getTotalLoad())));

            powerDistributionHour.setTotalKWh(String.format("%.2f", totalKWh));

            //如果该小时还没过完则不持久化
            if ((System.currentTimeMillis() / 1000 - time) > 3600) {
                powerDistributionHourRepository.save(powerDistributionHour);
            }
            return powerDistributionHour;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Object> queryByDay(Integer deviceId, Integer year, Integer month, Integer day) {
        Map<String, Object> map = new HashMap<>(); //总容器
        try {
            final ZoneId zoneId = utilService.getZoneId();
            ZonedDateTime startTime = LocalDate.of(year, month, day).atStartOfDay(zoneId);

            //从数据库中查找该月数据
            List<PowerDistributionHour> powerDistributionHours = powerDistributionHourRepository.findAllByDeviceIdAndDataTimeBetween(
                    deviceId,
                    (int) startTime.toEpochSecond(),
                    (int) startTime.toEpochSecond() + 86399
            );

            //如果数据不全则尝试更新
            if (powerDistributionHours.size() < 24) {
                for (ZonedDateTime i = startTime; i.getDayOfMonth() == day && ChronoUnit.HOURS.between(i, ZonedDateTime.now()) > 0; i=i.plusHours(1)) {
                    ZonedDateTime finalI = i;
                    if (powerDistributionHours.stream().noneMatch(p -> p.getDataTime() == (int) finalI.toEpochSecond())) {
                        PowerDistributionHour powerDistributionHour = insertHour(deviceId, (int) i.toEpochSecond());
                        if (powerDistributionHour != null) powerDistributionHours.add(powerDistributionHour);
                    }
                }
            }

            //构建Map数据
            Map<String, Object> data = powerDistributionHours.stream().filter(Objects::nonNull).collect(Collectors.toMap(
                    p -> TimeOperation.getZonedDateTime(p.getDataTime(), zoneId).format(DateTimeFormatter.ofPattern("HH:mm")),
                    PowerDistributionHour::getTotalKWh, (p1, p2) -> p1, TreeMap::new));

            map.put("data", data);
            map.put("state", "Success");
        } catch (Exception e) {
            map.put("state", "Fail");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map<String, Object> hourlyUpdate() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<Device> devices = deviceRepository.findAll();
            devices.forEach(device -> insertHour(device.getId(), (int) ZonedDateTime.now().withMinute(0).withSecond(0).minusHours(1).toEpochSecond()));
            map.put("state", "Success");
        } catch (Exception e) {
            map.put("state", "Fail");
            e.printStackTrace();
        }
        return map;
    }

}
