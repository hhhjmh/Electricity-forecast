package com.example.power_prediction.service;


import com.example.power_prediction.entity.PowerAnalyseMonthAvg;
import com.example.power_prediction.entity.PowerAnalyseMonthMax;
import com.example.power_prediction.entity.PowerAnalyseMonthMin;

public interface PowerAnalyseMonthService {
    PowerAnalyseMonthAvg getMonthAvgByID(int deviceId, Integer dataTime);

    PowerAnalyseMonthMax getMonthMaxByID(int deviceId, Integer dataTime);

    PowerAnalyseMonthMin getMonthMinByID(int deviceId, Integer dataTime);
}
