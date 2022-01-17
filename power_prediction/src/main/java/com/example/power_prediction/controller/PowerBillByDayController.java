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

    @PostMapping("/queryYear")
    public Map<String, Object> queryYear(@RequestParam Integer deviceId, @RequestParam Integer year) {
        return powerBillByDayService.queryByYear(deviceId, year);
    }

    @PostMapping("/queryCustom")
    public Map<String, Object> queryCustom(@RequestParam String deviceIds, @RequestParam String start, @RequestParam String end, @RequestParam String unit) {
        return powerBillByDayService.queryCustom(deviceIds, start, end, unit);
    }

    @PostMapping("/queryCostMonth")
    public Map<String, Object> queryCostMonth(@RequestParam Integer year,@RequestParam Integer month,@RequestParam String department) {
        return powerBillByDayService.queryCostMonth(year,month,department);
    }

    @PostMapping("/queryCostYear")
    public Map<String, Object> queryCostYear(@RequestParam Integer year,@RequestParam String department) {
        return powerBillByDayService.queryCostYear(year,department);
    }

    @PostMapping("/dailyUpdate")
    public Map<String, Object> dailyUpdate() {
        return powerBillByDayService.dailyUpdate();
    }
}
