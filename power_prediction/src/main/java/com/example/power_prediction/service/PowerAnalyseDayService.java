package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerAnalyseDayAvg;
import com.example.power_prediction.entity.PowerAnalyseDayMax;
import com.example.power_prediction.entity.PowerAnalyseDayMin;

import java.util.List;

public interface PowerAnalyseDayService {
    PowerAnalyseDayAvg getDayAvgByID(int deviceId, Integer dataTime);

    PowerAnalyseDayMax getDayMaxByID(int deviceId, Integer dataTime);

    PowerAnalyseDayMin getDayMinByID(int deviceId, Integer dataTime);

    void getMax(Integer deviceId, Integer start, Integer end);

    void getMin(Integer deviceId, Integer start, Integer end);

    void getAvg(Integer deviceId, Integer start, Integer end);

    List<PowerAnalyseDayAvg> findPowerAnalyseDayAvgByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);

    List<PowerAnalyseDayMax> findPowerAnalyseDayMaxByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);

    List<String> getDistributionHour(Integer deviceId, Integer start, Integer end);

}
