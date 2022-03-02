package com.example.power_prediction.service;

import java.util.List;
import java.util.Map;

public interface PowerStatisticsService {


    List<Map> findMultipleDevicePowerMsg(String multipleId, Integer dataTime, Integer dayNum, Integer type);
}
