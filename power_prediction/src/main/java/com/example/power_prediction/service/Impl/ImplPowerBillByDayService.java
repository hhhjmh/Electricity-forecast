package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.DeviceRelationship;
import com.example.power_prediction.entity.PowerBillByDay;
import com.example.power_prediction.entity.PowerPriceTime;
import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.repository.*;
import com.example.power_prediction.service.PowerBillByDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.averagingDouble;

@Service
public class ImplPowerBillByDayService implements PowerBillByDayService {
    @Autowired
    PowerBillByDayRepository powerBillByDayRepository;

    @Autowired
    DeviceRelationshipRepository deviceRelationshipRepository;

    @Autowired
    PowerPriceTimeRepository powerPriceTimeRepository;

    @Autowired
    PowerRealtimeRepository powerRealtimeRepository;

    @Autowired
    UtilEntityRepository utilEntityRepository;

    @Override
    public List<PowerBillByDay> findAllByDeviceIdAndDateTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerBillByDayRepository.findAllByDeviceIdAndDateTimeBetween(deviceId, start, end);
    }

    @Override
    public void insertDay(Integer deviceId, Integer time) {
        //如果一天还没过完则不计算
        if ((System.currentTimeMillis() / 1000 - time) < 86400) {
            return;
        }

        //获得设备类型
        DeviceRelationship deviceRelationship = deviceRelationshipRepository.findByDeviceId(deviceId);
        Integer type = deviceRelationship.getType();

        //获取当天的电费计价信息
        PowerPriceTime powerPriceTime = powerPriceTimeRepository.
                findFirstByDeviceTypeIdAndStartTimeLessThanEqualOrderByStartTimeDesc(type, time);

        //获得当天的所有电量数据
        List<PowerRealtime> powerRealtimes = powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(
                deviceId, time, time + 86399);

        //初始化表格
        PowerBillByDay powerBillByDay = new PowerBillByDay();
        powerBillByDay.setDeviceId(deviceId);
        powerBillByDay.setDateTime(time);

/*
        double f_power=0,g_power=0,p_power=0,j_power = 0;
        int f_power_times=0,g_power_times=0,p_power_times=0,j_power_times=0;

        for(PowerRealtime powerRealtime:powerRealtimes){
            int dateTime = powerRealtime.getDataTime();
            if (dateTime >= powerPriceTime.getF_power_startAt() && dateTime < powerPriceTime.getF_power_endAt()) {
                f_power+=Double.parseDouble(powerRealtime.getTotalLoad());
                f_power_times++;
            } else if (dateTime >= powerPriceTime.getG_power_startAt() && dateTime < powerPriceTime.getG_power_endAt()) {
                g_power+=Double.parseDouble(powerRealtime.getTotalLoad());
                g_power_times++;
            } else if (dateTime >= powerPriceTime.getP_power_startAt() && dateTime < powerPriceTime.getP_power_endAt()) {
                p_power+=Double.parseDouble(powerRealtime.getTotalLoad());
                p_power_times++;
            } else if (dateTime >= powerPriceTime.getJ_power_startAt() && dateTime < powerPriceTime.getJ_power_endAt()) {
                j_power+=Double.parseDouble(powerRealtime.getTotalLoad());
                j_power_times++;
            }
        }
*/

        double f_power = powerRealtimes.stream().
                filter(s -> s.getDataTime() >= powerPriceTime.getF_power_startAt() && s.getDataTime() < powerPriceTime.getF_power_endAt()).
                map(PowerRealtime::getTotalLoad).collect(averagingDouble(Double::parseDouble)) *
                (powerPriceTime.getF_power_startAt() - powerPriceTime.getF_power_endAt()) / 3600.0;
        double f_power_price = f_power * Double.parseDouble(powerPriceTime.getF_power_price());
        double g_power = powerRealtimes.stream().
                filter(s -> s.getDataTime() >= powerPriceTime.getG_power_startAt() && s.getDataTime() < powerPriceTime.getG_power_endAt()).
                map(PowerRealtime::getTotalLoad).collect(averagingDouble(Double::parseDouble)) *
                (powerPriceTime.getG_power_startAt() - powerPriceTime.getG_power_endAt()) / 3600.0;
        double g_power_price = g_power * Double.parseDouble(powerPriceTime.getG_power_price());
        double p_power = powerRealtimes.stream().
                filter(s -> s.getDataTime() >= powerPriceTime.getP_power_startAt() && s.getDataTime() < powerPriceTime.getP_power_endAt()).
                map(PowerRealtime::getTotalLoad).collect(averagingDouble(Double::parseDouble)) *
                (powerPriceTime.getP_power_startAt() - powerPriceTime.getP_power_endAt()) / 3600.0;
        double p_power_price = p_power * Double.parseDouble(powerPriceTime.getP_power_price());
        double j_power = powerRealtimes.stream().
                filter(s -> s.getDataTime() >= powerPriceTime.getJ_power_startAt() && s.getDataTime() < powerPriceTime.getJ_power_endAt()).
                map(PowerRealtime::getTotalLoad).collect(averagingDouble(Double::parseDouble)) *
                (powerPriceTime.getJ_power_startAt() - powerPriceTime.getJ_power_endAt()) / 3600.0;
        double j_power_price = j_power * Double.parseDouble(powerPriceTime.getJ_power_price());

        powerBillByDay.setF_power(String.format("%.2f", f_power));
        powerBillByDay.setG_power(String.format("%.2f", g_power));
        powerBillByDay.setP_power(String.format("%.2f", p_power));
        powerBillByDay.setJ_power(String.format("%.2f", j_power));
        powerBillByDay.setF_power_price(String.format("%.2f", f_power_price));
        powerBillByDay.setG_power_price(String.format("%.2f", g_power_price));
        powerBillByDay.setP_power_price(String.format("%.2f", p_power_price));
        powerBillByDay.setJ_power_price(String.format("%.2f", j_power_price));

        powerBillByDayRepository.save(powerBillByDay);
    }
}
