package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerAnalyseMonthMax;
import com.example.power_prediction.entity.PowerAnalyseYearMax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerAnalyseYearMaxRepository extends JpaRepository<PowerAnalyseYearMax,Integer> {
    PowerAnalyseYearMax findByDeviceIdAndDataTime(int deviceId, Integer dataTime);
}
