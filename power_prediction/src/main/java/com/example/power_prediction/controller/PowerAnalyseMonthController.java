package com.example.power_prediction.controller;

import com.example.power_prediction.entity.PowerAnalyseMonthAvg;
import com.example.power_prediction.entity.PowerAnalyseMonthMax;
import com.example.power_prediction.entity.PowerAnalyseMonthMin;
import com.example.power_prediction.service.PowerAnalyseMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/PowerAnalyse")
public class PowerAnalyseMonthController {
    @Autowired
    PowerAnalyseMonthService powerAnalyseMonthAvgService;

    @PostMapping("/MonthAvg")
    public PowerAnalyseMonthAvg powerAnalyseMonthAvgByID(@RequestBody PowerAnalyseMonthAvg powerAnalyseMonthAvg) {
        return powerAnalyseMonthAvgService.getMonthAvgByID(powerAnalyseMonthAvg.getDeviceId(), powerAnalyseMonthAvg.getDataTime());
    }

    @PostMapping("/MonthMax")
    public PowerAnalyseMonthMax powerAnalyseMonthMaxByID(@RequestBody PowerAnalyseMonthMax powerAnalyseMonthMax) {
        return powerAnalyseMonthAvgService.getMonthMaxByID(powerAnalyseMonthMax.getDeviceId(), powerAnalyseMonthMax.getDataTime());
    }

    @PostMapping("/MonthMin")
    public PowerAnalyseMonthMin powerAnalyseMonthMinByID(@RequestBody PowerAnalyseMonthMin powerAnalyseMonthMin) {
        return powerAnalyseMonthAvgService.getMonthMinByID(powerAnalyseMonthMin.getDeviceId(), powerAnalyseMonthMin.getDataTime());
    }
}
