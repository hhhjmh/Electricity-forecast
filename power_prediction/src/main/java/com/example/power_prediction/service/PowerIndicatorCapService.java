package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerIndicatorCap;

import java.util.List;

public interface PowerIndicatorCapService {

    int AddPowerIndicatorCap(PowerIndicatorCap powerIndicatorCap);

    int DeletePowerIndicatorCap(PowerIndicatorCap powerIndicatorCap);

    int UpdatePowerIndicatorCap(PowerIndicatorCap powerIndicatorCap);

    List<PowerIndicatorCap> findAllByDeviceId(int deviceId);


}
