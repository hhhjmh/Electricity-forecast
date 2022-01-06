package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerDistributionDay;
import com.example.power_prediction.entity.PowerDistributionHour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerDistributionDayRepository extends JpaRepository<PowerDistributionDay,Integer> {
    List<PowerDistributionDay> findAllByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);

}
