package com.example.power_prediction.repository;


import com.example.power_prediction.entity.PowerElectricalSafety;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerElectricalSafetyRepository extends JpaRepository<PowerElectricalSafety,Integer> {
    List<PowerElectricalSafety> findAllByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);

    PowerElectricalSafety findByDeviceIdAndDataTime(int deviceId, Integer dataTime);
}
