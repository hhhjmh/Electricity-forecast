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

    /**
     * 多设备自定义时间戳查询
     * @param deviceIds 多设备用“,”分割
     * @param start 开始的时间戳
     * @param end 结束的时间戳
     * @param unit 统计单位间隔的小时，0则是整个为一段
     * @return 第一层设备，第二层数据
     */
    Map<String, Object> queryByDayMulti(String deviceIds, Integer start, Integer end, Integer unit);
}
