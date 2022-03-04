package com.example.power_prediction.repository;

import com.example.power_prediction.entity.ProductionUnitConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionUnitConfigurationRepository extends JpaRepository<ProductionUnitConfiguration,Integer> {
}
