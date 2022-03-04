package com.example.power_prediction.repository;

import com.example.power_prediction.entity.ShiftConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftConfigurationRepository extends JpaRepository<ShiftConfiguration,Integer> {
}
