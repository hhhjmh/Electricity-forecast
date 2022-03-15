package com.example.power_prediction.controller;

import com.example.power_prediction.entity.ProductionUnitConfiguration;
import com.example.power_prediction.service.ProductionUnitConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/productionUnitConfiguration")
public class ProductionUnitConfigurationController {
    
    @Autowired
    ProductionUnitConfigurationService productionUnitConfigurationService;

    @PostMapping("/add")
    public void AddProductionUnitConfiguration(@RequestBody ProductionUnitConfiguration productionUnitConfiguration) {
        productionUnitConfigurationService.AddProductionUnitConfiguration(productionUnitConfiguration);
    }

    @PostMapping("/delete")
    public void DeleteProductionUnitConfiguration(@RequestBody ProductionUnitConfiguration productionUnitConfiguration) {
        productionUnitConfigurationService.DeleteProductionUnitConfiguration(productionUnitConfiguration);
    }

    @PostMapping("/update")
    public void UpdateShiftConfiguration(@RequestBody ProductionUnitConfiguration productionUnitConfiguration) {
        productionUnitConfigurationService.UpdateProductionUnitConfiguration(productionUnitConfiguration);
    }

    @PostMapping("/findAll")
    public List<ProductionUnitConfiguration> findAllClassName() {
        return productionUnitConfigurationService.findAll();
    }


}
