package com.example.power_prediction.service.Impl;


import com.example.power_prediction.entity.PowerPriceTime;
import com.example.power_prediction.repository.PowerPriceTimeRepository;
import com.example.power_prediction.service.PowerPriceTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplPowerPriceTimeService implements PowerPriceTimeService {
    @Autowired
    PowerPriceTimeRepository powerPriceTimeRepository;

    @Override
    public List<PowerPriceTime> findAll() {
        return powerPriceTimeRepository.findAll();
    }

    @Override
    public String edit(PowerPriceTime powerPriceTime) {
        try {
            if (powerPriceTimeRepository.existsById(powerPriceTime.getId())) {
                powerPriceTimeRepository.save(powerPriceTime);
                return "{\"state\":\"Success\"}";
            }else {
                return "{\"state\":\"Fail\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"state\":\"Fail\"}";
        }
    }
}
