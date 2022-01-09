package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerBillByDay;
import com.example.power_prediction.entity.PowerPriceTime;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public interface PowerBillByDayService {
    Map<String,Object> queryByMonth(Integer deviceId,Integer year,Integer month);
}
