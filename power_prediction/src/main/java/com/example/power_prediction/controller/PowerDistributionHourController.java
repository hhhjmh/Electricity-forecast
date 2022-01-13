package com.example.power_prediction.controller;

import com.example.power_prediction.service.PowerDistributionHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/powerDistributionHour")
public class PowerDistributionHourController {
    @Autowired
    PowerDistributionHourService powerDistributionHourService;

    @PostMapping("/queryDay")
    public Map<String, Object> queryDay(@RequestParam Integer deviceId, @RequestParam Integer year, @RequestParam Integer month, @RequestParam Integer day) {
        return powerDistributionHourService.queryByDay(deviceId, year, month, day);
    }

    @PostMapping("/hourlyUpdate")
    public Map<String, Object> hourlyUpdate() {
        return powerDistributionHourService.hourlyUpdate();
    }
}
