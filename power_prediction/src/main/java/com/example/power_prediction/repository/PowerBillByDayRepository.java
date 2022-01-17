package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerBillByDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerBillByDayRepository extends JpaRepository<PowerBillByDay, Integer> {
    List<PowerBillByDay> findAllByDeviceIdAndDateTimeStartingWith(Integer deviceId, String date);
    PowerBillByDay findByDeviceIdAndDateTime(Integer deviceId, String date);
}
