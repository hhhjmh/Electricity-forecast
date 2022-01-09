package com.example.power_prediction.service.Impl;


import com.example.power_prediction.entity.DeviceRelationship;
import com.example.power_prediction.entity.PowerPriceTime;
import com.example.power_prediction.repository.DeviceRelationshipRepository;
import com.example.power_prediction.repository.PowerPriceTimeRepository;
import com.example.power_prediction.service.PowerPriceTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ImplPowerPriceTimeService implements PowerPriceTimeService {
    @Autowired
    PowerPriceTimeRepository powerPriceTimeRepository;

    @Autowired
    DeviceRelationshipRepository deviceRelationshipRepository;


    @Override
    public List<PowerPriceTime> findAll() {
        return powerPriceTimeRepository.findAll();
    }

    @Override
    public String edit(PowerPriceTime powerPriceTime) {
        try {
            if (powerPriceTimeRepository.existsById(powerPriceTime.getId())) {
                powerPriceTimeRepository.save(powerPriceTime);
                return "{\"state\":\"Success\"}";
            } else {
                return "{\"state\":\"Fail\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"state\":\"Fail\"}";
        }
    }

    public Map<String, Double> getTimeLast() {
        return null;
    }

    @Override
    public String del(Integer id) {
        try {
            Optional<PowerPriceTime> optional = powerPriceTimeRepository.findById(id);
            if (optional.isPresent()) {
                powerPriceTimeRepository.delete(optional.get());
                return "{\"state\":\"Success\"}";
            } else {
                return "{\"state\":\"Fail\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"state\":\"Fail\"}";
        }
    }

    @Override
    public String add(PowerPriceTime powerPriceTime) {
        try {
            if (powerPriceTime.getId() == null) {
                powerPriceTimeRepository.save(powerPriceTime);
                return "{\"state\":\"Success\"}";
            } else {
                return "{\"state\":\"Fail\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"state\":\"Fail\"}";
        }
    }

    @Override
    public Map<String, Object> getDevicePowerPriceInTime(Integer deviceId, Integer time) {
        Map<String, Object> map = new HashMap<>();
        try {
            //获得设备类型
            DeviceRelationship deviceRelationship = deviceRelationshipRepository.findByDeviceId(deviceId);
            Integer type = deviceRelationship.getType();

            //获取当天的电费计价信息
            PowerPriceTime powerPriceTime = powerPriceTimeRepository.findFirstByDeviceTypeIdAndStartTimeLessThanEqualOrderByStartTimeDesc(type, time);

            Map<String, Object> f = mappedLocalTime(powerPriceTime.getF_power_startAt(), powerPriceTime.getF_power_endAt());
            f.put("price", powerPriceTime.getF_power_price());
            Map<String, Object> g = mappedLocalTime(powerPriceTime.getG_power_startAt(), powerPriceTime.getG_power_endAt());
            g.put("price", powerPriceTime.getG_power_price());
            Map<String, Object> p = mappedLocalTime(powerPriceTime.getP_power_startAt(), powerPriceTime.getP_power_endAt());
            p.put("price", powerPriceTime.getP_power_price());
            Map<String, Object> j = mappedLocalTime(powerPriceTime.getJ_power_startAt(), powerPriceTime.getJ_power_endAt());
            j.put("price", powerPriceTime.getJ_power_price());

            map.put("f", f);
            map.put("g", g);
            map.put("p", p);
            map.put("j", j);
            map.put("startTime", powerPriceTime.getStartTime());
            map.put("id", powerPriceTime.getId());
            map.put("state", "Success");
        } catch (Exception e) {
            map.put("state", "Fail");
            e.printStackTrace();
        }
        return map;
    }


    private Map<String, Object> mappedLocalTime(String start, String end) {
        Map<String, Object> map = new HashMap<>();
        List<LocalTime> starts = Stream.of(start.split(",")).map(LocalTime::parse).collect(Collectors.toList());
        List<LocalTime> ends = Stream.of(end.split(",")).map(LocalTime::parse).collect(Collectors.toList());
        map.put("start", starts);
        map.put("end", ends);
        return map;
    }
}

