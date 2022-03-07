package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerElectricalSafety;

import java.util.List;


public interface PowerElectricalSafetyService {

    List<PowerElectricalSafety> findPowerElectricalSafetyByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);

    List<PowerElectricalSafety> findYearByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start);

    void updateData(Integer deviceId, Integer start, Integer end);
}
