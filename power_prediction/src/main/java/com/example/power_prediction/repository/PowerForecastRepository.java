package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerForecast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerForecastRepository extends JpaRepository<PowerForecast,Integer> {
}
