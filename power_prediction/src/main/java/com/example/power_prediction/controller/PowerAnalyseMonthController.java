package com.example.power_prediction.controller;

import com.example.power_prediction.entity.*;
import com.example.power_prediction.service.PowerAnalyseMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/findPowerAnalyseMonthAvgByDataTime")
    public List<PowerAnalyseMonthAvg> findPowerAnalyseMonthAvgByDeviceIdAndDataTimeBetween(@RequestBody PowerAnalyseMonthAvg powerAnalyseMonthAvg) {
        //使用id暂存天数
        return powerAnalyseMonthAvgService.findPowerAnalyseMonthAvgByDeviceIdAndDataTimeBetween(powerAnalyseMonthAvg.getDeviceId(), powerAnalyseMonthAvg.getDataTime(), powerAnalyseMonthAvg.getDataTime() + 86400 * 360);
    }

    @PostMapping("/findPowerAnalyseMonthMaxByDataTime")
    public List<PowerAnalyseMonthMax> findPowerAnalyseMonthMaxByDeviceIdAndDataTimeBetween(@RequestBody PowerAnalyseMonthAvg powerAnalyseMonthAvg) {
        //使用id暂存天数
        return powerAnalyseMonthAvgService.findPowerAnalyseMonthMaxByDeviceIdAndDataTimeBetween(powerAnalyseMonthAvg.getDeviceId(), powerAnalyseMonthAvg.getDataTime(), powerAnalyseMonthAvg.getDataTime() + 86400 * 360);
    }
}
