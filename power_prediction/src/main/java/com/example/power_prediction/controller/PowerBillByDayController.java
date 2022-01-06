package com.example.power_prediction.controller;

import com.example.power_prediction.entity.PowerBillByDay;
import com.example.power_prediction.service.PowerBillByDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/powerBillByDay")
public class PowerBillByDayController {
    @Autowired
    PowerBillByDayService powerBillByDayService;

/*
    /**
     * 查询指定时间段内指定设备的电费信息<br>
     *
     * @param deviceId 设备ID
     * @param start    开始时间戳
     * @param end      结束时间戳
     * @return
     * /
    @RequestMapping("/listBill")
    public List<PowerBillByDay> listBill(@RequestParam Integer deviceId, @RequestParam Integer start, @RequestParam Integer end) {
        return powerBillByDayService.findAllByDeviceIdAndDateTimeBetween(deviceId, start, end);
    }
*/

    @PostMapping("/queryMonth")
    public Map<String, Object> queryMonth(@RequestParam Integer deviceId, @RequestParam Integer year, @RequestParam Integer month) {
        return powerBillByDayService.queryByMonth(deviceId, year, month);
    }
}
