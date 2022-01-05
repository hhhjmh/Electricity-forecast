package com.example.power_prediction.controller;

import com.example.power_prediction.entity.DeviceRelationship;
import com.example.power_prediction.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/util")
public class UtilController {
    @Autowired
    UtilService utilService;

    @ResponseBody
    @RequestMapping("/insertPowerRealtime/{batchSize}")
    public Integer insertPowerRealtime(@PathVariable Integer batchSize){
       return utilService.batchInsertingDataForPowerRealTime(1,3000,1500,50,1000,500,20,3000,50,15,batchSize);
    }


    @ResponseBody
    @RequestMapping("/PowerDistribution/{batchSize}")
    public Integer insertPowerDistributionDay(@PathVariable Integer batchSize){
        return utilService.batchInsertingDataForPowerDistributionDay(1,1638547200,batchSize,1500,2500,12000,18000,200);
    }

    @ResponseBody
    @PostMapping("/deviceRelationshipTree")
    public List findAllDeviceRelationship(@RequestBody DeviceRelationship deviceRelationship){
        return utilService.findAllDeviceRelationship(deviceRelationship.getType());
    }



}
