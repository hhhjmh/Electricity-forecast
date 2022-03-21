package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerIndicatorCap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerIndicatorCapRepository extends JpaRepository<PowerIndicatorCap,Integer> {

    PowerIndicatorCap findByDeviceIdAndTypes(int deviceId, String types);

    List<PowerIndicatorCap> findAllByDeviceId(int deviceId);
}
