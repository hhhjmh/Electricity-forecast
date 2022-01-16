package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.Device;
import com.example.power_prediction.entity.PowerBillByDay;
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

import static java.util.stream.Collectors.*;


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

    //求出powerRealTime中数据的耗电量
    private Double sumPower(List<PowerRealtime> powerRealtimeList, Integer lastSecond) {
        Double totalLoad = powerRealtimeList.stream().collect(averagingDouble(p -> Double.parseDouble(p.getTotalLoad())));
        double lastHour = lastSecond / 3600.0;
        return lastHour * totalLoad;
    }


    /**
     * 根据输入数据，查询PowerRealtime计算出结果录入数据表
     *
     * @param deviceId 设备ID
     * @param time     时间戳
     */
    private PowerDistributionHour insertHour(Integer deviceId, Integer time) {
        try {
            //获得这一小时的所有电量数据
            List<PowerRealtime> powerRealtimeList = powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(
                    deviceId, time, time + 3599);

            //初始化表格
            PowerDistributionHour powerDistributionHour = new PowerDistributionHour();
            powerDistributionHour.setDeviceId(deviceId);
            powerDistributionHour.setDataTime(time);


            powerDistributionHour.setTotalKWh(String.format("%.2f", sumPower(powerRealtimeList, 3600)));

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
                for (ZonedDateTime i = startTime; i.getDayOfMonth() == day && ChronoUnit.HOURS.between(i, ZonedDateTime.now()) > 0; i = i.plusHours(1)) {
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
            Integer time = (int) ZonedDateTime.now().withMinute(0).withSecond(0).minusHours(1).toEpochSecond();

            devices.forEach(device -> {
                PowerDistributionHour powerDistributionHour = powerDistributionHourRepository.findByDeviceIdAndDataTime(device.getId(), time);
                //如果已经有了则不插入
                if (powerDistributionHour == null) {
                    insertHour(device.getId(), time);
                }
            });
            map.put("state", "Success");
        } catch (Exception e) {
            map.put("state", "Fail");
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map<String, Object> queryByDayMulti(String deviceIds, Integer start, Integer end, Integer unit) {
        Map<String, Object> map = new HashMap<>(); //总容器
        try {
            //初始化数据
            final ZoneId zoneId = utilService.getZoneId();
            String[] devices = deviceIds.split(",");

            //开始求每个设备的数据
            for (String device : devices) {
                Integer deviceId = Integer.valueOf(device);
                List<Map<String, Object>> deviceDate = new ArrayList<>(); //存储每个时间段数据的容器

                //开始结束全是整点则调数据库资源
                if (start % 3600 == 0 && end % 3600 == 0) {

                    List<PowerDistributionHour> powerDistributionHourList = powerDistributionHourRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end-1);
                    //少数据则开始查询搜刮
                    if (powerDistributionHourList.size() < (end - start) / 3600) {
                        for (int i = start; i <= end; i = i + 3600) {
                            int finalI = i;
                            if (powerDistributionHourList.stream().noneMatch(p -> p.getDataTime() == finalI)) {
                                PowerDistributionHour powerDistributionHour = insertHour(deviceId, finalI);
                                if (powerDistributionHour != null) powerDistributionHourList.add(powerDistributionHour);
                            }
                        }
                    }
                    //List按照时间排序
                    powerDistributionHourList = powerDistributionHourList.stream().sorted(Comparator.comparingInt(PowerDistributionHour::getDataTime)).collect(Collectors.toList());

                    if (unit == 0) {
                        Map<String, Object> tmp = new HashMap<>();
                        double totalKwh = powerDistributionHourList.stream().mapToDouble(p -> Double.parseDouble(p.getTotalKWh())).sum();
                        tmp.put("startTime", powerDistributionHourList.get(0).getDataTime());
                        tmp.put("endTime", powerDistributionHourList.get(powerDistributionHourList.size() - 1).getDataTime()+3600*(unit - 1));
                        tmp.put("totalKwh", String.format("%.2f", totalKwh));
                        deviceDate.add(tmp);
                    } else {
                        for (int i = 0; i < powerDistributionHourList.size() ; i =i+unit) {
                            Map<String, Object> tmp = new HashMap<>();
                            int startIndex = i;
                            int endIndex = i+unit<powerDistributionHourList.size()?i+unit-1:powerDistributionHourList.size()-1;
                            double totalKwh = powerDistributionHourList.subList(startIndex, endIndex+1).stream().mapToDouble(p -> Double.parseDouble(p.getTotalKWh())).sum();
                            tmp.put("startTime", powerDistributionHourList.get(startIndex).getDataTime());
                            tmp.put("endTime", powerDistributionHourList.get(endIndex).getDataTime()+3600);
                            tmp.put("totalKwh", String.format("%.2f", totalKwh));
                            deviceDate.add(tmp);
                        }
                    }
                } else if (unit == 0) {
                    List<PowerRealtime> powerRealtimeList = powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
                    double totalKwh = sumPower(powerRealtimeList, end - start);
                    Map<String, Object> tmp = new HashMap<>();
                    tmp.put("startTime", start);
                    tmp.put("endTime", end);
                    tmp.put("totalKwh", String.format("%.2f", totalKwh));
                    deviceDate.add(tmp);
                } else {
                    for (int i = start; i < end && i < (int) (System.currentTimeMillis() / 1000); i = i + unit * 3600) {
                        //求出开始与结束时间
                        Integer startTimestamp = i;
                        Integer endTimestamp = i + 3600 * unit  < end ? i + 3600 * unit : end;
                        List<PowerRealtime> powerRealtimeList = powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, startTimestamp, endTimestamp-1);
                        double totalKwh = sumPower(powerRealtimeList, endTimestamp-startTimestamp);
                        Map<String, Object> tmp = new HashMap<>();
                        tmp.put("startTime", startTimestamp);
                        tmp.put("endTime", endTimestamp);
                        tmp.put("totalKwh", String.format("%.2f", totalKwh));
                        deviceDate.add(tmp);
                    }
                }
                map.put(device, deviceDate);

                //设备id对应的设备名称
                Map<String, Object> devicesName = Arrays.stream(devices).collect(toMap(d -> d, d -> deviceRepository.findById(Integer.valueOf(d)).get().getName()));
                map.put("devicesName", devicesName);
            }
            map.put("state", "Success");
        } catch (Exception e) {
            map.put("state", "Fail");
            e.printStackTrace();
        }
        return map;
    }
}
