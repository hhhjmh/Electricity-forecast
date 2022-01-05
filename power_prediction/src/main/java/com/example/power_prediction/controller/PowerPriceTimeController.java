package com.example.power_prediction.controller;


import com.example.power_prediction.entity.PowerPriceTime;
import com.example.power_prediction.entity.User;
import com.example.power_prediction.service.PowerPriceTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/powerPriceTime")
public class PowerPriceTimeController {
    @Autowired
    PowerPriceTimeService powerPriceTimeService;


    @RequestMapping("/listAll")
    public List<PowerPriceTime> listAll() {
        return powerPriceTimeService.findAll();
    }

    @PostMapping("/edit")
    public String edit(@RequestBody User user) {
        return null;
    }


}
