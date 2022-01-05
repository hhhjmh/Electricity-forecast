package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerBillByDay;
import java.util.List;

public interface PowerBillByDayService {
    /**
     * 查找以日为界限的账单信息
     * @param deviceId 设备ID
     * @param start 开始时间 时间戳
     * @param end 结束时间 时间戳
     * @return 表中所有符合的信息
     */
    List<PowerBillByDay> findAllByDeviceIdAndDateTimeBetween(Integer deviceId,Integer start,Integer end);
}