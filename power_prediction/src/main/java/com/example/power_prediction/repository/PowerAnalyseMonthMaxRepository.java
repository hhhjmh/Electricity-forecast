package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerAnalyseMonthMax;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerAnalyseMonthMaxRepository extends JpaRepository<PowerAnalyseMonthMax,Integer> {
    PowerAnalyseMonthMax findByDeviceIdAndDataTime(int deviceId, Integer dataTime);

    List<PowerAnalyseMonthMax> findAllByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);
}
