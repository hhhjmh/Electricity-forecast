package com.example.power_prediction.controller;


import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.service.PowerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/powerStatistics")
public class PowerStatisticsController {
    @Autowired
    PowerStatisticsService powerStatisticsService;

    @PostMapping("/findMultipleDevicePowerMsg")
    public List<Map> findMultipleDevicePowerMsg(@RequestParam("multipleId") String multipleId
            , @RequestParam("dataTime") Integer dataTime, @RequestParam("dayNum") Integer dayNum, @RequestParam("type") Integer type) {

        //使用id暂存天数
        return  powerStatisticsService.findMultipleDevicePowerMsg(multipleId,dataTime,dayNum,type);
    }
}
