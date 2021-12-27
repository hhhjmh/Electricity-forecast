package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.repository.PowerRealtimeRepository;
import com.example.power_prediction.service.PowerRealtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplPowerRealtimeService implements PowerRealtimeService {
    @Autowired
    PowerRealtimeRepository powerRealtimeRepository;

    @Override
    public List<PowerRealtime> findAllByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
    }
}
