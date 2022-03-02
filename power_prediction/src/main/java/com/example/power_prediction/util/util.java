package com.example.power_prediction.util;

import com.example.power_prediction.repository.DeviceRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class util {

    public static String randomNumeric(int a) {

        String num = "";
        for (int i = 0; i < a; i++) {
            num = num + String.valueOf((int) Math.floor(Math.random() * 9 + 1));
        }
        return num;

    }


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
