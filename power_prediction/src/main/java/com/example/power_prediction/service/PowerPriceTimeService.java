package com.example.power_prediction.service;

import com.example.power_prediction.entity.PowerPriceTime;
import java.util.List;

public interface PowerPriceTimeService {

    List<PowerPriceTime> findAll();
    String edit(PowerPriceTime powerPriceTime);
    String del(Integer id);
    String add(PowerPriceTime powerPriceTime);
}
