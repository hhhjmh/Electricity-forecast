package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.*;
import com.example.power_prediction.repository.*;
import com.example.power_prediction.service.PowerRealtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImplPowerRealtimeService implements PowerRealtimeService {
    @Autowired
    PowerRealtimeRepository powerRealtimeRepository;
    @Autowired
    PowerDistributionHourRepository powerDistributionHourRepository;
    @Autowired
    PowerQualityRealtimeRepository powerQualityRealtimeRepository;
    @Autowired
    PowerDistributionDayRepository powerDistributionDayRepository;
    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public List<PowerRealtime> findPowerRealtimeByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
    }

    @Override
    public List<PowerDistributionHour> findPowerDistributionHourByDataTimeForAdd(Integer deviceId, Integer start, Integer end) {
        List<PowerDistributionHour> powerDistributionHours = powerDistributionHourRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
        Double totalPower = 0.0;
        Integer flag = 0;
        for (PowerDistributionHour p : powerDistributionHours
        ) {
            {
                if (flag == 288) {
                    totalPower = 0.0;
                }
                Double oldTotalKWh = Double.parseDouble(p.getTotalKWh());
                p.setTotalKWh(String.format("%.2f", Double.parseDouble(p.getTotalKWh()) + totalPower));
                totalPower = oldTotalKWh + totalPower;
                flag += 1;
            }
        }
        return powerDistributionHours;
    }

    @Override
    public List<PowerDistributionHour> findPowerDistributionHourByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerDistributionHourRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
    }

    @Override
    public List<PowerQualityRealtime> findPowerQualityRealtimeByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerQualityRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
    }

    @Override
    public List<PowerDistributionDay> findPowerDistributionDayByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerDistributionDayRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
    }

    @Override
    public Map<String, List> findPowerRealtimeByDataTimeForTable(Integer deviceId, Integer start, Integer end) {
        List<PowerRealtime> powerRealtimeList = powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
        List<Map> tableListForLoad = new ArrayList<>();
        List<Map> tableListForReactivePower = new ArrayList<>();
        List<Map> tableListForPowerFactor = new ArrayList<>();
        List<Map> tableListForI = new ArrayList<>();
        List<Map> tableListForU = new ArrayList<>();
        for (PowerRealtime powerRealtime : powerRealtimeList
        ) {
            if (powerRealtime.getDataTime() % 3600 == 0) {
                Map loadMap = new HashMap();
                loadMap.put("totalLoad", powerRealtime.getTotalLoad());
                loadMap.put("aLoad", powerRealtime.getaLoad());
                loadMap.put("bLoad", powerRealtime.getbLoad());
                loadMap.put("cLoad", powerRealtime.getcLoad());
                tableListForLoad.add(loadMap);

                Map reactivePowerMap = new HashMap();
                reactivePowerMap.put("totalReactivePower", powerRealtime.getTotalReactivePower());
                reactivePowerMap.put("aReactivePower", powerRealtime.getaReactivePower());
                reactivePowerMap.put("bReactivePower", powerRealtime.getbReactivePower());
                reactivePowerMap.put("cReactivePower", powerRealtime.getcReactivePower());
                tableListForReactivePower.add(reactivePowerMap);

                Map powerFactorMap = new HashMap();
                powerFactorMap.put("totalPowerFactor", powerRealtime.getTotalPowerFactor());
                powerFactorMap.put("aPowerFactor", powerRealtime.getaPowerFactor());
                powerFactorMap.put("bPowerFactor", powerRealtime.getbPowerFactor());
                powerFactorMap.put("cPowerFactor", powerRealtime.getcPowerFactor());
                tableListForPowerFactor.add(powerFactorMap);

                Map IMap = new HashMap();
                IMap.put("ia", powerRealtime.getIa());
                IMap.put("ib", powerRealtime.getIb());
                IMap.put("ic", powerRealtime.getIc());
                IMap.put("zeroi", powerRealtime.getZeroi());
                tableListForI.add(IMap);

                Map UMap = new HashMap();
                UMap.put("ua", powerRealtime.getUa());
                UMap.put("ub", powerRealtime.getUb());
                UMap.put("uc", powerRealtime.getUc());
                UMap.put("uab", powerRealtime.getUab());
                UMap.put("ubc", powerRealtime.getUbc());
                UMap.put("uca", powerRealtime.getUca());
                tableListForU.add(UMap);
            }

        }

        Map<String, List> newMap = new HashMap();
        newMap.put("Load", tableListForLoad);
        newMap.put("tableListForReactivePower", tableListForReactivePower);
        newMap.put("PowerFactor", tableListForPowerFactor);
        newMap.put("I", tableListForI);
        newMap.put("U", tableListForU);
        return newMap;
    }

    @Override
    public Map findPowerDistributionHourByDataTimeForTable(Integer deviceId, Integer start, Integer end) {
        List<PowerDistributionHour> powerDistributionHours = powerDistributionHourRepository.findAllByDeviceIdAndDataTimeBetweenOrderByDataTimeDesc(deviceId, start, end);
        Map tableMap = new HashMap();
        Double totalKWh = 0.0;
        Double hourKWh = 0.0;
        Integer i = 1;
        Integer hour = 1;
        for (PowerDistributionHour p : powerDistributionHours
        ) {
            hourKWh += Double.valueOf(p.getTotalKWh());
            if (i % 12 == 0) {
                tableMap.put("hourKWh" + hour, String.format("%.2f", (hourKWh)));
                hour += 1;
                hourKWh = 0.0;
            }
            i++;
            totalKWh += Double.valueOf(p.getTotalKWh());
        }
        tableMap.put("totalKWh", totalKWh);
        Device device = deviceRepository.findAllById(deviceId);
        tableMap.put("device", device.getName());
        tableMap.put("deviceId", deviceId);
        return tableMap;
    }

    @Override
    public Map<String, List> findPowerQualityRealtimeByDataTimeForTable(Integer deviceId, Integer start, Integer end) {
        List<PowerQualityRealtime> powerQualityRealtimeList = powerQualityRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
        List<Map> tableListForTHD = new ArrayList<>();
        List<Map> tableListForPowerQuality = new ArrayList<>();
        for (PowerQualityRealtime powerQualityRealtime : powerQualityRealtimeList
        ) {
            if (powerQualityRealtime.getDataTime() % 3600 == 0) {
                Map PHDMap = new HashMap();
                PHDMap.put("iaPHD", powerQualityRealtime.getIaPhd());
                PHDMap.put("ibPHD", powerQualityRealtime.getIbPhd());
                PHDMap.put("icPHD", powerQualityRealtime.getIcPhd());
                PHDMap.put("uaPHD", powerQualityRealtime.getUaPhd());
                PHDMap.put("ubPHD", powerQualityRealtime.getUbPhd());
                PHDMap.put("ucPHD", powerQualityRealtime.getUcPhd());
                tableListForTHD.add(PHDMap);

                Map powerQualityMap = new HashMap();
                powerQualityMap.put("frequencyDeviation", powerQualityRealtime.getFrequencyDeviation());
                powerQualityMap.put("uaDeviation", powerQualityRealtime.getUaDeviation());
                powerQualityMap.put("ubDeviation", powerQualityRealtime.getUbDeviation());
                powerQualityMap.put("ucDeviation", powerQualityRealtime.getUcDeviation());
                powerQualityMap.put("uUabDeviation", powerQualityRealtime.getuUabDeviation());
                powerQualityMap.put("uUbcDeviation", powerQualityRealtime.getuUbcDeviation());
                powerQualityMap.put("uUcaDeviation", powerQualityRealtime.getuUcaDeviation());
                powerQualityMap.put("iUnbalance", powerQualityRealtime.getiUnbalance());
                powerQualityMap.put("uUnbalance", powerQualityRealtime.getuUnbalance());
                tableListForPowerQuality.add(powerQualityMap);

            }

        }
        Map<String, List> newMap = new HashMap();
        newMap.put("PHD", tableListForTHD);
        newMap.put("PowerQuality", tableListForPowerQuality);
        return newMap;
    }

//    @Override
//    public List<PowerRealtime> findAllPowerRealtimeByDataTime(Integer deviceId, Integer dataTime) {
//
//        return
//    }
}
