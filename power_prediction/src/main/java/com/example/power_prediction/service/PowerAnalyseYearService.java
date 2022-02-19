package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerAnalyseYearAvg;
import com.example.power_prediction.entity.PowerAnalyseYearMax;
import com.example.power_prediction.entity.PowerAnalyseYearMin;

public interface PowerAnalyseYearService {
    PowerAnalyseYearAvg getYearAvgByID(int deviceId, Integer dataTime);

    PowerAnalyseYearMax getYearMaxByID(int deviceId, Integer dataTime);

    PowerAnalyseYearMin getYearMinByID(int deviceId, Integer dataTime);
}
