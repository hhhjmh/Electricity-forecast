package com.example.power_prediction.controller;

import com.example.power_prediction.entity.PowerAnalyseYearAvg;
import com.example.power_prediction.entity.PowerAnalyseYearMax;
import com.example.power_prediction.entity.PowerAnalyseYearMin;
import com.example.power_prediction.service.PowerAnalyseYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/PowerAnalyse")
public class PowerAnalyseYearController {
    @Autowired
    PowerAnalyseYearService powerAnalyseYearAvgService;

    @PostMapping("/YearAvg")
    public PowerAnalyseYearAvg powerAnalyseYearAvgByID(@RequestBody PowerAnalyseYearAvg powerAnalyseYearAvg) {
        return powerAnalyseYearAvgService.getYearAvgByID(powerAnalyseYearAvg.getDeviceId(), powerAnalyseYearAvg.getDataTime());
    }

    @PostMapping("/YearMax")
    public PowerAnalyseYearMax powerAnalyseYearMaxByID(@RequestBody PowerAnalyseYearMax powerAnalyseYearMax) {
        return powerAnalyseYearAvgService.getYearMaxByID(powerAnalyseYearMax.getDeviceId(), powerAnalyseYearMax.getDataTime());
    }

    @PostMapping("/YearMin")
    public PowerAnalyseYearMin powerAnalyseYearMinByID(@RequestBody PowerAnalyseYearMin powerAnalyseYearMin) {
        return powerAnalyseYearAvgService.getYearMinByID(powerAnalyseYearMin.getDeviceId(), powerAnalyseYearMin.getDataTime());
    }
}
