package com.example.power_prediction.controller;

import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.repository.PowerRealtimeRepository;
import com.example.power_prediction.service.PowerRealtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/powerRealtime")
public class PowerRealtimeController {
    @Autowired
    PowerRealtimeService powerRealtimeService;

//    @RequestMapping("/findAllByDeviceIdAndDataTimeBetween")
//    public  List<PowerRealtime> findAllByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end){
//      return powerRealtimeService.findAllByDeviceIdAndDataTimeBetween(deviceId,start,end);
//  }

    @RequestMapping("/findPowerRealtimeByDataTime")
    public List<PowerRealtime> findPowerRealtimeByDataTime(@RequestBody PowerRealtime powerRealtime) {
        return powerRealtimeService.findAllPowerRealtimeByDataTime(powerRealtime.getDeviceId(), powerRealtime.getDataTime());
    }


}
