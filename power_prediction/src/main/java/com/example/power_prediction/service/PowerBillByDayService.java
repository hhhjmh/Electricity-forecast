package com.example.power_prediction.service;

import java.util.Map;

public interface PowerBillByDayService {
    Map<String, Object> queryByMonth(Integer deviceId, Integer year, Integer month);

    Map<String, Object> queryByYear(Integer deviceId, Integer year);

    Map<String, Object> dailyUpdate();

    /**
     * @param deviceIds 设备id，多个用","分割
     * @param start     开始时间，单位为day 则为2022-01-01 单位为month则为 2022-01
     * @param end       结束时间，单位为day 则为2022-01-01 单位为month则为 2022-01
     * @param unit      单位 day或者month
     * @return 第一层 时间 第二次 设备id 第三层数据
     */
    Map<String, Object> queryCustom(String deviceIds, String start, String end, String unit);

    Map<String, Object> queryCostMonth(Integer year, Integer month, String department);

    Map<String, Object> queryCostYear(Integer year, String department);

}
