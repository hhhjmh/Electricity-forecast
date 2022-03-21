package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerIndicatorCap;

import java.util.List;

public interface PowerIndicatorCapService {

    void AddPowerIndicatorCap(PowerIndicatorCap powerIndicatorCap);

    void DeletePowerIndicatorCap(PowerIndicatorCap powerIndicatorCap);

    void UpdatePowerIndicatorCap(PowerIndicatorCap powerIndicatorCap);

    List<PowerIndicatorCap> findAllByDeviceId(int deviceId);


}
