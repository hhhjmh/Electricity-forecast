package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerDistributionDay;
import com.example.power_prediction.entity.PowerDistributionHour;
import com.example.power_prediction.entity.PowerQualityRealtime;
import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.repository.PowerQualityRealtimeRepository;

import java.util.List;
import java.util.Map;

public interface PowerRealtimeService {

    //    根据deviceId和时间间隔返回所有数据
    List<PowerRealtime> findPowerRealtimeByDeviceIdAndDataTimeBetween(Integer deviceId,Integer start,Integer end);

    List<PowerDistributionHour> findPowerDistributionHourByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);

    List<PowerQualityRealtime> findPowerQualityRealtimeByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);

    List<PowerDistributionDay> findPowerDistributionDayByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);

    Map<String,List>  findPowerRealtimeByDataTimeForTable(Integer deviceId, Integer start, Integer end);

    Map findPowerDistributionHourByDataTimeForTable(Integer deviceId, Integer start, Integer end);
    //    List<PowerRealtime> findAllPowerRealtimeByDataTime(Integer deviceId, Integer dataTime);

}
