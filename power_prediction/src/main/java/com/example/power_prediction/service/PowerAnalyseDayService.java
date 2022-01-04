package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerAnalyseDayAvg;
import com.example.power_prediction.entity.PowerAnalyseDayMax;
import com.example.power_prediction.entity.PowerAnalyseDayMin;

public interface PowerAnalyseDayService {
    PowerAnalyseDayAvg getDayAvgByID(int deviceId, Integer dataTime);

    PowerAnalyseDayMax getDayMaxByID(int deviceId, Integer dataTime);

    PowerAnalyseDayMin getDayMinByID(int deviceId, Integer dataTime);
}
