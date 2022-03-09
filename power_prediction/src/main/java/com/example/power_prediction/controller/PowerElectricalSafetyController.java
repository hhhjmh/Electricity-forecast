package com.example.power_prediction.controller;


import com.example.power_prediction.entity.PowerElectricalSafety;
import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.service.PowerElectricalSafetyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/PowerSafe")
public class PowerElectricalSafetyController {

    @Autowired
    PowerElectricalSafetyService powerElectricalSafetyService;

    @PostMapping("/findMonthByDataTime")
    public List<PowerElectricalSafety> findMonthByDeviceIdAndDataTimeBetween(@RequestBody PowerElectricalSafety powerElectricalSafety) {
        //使用id暂存天数
        String timestampString = powerElectricalSafety.getDataTime().toString();
        int number = getMonth(timestampString);
        return powerElectricalSafetyService.findPowerElectricalSafetyByDeviceIdAndDataTimeBetween(powerElectricalSafety.getDeviceId(), powerElectricalSafety.getDataTime(), powerElectricalSafety.getDataTime() + 86400 * number-1);
    }

    @PostMapping("/findYearByDataTime")
    public List<PowerElectricalSafety> findYearByDeviceIdAndDataTimeBetween(@RequestBody PowerElectricalSafety powerElectricalSafety) {
        //使用id暂存天数
        return powerElectricalSafetyService.findYearByDeviceIdAndDataTimeBetween(powerElectricalSafety.getDeviceId(), powerElectricalSafety.getDataTime());
    }



    @PostMapping("/MonthUpdate")
    public void MonthUpdate(@RequestBody PowerElectricalSafety powerElectricalSafety) {
        if (powerElectricalSafety.getId() == 0) {
            powerElectricalSafety.setId(1);
        }
        for(int i=0; i<31; i++) {
            int time = 86400;
            powerElectricalSafetyService.updateData(powerElectricalSafety.getDeviceId(), powerElectricalSafety.getDataTime() + time*i, powerElectricalSafety.getDataTime() + 86400  + time*i);
        }
    }

    @PostMapping("/YearUpdate")
    public void YearUpdate(@RequestBody PowerElectricalSafety powerElectricalSafety) {
        for(int i=0; i<365; i++) {
            int time = 86400;
            powerElectricalSafetyService.updateData(powerElectricalSafety.getDeviceId(), powerElectricalSafety.getDataTime() + time*i, powerElectricalSafety.getDataTime() + 86400  + time*i);
        }
    }

    /*
    @PostMapping("/Date")
    public void change(@RequestBody PowerElectricalSafety powerElectricalSafety) {
        String timestampString = powerElectricalSafety.getDataTime().toString();
        int number = getMonth(timestampString);
    }*/

    public int getMonth(String timestampString) {
        Long timestamp = Long.parseLong(timestampString)*1000;
        String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(timestamp));
        int month = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));
        int day = 0;
        if(month==1 || month==3 ||month==5 ||month==7 ||month==8 ||month==10 ||month==12)
            day = 31;
        else if(month==4 ||month==6 ||month==9 ||month==11)
            day = 30;
        else
            day = (year%4==0) ? 29 : 28;
        return day;

    }
}
