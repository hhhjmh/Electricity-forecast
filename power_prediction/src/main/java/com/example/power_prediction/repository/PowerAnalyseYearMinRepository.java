package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerAnalyseMonthMax;
import com.example.power_prediction.entity.PowerAnalyseYearMin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerAnalyseYearMinRepository extends JpaRepository<PowerAnalyseYearMin,Integer> {
    PowerAnalyseYearMin findByDeviceIdAndDataTime(int deviceId, Integer dataTime);
}
