package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.PowerAnalyseYearAvg;
import com.example.power_prediction.entity.PowerAnalyseYearMax;
import com.example.power_prediction.entity.PowerAnalyseYearMin;
import com.example.power_prediction.repository.PowerAnalyseYearAvgRepository;
import com.example.power_prediction.repository.PowerAnalyseYearMaxRepository;
import com.example.power_prediction.repository.PowerAnalyseYearMinRepository;
import com.example.power_prediction.service.PowerAnalyseYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplPowerAnalyseYearService implements PowerAnalyseYearService {
    
    @Autowired
    PowerAnalyseYearAvgRepository powerAnalyseYearAvgRepository;

    @Autowired
    PowerAnalyseYearMaxRepository powerAnalyseYearMaxRepository;

    @Autowired
    PowerAnalyseYearMinRepository powerAnalyseYearMinRepository;


    @Override
    public PowerAnalyseYearAvg getYearAvgByID(int deviceId, Integer dataTime) {

        return powerAnalyseYearAvgRepository.findByDeviceIdAndDataTime(deviceId, dataTime);
    }

    @Override
    public PowerAnalyseYearMax getYearMaxByID(int deviceId, Integer dataTime) {

        return powerAnalyseYearMaxRepository.findByDeviceIdAndDataTime(deviceId, dataTime);
    }

    @Override
    public PowerAnalyseYearMin getYearMinByID(int deviceId, Integer dataTime) {

        return powerAnalyseYearMinRepository.findByDeviceIdAndDataTime(deviceId, dataTime);
    }
}
