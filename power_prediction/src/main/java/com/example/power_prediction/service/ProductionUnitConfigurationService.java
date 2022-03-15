package com.example.power_prediction.service;

import com.example.power_prediction.entity.ProductionUnitConfiguration;

import java.util.List;

public interface ProductionUnitConfigurationService {

    void AddProductionUnitConfiguration(ProductionUnitConfiguration productionUnitConfiguration);

    void DeleteProductionUnitConfiguration(ProductionUnitConfiguration productionUnitConfiguration);

    void UpdateProductionUnitConfiguration(ProductionUnitConfiguration productionUnitConfiguration);

    List<ProductionUnitConfiguration> findAll();

}
