package com.example.power_prediction.service;

import java.time.ZoneId;
import java.util.List;
import java.util.Map;

public interface UtilService {

    Integer batchInsertingDataForPowerRealTime(Integer deviceId, Integer loadMax, Integer loadMin, Integer loadBias, Integer reactivePowerMax, Integer reactivePowerMin, Integer reactivePowerBias, Integer I_, Integer IBias, Integer zeroMultiples, Integer batchSize);

    List findAllDeviceRelationship(Integer type);

    Integer batchInsertingDataForPowerDistributionDay(Integer deviceId, Integer dataTime, Integer batchSize, Integer loadMin, Integer loadMax, Integer lowKWhMin, Integer lowKWhMax, Integer bias);

    /**
     * 设置系统时区
     *
     * @param zone 类似 Asia/Shanghai 的格式
     */
    void setZoneId(String zone);


    /**
     * 返回数据库中设置的时区的ZoneId对象，用于其他业务调用
     * 默认Asia/Shanghai
     *
     * @return ZoneId
     */
    ZoneId getZoneId();
}
