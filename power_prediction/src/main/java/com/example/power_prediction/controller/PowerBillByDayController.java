package com.example.power_prediction.controller;

import com.example.power_prediction.entity.PowerBillByDay;
import com.example.power_prediction.service.PowerBillByDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/powerBillByDay")
public class PowerBillByDayController {
    @Autowired
    PowerBillByDayService powerBillByDayService;

    /**
     * 查询指定时间段内指定设备的电费信息<br>
     * @param deviceId 设备ID
     * @param start 开始时间戳
     * @param end 结束时间戳
     * @return
     */
    @RequestMapping("/listBill")
    public List<PowerBillByDay> listBill(@RequestParam Integer deviceId,@RequestParam Integer start,@RequestParam Integer end){
        return powerBillByDayService.findAllByDeviceIdAndDateTimeBetween(deviceId,start,end);
    }
}
