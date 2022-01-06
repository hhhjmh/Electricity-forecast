package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerPriceTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PowerPriceTimeRepository extends JpaRepository<PowerPriceTime, Integer> {

}
