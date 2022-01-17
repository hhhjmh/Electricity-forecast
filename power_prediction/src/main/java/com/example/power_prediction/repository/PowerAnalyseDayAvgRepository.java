package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerAnalyseDayAvg;
import com.example.power_prediction.entity.PowerRealtime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerAnalyseDayAvgRepository extends JpaRepository<PowerAnalyseDayAvg,Integer> {
    PowerAnalyseDayAvg findByDeviceIdAndDataTime(int deviceId, Integer dataTime);

    List<PowerAnalyseDayAvg> findAllByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);
}
