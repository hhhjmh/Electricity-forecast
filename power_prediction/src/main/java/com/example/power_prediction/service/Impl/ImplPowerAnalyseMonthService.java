package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.PowerAnalyseMonthAvg;
import com.example.power_prediction.entity.PowerAnalyseMonthMax;
import com.example.power_prediction.entity.PowerAnalyseMonthMin;
import com.example.power_prediction.repository.*;
import com.example.power_prediction.service.PowerAnalyseMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplPowerAnalyseMonthService implements PowerAnalyseMonthService {

    @Autowired
    PowerAnalyseMonthAvgRepository powerAnalyseMonthAvgRepository;

    @Autowired
    PowerAnalyseMonthMaxRepository powerAnalyseMonthMaxRepository;

    @Autowired
    PowerAnalyseMonthMinRepository powerAnalyseMonthMinRepository;
    

    @Override
    public PowerAnalyseMonthAvg getMonthAvgByID(int deviceId, Integer dataTime) {

        return powerAnalyseMonthAvgRepository.findByDeviceIdAndDataTime(deviceId, dataTime);
    }

    @Override
    public PowerAnalyseMonthMax getMonthMaxByID(int deviceId, Integer dataTime) {

        return powerAnalyseMonthMaxRepository.findByDeviceIdAndDataTime(deviceId, dataTime);
    }

    @Override
    public PowerAnalyseMonthMin getMonthMinByID(int deviceId, Integer dataTime) {

        return powerAnalyseMonthMinRepository.findByDeviceIdAndDataTime(deviceId, dataTime);
    }
}
