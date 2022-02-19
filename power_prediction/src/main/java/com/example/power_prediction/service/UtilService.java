package com.example.power_prediction.service;

import java.time.ZoneId;
import java.util.List;
import java.util.Map;

public interface UtilService {


    Integer batchInsertingDataForPowerRealTime(Integer dataTime, Integer deviceId, Integer loadMax, Integer loadMin, Integer loadBias, Integer reactivePowerMax, Integer reactivePowerMin, Integer reactivePowerBias, Integer I_, Integer IBias, Integer zeroMultiples, Integer batchSize);

//    Integer batchInsertingDataForPowerRealTime(Integer deviceId, Integer loadMax, Integer loadMin, Integer loadBias, Integer reactivePowerMax, Integer reactivePowerMin, Integer reactivePowerBias, Integer I_, Integer IBias, Integer zeroMultiples, Integer batchSize);


    List findAllDeviceRelationship(Integer type, String userDepartment, Integer method);

    Integer batchInsertingDataForPowerDistributionDay(Integer deviceId, Integer dataTime, Integer batchSize, Integer loadMin, Integer loadMax, Integer lowKWhMin, Integer lowKWhMax, Integer bias);


    Integer batchInsertingDataForPowerQualityRealtime(Integer deviceId, Integer start, Integer end, Integer IPhd, Integer IPhdBias, Integer UPhd, Integer UPhdBias);

    Integer batchInsertingDataForPowerDistributionHour(Integer deviceId, Integer start, Integer batchSize, Integer basicKWh, Integer highKWh);


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

    /**
     * 获得设备树下的主变设备id
     *
     * @param deviceTree findAllDeviceRelationship得到的设备树
     * @return 设备id的List
     */
    List<Integer> getMainTransformer(List<Map<String, Object>> deviceTree);

}
