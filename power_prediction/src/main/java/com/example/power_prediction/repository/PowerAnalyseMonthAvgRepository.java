package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerAnalyseMonthAvg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerAnalyseMonthAvgRepository extends JpaRepository<PowerAnalyseMonthAvg,Integer> {
    PowerAnalyseMonthAvg findByDeviceIdAndDataTime(int deviceId, Integer dataTime);

    List<PowerAnalyseMonthAvg> findAllByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);
}
