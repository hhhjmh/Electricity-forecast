package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerDistributionHour;
import com.example.power_prediction.entity.PowerRealtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerDistributionHourRepository extends JpaRepository<PowerDistributionHour,Integer> {
    List<PowerDistributionHour> findAllByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);
    List<PowerDistributionHour> findAllByDeviceIdAndDataTimeBetweenOrderByDataTimeDesc(Integer deviceId, Integer start, Integer end);


    PowerDistributionHour findByDeviceIdAndDataTime(Integer deviceId, Integer dataTime);
}
