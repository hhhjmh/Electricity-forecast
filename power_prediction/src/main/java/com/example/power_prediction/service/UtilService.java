package com.example.power_prediction.service;

import java.util.List;

public interface UtilService {

    Integer batchInsertingDataForPowerRealTime(Integer deviceId, Integer loadMax, Integer loadMin, Integer loadBias, Integer reactivePowerMax, Integer reactivePowerMin, Integer reactivePowerBias,Integer I_,Integer IBias, Integer zeroMultiples,Integer batchSize);

    List findAllDeviceRelationship(Integer type);

    Integer batchInsertingDataForPowerDistributionDay(Integer deviceId, Integer dataTime, Integer batchSize, Integer loadMin, Integer loadMax, Integer lowKWhMin, Integer lowKWhMax, Integer bias);
}
