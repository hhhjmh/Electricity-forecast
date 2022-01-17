package com.example.power_prediction.service;

import java.util.Map;

public interface PowerDistributionHourService {

    /**
     * 每小时的定时任务，供前端访问更新
     *
     * @return Success Fail
     */
    Map<String, Object> hourlyUpdate();

    /**
     * 查询指定一天的功耗数据
     *
     * @param deviceId 设备id
     * @param year     年
     * @param month    月
     * @param day      日
     */
    Map<String, Object> queryByDay(Integer deviceId, Integer year, Integer month, Integer day);
}
