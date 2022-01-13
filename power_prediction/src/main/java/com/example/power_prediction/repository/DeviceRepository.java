package com.example.power_prediction.repository;

import com.example.power_prediction.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device,Integer> {
    Device findAllById(Integer id);

}
