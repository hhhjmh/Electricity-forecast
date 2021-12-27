package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerDistributionDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerDistributionDayRepository extends JpaRepository<PowerDistributionDay,Integer> {
}
