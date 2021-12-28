package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerRealtime;

import java.util.List;

public interface PowerRealtimeService {

    //    根据deviceId和时间间隔返回所有数据
    List<PowerRealtime> findAllByDeviceIdAndDataTimeBetween(Integer deviceId,Integer start,Integer end);

    List<PowerRealtime> findAllPowerRealtimeByDataTime(Integer deviceId, Integer dataTime);
}
