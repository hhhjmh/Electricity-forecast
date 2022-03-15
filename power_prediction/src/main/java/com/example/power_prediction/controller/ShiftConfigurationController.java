package com.example.power_prediction.controller;


import com.example.power_prediction.entity.ShiftConfiguration;
import com.example.power_prediction.service.ShiftConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/shiftConfiguration")
public class ShiftConfigurationController {

    @Autowired
    ShiftConfigurationService shiftConfigurationService;

    @PostMapping("/add")
    public void AddShiftConfiguration(@RequestBody ShiftConfiguration shiftConfiguration) {
        shiftConfigurationService.AddShiftConfiguration(shiftConfiguration);
    }

    @PostMapping("/delete")
    public void DeleteShiftConfiguration(@RequestBody ShiftConfiguration shiftConfiguration) {
        shiftConfigurationService.DeleteShiftConfiguration(shiftConfiguration);
    }

    @PostMapping("/update")
    public void UpdateShiftConfiguration(@RequestBody ShiftConfiguration shiftConfiguration) {
        shiftConfigurationService.UpdateShiftConfiguration(shiftConfiguration);
    }



    @PostMapping("/findAllByClassName")
    public List<ShiftConfiguration> findAllByClassName(@RequestBody ShiftConfiguration shiftConfiguration) {
        return shiftConfigurationService.findAllByClassName(shiftConfiguration.getClassName());
    }

    @PostMapping("/findAll")
    public List<String> findAllClassName() {
        return shiftConfigurationService.findAllClassName();
    }

}
