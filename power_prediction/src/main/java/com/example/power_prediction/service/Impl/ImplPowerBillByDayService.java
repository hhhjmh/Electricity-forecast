package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.PowerBillByDay;
import com.example.power_prediction.repository.PowerBillByDayRepository;
import com.example.power_prediction.service.PowerBillByDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplPowerBillByDayService implements PowerBillByDayService {
    @Autowired
    PowerBillByDayRepository powerBillByDayRepository;

    @Override
    public List<PowerBillByDay> findAllByDeviceIdAndDateTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerBillByDayRepository.findAllByDeviceIdAndDateTimeBetween(deviceId, start, end);
    }
}
