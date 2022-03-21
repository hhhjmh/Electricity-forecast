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
    public void AddPowerIndicatorCap(@RequestBody PowerIndicatorCap powerIndicatorCap) {
        powerIndicatorCapService.AddPowerIndicatorCap(powerIndicatorCap);
    }

    @PostMapping("/delete")
    public void DeletePowerIndicatorCap(@RequestBody PowerIndicatorCap powerIndicatorCap) {
        powerIndicatorCapService.DeletePowerIndicatorCap(powerIndicatorCap);
    }

    @PostMapping("/update")
    public void UpdatePowerIndicatorCap(@RequestBody PowerIndicatorCap powerIndicatorCap) {
        powerIndicatorCapService.UpdatePowerIndicatorCap(powerIndicatorCap);
    }



    @PostMapping("/findAllByDeviceId")
    public List<PowerIndicatorCap> findAllByClassName(@RequestBody PowerIndicatorCap powerIndicatorCap) {
        return powerIndicatorCapService.findAllByDeviceId(powerIndicatorCap.getDeviceId());
    }


}
