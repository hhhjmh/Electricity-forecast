package com.example.power_prediction.service;

import java.util.Map;

public interface PowerBillByDayService {
    Map<String,Object> queryByMonth(Integer deviceId,Integer year,Integer month);
    Map<String,Object> queryByYear(Integer deviceId,Integer year);
    Map<String,Object> dailyUpdate();
}
