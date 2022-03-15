package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.ProductionUnitConfiguration;
import com.example.power_prediction.repository.ProductionUnitConfigurationRepository;
import com.example.power_prediction.service.ProductionUnitConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplProductionUnitConfigurationService implements ProductionUnitConfigurationService {

    @Autowired
    ProductionUnitConfigurationRepository productionUnitConfigurationRepository;

    @Override
    public void AddProductionUnitConfiguration(ProductionUnitConfiguration productionUnitConfiguration) {
        ProductionUnitConfiguration temp = productionUnitConfigurationRepository.findByWorkshopUnit(productionUnitConfiguration.getWorkshopUnit());
        if(temp==null)
            productionUnitConfigurationRepository.save(productionUnitConfiguration);
    }

    @Override
    public void DeleteProductionUnitConfiguration(ProductionUnitConfiguration productionUnitConfiguration) {
        ProductionUnitConfiguration temp = productionUnitConfigurationRepository.findByWorkshopUnit(productionUnitConfiguration.getWorkshopUnit());
        if(temp!=null)
            productionUnitConfigurationRepository.delete(temp);
    }

    @Override
    public void UpdateProductionUnitConfiguration(ProductionUnitConfiguration productionUnitConfiguration) {
        if(productionUnitConfigurationRepository.findById(productionUnitConfiguration.getId())!=null) {
            productionUnitConfigurationRepository.save(productionUnitConfiguration);
        }
    }

    @Override
    public List<ProductionUnitConfiguration> findAll() {
        return productionUnitConfigurationRepository.findAll();
    }

}
