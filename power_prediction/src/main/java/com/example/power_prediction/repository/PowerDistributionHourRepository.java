package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerDistributionHour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerDistributionHourRepository extends JpaRepository<PowerDistributionHour,Integer> {
}
