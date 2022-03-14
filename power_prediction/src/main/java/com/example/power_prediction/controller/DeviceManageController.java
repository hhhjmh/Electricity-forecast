package com.example.power_prediction.controller;


import com.example.power_prediction.entity.Device;
import com.example.power_prediction.entity.DeviceRelationship;
import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.service.DeviceManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/deviceManage")
public class DeviceManageController {
    @Autowired
    DeviceManageService deviceManageService;


    @PostMapping("findAllByState")
    public List<Device> findAllDeviceMsgByState(@RequestBody Device device) {
        return deviceManageService.findAllDeviceMsgByState(device.getState());
    }


    @PostMapping("findAllByIsOrNotDistributionAndState")
    public List<Device> findAllByIsOrNotDistribution(@RequestBody Device device) {
        return deviceManageService.findAllByIsOrNotDistribution(device);
    }


    @PostMapping("findAllByIsOrNotDistributionAndStateAndType")
    public List<Device> findAllByIsOrNotDistributionAndStateAndType(@RequestBody DeviceRelationship deviceRelationship) {
        return deviceManageService.findAllByIsOrNotDistributionAndStateAndType(deviceRelationship);
    }


    @PostMapping("findOneByDeviceId")
    public Device findOneByDeviceId(@RequestBody Device device) {
        return deviceManageService.findOneByDeviceId(device.getId());
    }



    @PostMapping("findAll")
    public List<Device> findAllDeviceMsg() {
        return deviceManageService.findAllDeviceMsg();
    }

    @PostMapping("updateByMultipleIdForDeviceState")
    public Integer updateByMultipleIdForDeviceState(@RequestBody Device device) {

        //name来存多个device的id
        return deviceManageService.updateByMultipleIdForDeviceState(device);
    }

    @PostMapping("addDevice")
    public Integer addDevice(@RequestBody Device device) {
        device.setState(1);
//        device.setUserDepartment("电能体验馆");
        return deviceManageService.save(device);
    }

//    @PostMapping("findAll")
//    public List<Device> findAllDeviceMsg() {
//        return deviceManageService.findAllDeviceMsg();
//    }

    @PostMapping("deleteDevice")
    public Integer deleteDevice(@RequestBody Device device) {
        return deviceManageService.deleteDevice(device);
    }

    @PostMapping("addDeviceRelationship")
    public Integer addDeviceRelationship(@RequestBody DeviceRelationship deviceRelationship) {
        return deviceManageService.addDeviceRelationship(deviceRelationship);
    }

    @PostMapping("addMultipleDeviceRelationship")
    public Integer addMultipleDeviceRelationship(@RequestParam("multipleId") String multipleId
            , @RequestParam("superDeviceId") Integer superDeviceId, @RequestParam("type") Integer type) {

        return deviceManageService.addMultipleDeviceRelationship(multipleId,superDeviceId,type);
    }


    @PostMapping("deleteDeviceRelationship")
    public Integer deleteDeviceRelationship(@RequestBody DeviceRelationship deviceRelationship) {
        return deviceManageService.deleteDeviceRelationship(deviceRelationship);
    }


}
