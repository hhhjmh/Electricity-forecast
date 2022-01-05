package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerPriceTime;
import java.util.List;

public interface PowerPriceTimeService {

    List<PowerPriceTime> findAll();
    String edit(PowerPriceTime powerPriceTime);
}
