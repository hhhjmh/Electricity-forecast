package com.example.power_prediction.controller;

import com.example.power_prediction.entity.PowerDistributionDay;
import com.example.power_prediction.entity.PowerDistributionHour;
import com.example.power_prediction.entity.PowerQualityRealtime;
import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.repository.PowerRealtimeRepository;
import com.example.power_prediction.service.PowerRealtimeService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/powerRealtime")
public class PowerRealtimeController {
    @Autowired
    PowerRealtimeService powerRealtimeService;



    @PostMapping("/findPowerRealtimeByDataTime")
    public List<PowerRealtime> findPowerRealtimeByDeviceIdAndDataTimeBetween(@RequestBody PowerRealtime powerRealtime) {
        if (powerRealtime.getId() ==0) {
            powerRealtime.setId(1);
        }
        //使用id暂存天数
        return powerRealtimeService.findPowerRealtimeByDeviceIdAndDataTimeBetween(powerRealtime.getDeviceId(), powerRealtime.getDataTime(), powerRealtime.getDataTime() + 86400 * powerRealtime.getId());
    }


    @PostMapping("/findPowerDistributionHourByDataTime")
    public List<PowerDistributionHour> findPowerDistributionHourByDeviceIdAndDataTimeBetween(@RequestBody PowerDistributionHour powerDistributionHour) {
        if (powerDistributionHour.getId() ==0) {
            powerDistributionHour.setId(1);
        }
        //使用id暂存天数
        return powerRealtimeService.findPowerDistributionHourByDeviceIdAndDataTimeBetween(powerDistributionHour.getDeviceId(), powerDistributionHour.getDataTime(), powerDistributionHour.getDataTime() + 86400 * powerDistributionHour.getId());
    }

    @PostMapping("/findPowerQualityRealtimeByDataTime")
    public List<PowerQualityRealtime> findPowerQualityRealtimeByDeviceIdAndDataTimeBetween(@RequestBody PowerQualityRealtime powerQualityRealtime) {
        if (powerQualityRealtime.getId() ==0) {
            powerQualityRealtime.setId(1);
        }
        //使用id暂存天数
        return powerRealtimeService.findPowerQualityRealtimeByDeviceIdAndDataTimeBetween(powerQualityRealtime.getDeviceId(), powerQualityRealtime.getDataTime(), powerQualityRealtime.getDataTime() + 86400 * powerQualityRealtime.getId());
    }

    @PostMapping("/findPowerDistributionDayByDataTime")
    public List<PowerDistributionDay> findPowerDistributionDayByDeviceIdAndDataTimeBetween(@RequestBody PowerDistributionDay powerDistributionDay) {
        if (powerDistributionDay.getId() ==0) {
            powerDistributionDay.setId(1);
        }
        //使用id暂存天数
        return powerRealtimeService.findPowerDistributionDayByDeviceIdAndDataTimeBetween(powerDistributionDay.getDeviceId(), powerDistributionDay.getDataTime(), powerDistributionDay.getDataTime() + 86400 * powerDistributionDay.getId());
}

//    @RequestMapping("/findPowerRealtimeByDataTime")
//    public List<PowerRealtime> findPowerRealtimeByDataTime(@RequestBody PowerRealtime powerRealtime) {
//        return powerRealtimeService.findAllPowerRealtimeByDataTime(powerRealtime.getDeviceId(), powerRealtime.getDataTime());
//    }


}
