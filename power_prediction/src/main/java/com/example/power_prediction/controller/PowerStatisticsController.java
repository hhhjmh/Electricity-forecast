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


    /**
     *
     *
     * @param type   1月峰谷平尖   2年电量分析   3电量电费分析
     */

    @PostMapping("/findMultipleDevicePowerMsgForMouth")
    public List<Map> findMultipleDevicePowerMsgForMouth(@RequestParam("multipleId") String multipleId
            , @RequestParam("dataTime") Integer dataTime, @RequestParam("dayNum") Integer dayNum, @RequestParam("type") Integer type) {
        return  powerStatisticsService.findMultipleDevicePowerMsg(multipleId,dataTime,dayNum,type);
    }

    @PostMapping("/findMultipleDevicePowerMsgForYear")
    public List<Map> findMultipleDevicePowerMsgForYear(@RequestParam("multipleId") String multipleId
            , @RequestParam("dataTime") Integer dataTime, @RequestParam("dayNum") Integer dayNum, @RequestParam("type") Integer type) {
        return  powerStatisticsService.findMultipleDevicePowerMsg(multipleId,dataTime,dayNum,type);
    }

    @PostMapping("/findMultipleDevicePowerMsgForDay")
    public List<Map> findMultipleDevicePowerMsgForDay(@RequestParam("multipleId") String multipleId
            , @RequestParam("start") Integer start, @RequestParam("end") Integer end) {
        return  powerStatisticsService.findMultipleDevicePowerMsgForDay(multipleId,start,end);
    }
}
