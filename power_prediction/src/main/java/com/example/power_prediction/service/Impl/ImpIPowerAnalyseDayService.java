package com.example.power_prediction.service.Impl;


import com.example.power_prediction.entity.PowerAnalyseDayAvg;
import com.example.power_prediction.entity.PowerAnalyseDayMax;
import com.example.power_prediction.entity.PowerAnalyseDayMin;
import com.example.power_prediction.repository.PowerAnalyseDayAvgRepository;
import com.example.power_prediction.repository.PowerAnalyseDayMaxRepository;
import com.example.power_prediction.repository.PowerAnalyseDayMinRepository;
import com.example.power_prediction.service.PowerAnalyseDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpIPowerAnalyseDayService implements PowerAnalyseDayService {

    @Autowired
    PowerAnalyseDayAvgRepository powerAnalyseDayAvgRepository;

    @Autowired
    PowerAnalyseDayMaxRepository powerAnalyseDayMaxRepository;

    @Autowired
    PowerAnalyseDayMinRepository powerAnalyseDayMinRepository;

    @Override
    public PowerAnalyseDayAvg getDayAvgByID(int deviceId, Integer dataTime) {

        return powerAnalyseDayAvgRepository.findByDeviceIdAndDataTime(deviceId, dataTime);
    }

    @Override
    public PowerAnalyseDayMax getDayMaxByID(int deviceId, Integer dataTime) {

        return powerAnalyseDayMaxRepository.findByDeviceIdAndDataTime(deviceId, dataTime);
    }

    @Override
    public PowerAnalyseDayMin getDayMinByID(int deviceId, Integer dataTime) {

        return powerAnalyseDayMinRepository.findByDeviceIdAndDataTime(deviceId, dataTime);
    }
}
