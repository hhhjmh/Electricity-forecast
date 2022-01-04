package com.example.power_prediction.controller;

import com.example.power_prediction.entity.PowerAnalyseDayAvg;
import com.example.power_prediction.entity.PowerAnalyseDayMax;
import com.example.power_prediction.entity.PowerAnalyseDayMin;
import com.example.power_prediction.service.PowerAnalyseDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/PowerAnalyse")
public class PowerAnalyseDayController {

    @Autowired
    PowerAnalyseDayService powerAnalyseDayAvgService;

    @PostMapping("/DayAvg")
    public PowerAnalyseDayAvg powerAnalyseDayAvgByID(@RequestBody PowerAnalyseDayAvg powerAnalyseDayAvg) {
        return powerAnalyseDayAvgService.getDayAvgByID(powerAnalyseDayAvg.getDeviceId(), powerAnalyseDayAvg.getDataTime());
    }

    @PostMapping("/DayMax")
    public PowerAnalyseDayMax powerAnalyseDayMaxByID(@RequestBody PowerAnalyseDayMax powerAnalyseDayMax) {
        return powerAnalyseDayAvgService.getDayMaxByID(powerAnalyseDayMax.getDeviceId(), powerAnalyseDayMax.getDataTime());
    }

    @PostMapping("/DayMin")
    public PowerAnalyseDayMin powerAnalyseDayMinByID(@RequestBody PowerAnalyseDayMin powerAnalyseDayMin) {
        return powerAnalyseDayAvgService.getDayMinByID(powerAnalyseDayMin.getDeviceId(), powerAnalyseDayMin.getDataTime());
    }
}
