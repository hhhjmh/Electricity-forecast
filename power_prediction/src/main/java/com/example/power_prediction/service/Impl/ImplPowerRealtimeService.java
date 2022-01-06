package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.PowerDistributionDay;
import com.example.power_prediction.entity.PowerDistributionHour;
import com.example.power_prediction.entity.PowerQualityRealtime;
import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.repository.PowerDistributionDayRepository;
import com.example.power_prediction.repository.PowerDistributionHourRepository;
import com.example.power_prediction.repository.PowerQualityRealtimeRepository;
import com.example.power_prediction.repository.PowerRealtimeRepository;
import com.example.power_prediction.service.PowerRealtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplPowerRealtimeService implements PowerRealtimeService {
    @Autowired
    PowerRealtimeRepository powerRealtimeRepository;
    @Autowired
    PowerDistributionHourRepository powerDistributionHourRepository;
    @Autowired
    PowerQualityRealtimeRepository powerQualityRealtimeRepository;
    @Autowired
    PowerDistributionDayRepository powerDistributionDayRepository;

    @Override
    public List<PowerRealtime> findPowerRealtimeByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
    }

    @Override
    public List<PowerDistributionHour> findPowerDistributionHourByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerDistributionHourRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
    }

    @Override
    public List<PowerQualityRealtime> findPowerQualityRealtimeByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerQualityRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
    }

    @Override
    public List<PowerDistributionDay> findPowerDistributionDayByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerDistributionDayRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
    }


//    @Override
//    public List<PowerRealtime> findAllPowerRealtimeByDataTime(Integer deviceId, Integer dataTime) {
//
//        return
//    }
}
