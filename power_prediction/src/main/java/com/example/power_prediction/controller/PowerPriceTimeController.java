package com.example.power_prediction.controller;


import com.example.power_prediction.entity.PowerPriceTime;
import com.example.power_prediction.service.PowerPriceTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/powerPriceTime")
public class PowerPriceTimeController {
    @Autowired
    PowerPriceTimeService powerPriceTimeService;

    @RequestMapping("/listAll")
    public List<PowerPriceTime> listAll() {
        return powerPriceTimeService.findAll();
    }

    @PostMapping("/edit")
    public String edit(@RequestBody PowerPriceTime powerPriceTime) {
        return powerPriceTimeService.edit(powerPriceTime);
    }

    @PostMapping("/del")
    public String del(@RequestParam Integer id){
        return powerPriceTimeService.del(id);
    }

    @PostMapping("/add")
    public String add(@RequestBody PowerPriceTime powerPriceTime){
        return powerPriceTimeService.add(powerPriceTime);
    }

}
