package com.example.power_prediction.controller;

import com.example.power_prediction.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/util")
public class UtilController {
    @Autowired
    UtilService utilService;

    @ResponseBody
    @RequestMapping("/insert/{batchSize}")
    public Integer insertPowerRealtime(@PathVariable Integer batchSize){
       return utilService.batchInsertingDataForPowerRealTime(1,3000,1500,50,1000,500,20,3000,50,15,batchSize);
    }
}
