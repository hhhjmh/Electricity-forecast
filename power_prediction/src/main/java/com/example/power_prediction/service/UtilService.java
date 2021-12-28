package com.example.power_prediction.service;

public interface UtilService {

    Integer batchInsertingDataForPowerRealTime(Integer deviceId, Integer loadMax, Integer loadMin, Integer loadBias, Integer reactivePowerMax, Integer reactivePowerMin, Integer reactivePowerBias,Integer I_,Integer IBias, Integer zeroMultiples,Integer batchSize);

}
