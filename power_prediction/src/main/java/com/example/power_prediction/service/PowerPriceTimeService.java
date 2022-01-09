package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerPriceTime;

import java.util.List;
import java.util.Map;

public interface PowerPriceTimeService {

    List<PowerPriceTime> findAll();

    String edit(PowerPriceTime powerPriceTime);

    String del(Integer id);

    String add(PowerPriceTime powerPriceTime);

    /**
     * 返回指定设备在指定时间段的电费计费规则
     *
     * @param deviceId 设备Id
     * @param time     时间
     */
    Map<String, Object> getDevicePowerPriceInTime(Integer deviceId, Integer time);
}
