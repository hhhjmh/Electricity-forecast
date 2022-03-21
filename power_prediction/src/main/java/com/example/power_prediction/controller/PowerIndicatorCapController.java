package com.example.power_prediction.controller;

import com.example.power_prediction.entity.PowerIndicatorCap;
import com.example.power_prediction.service.PowerIndicatorCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/PowerIndicatorCap")
public class PowerIndicatorCapController {

    @Autowired
    PowerIndicatorCapService powerIndicatorCapService;

    @PostMapping("/add")
    public int AddPowerIndicatorCap(@RequestBody PowerIndicatorCap powerIndicatorCap) {
        int ret = powerIndicatorCapService.AddPowerIndicatorCap(powerIndicatorCap);
        return ret;
    }

    @PostMapping("/delete")
    public int DeletePowerIndicatorCap(@RequestBody PowerIndicatorCap powerIndicatorCap) {
        int ret = powerIndicatorCapService.DeletePowerIndicatorCap(powerIndicatorCap);
        return ret;
    }

    @PostMapping("/update")
    public int UpdatePowerIndicatorCap(@RequestBody PowerIndicatorCap powerIndicatorCap) {
        int ret = powerIndicatorCapService.UpdatePowerIndicatorCap(powerIndicatorCap);
        return ret;
    }



    @PostMapping("/findAllByDeviceId")
    public List<PowerIndicatorCap> findAllByClassName(@RequestBody PowerIndicatorCap powerIndicatorCap) {
        return powerIndicatorCapService.findAllByDeviceId(powerIndicatorCap.getDeviceId());
    }


}
