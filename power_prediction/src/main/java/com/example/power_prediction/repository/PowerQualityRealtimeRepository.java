package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerDistributionHour;
import com.example.power_prediction.entity.PowerQualityRealtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerQualityRealtimeRepository extends JpaRepository<PowerQualityRealtime,Integer> {
    List<PowerQualityRealtime> findAllByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);
}
