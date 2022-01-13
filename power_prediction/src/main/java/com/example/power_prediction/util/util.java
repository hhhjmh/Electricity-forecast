package com.example.power_prediction.util;

import com.example.power_prediction.repository.DeviceRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class util {


    public static Map divideData(Integer max, Integer min, Integer bias) {

        Double total = min + (Math.random() * (max - min));
        Double a = total / 3 + Math.random() * bias;
        Double b = total / 3 - Math.random() * bias;
        Double c = total - a - b;
        Map map = new HashMap();
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);
        map.put("total", total);
        return map;
    }
}
