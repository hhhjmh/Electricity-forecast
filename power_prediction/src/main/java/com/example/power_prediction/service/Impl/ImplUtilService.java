package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.repository.PowerRealtimeRepository;
import com.example.power_prediction.service.UtilService;
import com.example.power_prediction.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class ImplUtilService implements UtilService {
    @Autowired
    PowerRealtimeRepository powerRealtimeRepository;

    @Override
    public Integer batchInsertingDataForPowerRealTime(Integer deviceId, Integer loadMax, Integer loadMin, Integer loadBias, Integer reactivePowerMax, Integer reactivePowerMin, Integer reactivePowerBias,Integer I_,Integer IBias, Integer zeroMultiples,Integer batchSize) {
        try {
            long now = System.currentTimeMillis();
            for (int a = 0; a < batchSize; a++) {
                PowerRealtime powerRealtime = new PowerRealtime();
                //设置5分钟间隔
                now = now - now % (1000 * 60 * 5) + (1000 * 60 * 5);
                powerRealtime.setDataTime(Integer.parseInt(String.valueOf(now/1000)));
                powerRealtime.setDeviceId(deviceId);


                Map loadMap = util.divideData(loadMax, loadMin, loadBias);
                powerRealtime.setTotalLoad(String.format("%.2f", loadMap.get("total")));
                powerRealtime.setaLoad(String.format("%.2f", loadMap.get("a")));
                powerRealtime.setbLoad(String.format("%.2f", loadMap.get("b")));
                powerRealtime.setcLoad(String.format("%.2f", loadMap.get("c")));

                Map reactivePowerMap = util.divideData(reactivePowerMax, reactivePowerMin, reactivePowerBias);
                powerRealtime.setTotalReactivePower(String.format("%.2f", reactivePowerMap.get("total")));
                powerRealtime.setaReactivePower(String.format("%.2f", reactivePowerMap.get("a")));
                powerRealtime.setbReactivePower(String.format("%.2f", reactivePowerMap.get("b")));
                powerRealtime.setcReactivePower(String.format("%.2f", reactivePowerMap.get("c")));

                powerRealtime.setTotalPowerFactor(String.format("%.4f",(1 - Math.random() / 10)));
                powerRealtime.setaPowerFactor(String.format("%.4f",(1 - Math.random() / 10)));
                powerRealtime.setbPowerFactor(String.format("%.4f",(1 - Math.random() / 10)));
                powerRealtime.setcPowerFactor(String.format("%.4f",(1 - Math.random() / 10)));

                powerRealtime.setUa(String.format("%.2f",(230 - Math.random() * 10)));
                powerRealtime.setUb(String.format("%.2f",(230 - Math.random() * 10)));
                powerRealtime.setUc(String.format("%.2f",(230 - Math.random() * 10)));

                powerRealtime.setIa(String.format("%.2f",(I_ - Math.random() * IBias)));
                powerRealtime.setIb(String.format("%.2f",(I_ - Math.random() * IBias)));
                powerRealtime.setIc(String.format("%.2f",(I_ - Math.random() * IBias)));
                powerRealtime.setZeroi((String.format("%.2f",(I_ - Math.random() * IBias)/zeroMultiples)));

                powerRealtime.setUab(String.format("%.2f",(400 - Math.random() * 20)));
                powerRealtime.setUbc(String.format("%.2f",(400 - Math.random() * 20)));
                powerRealtime.setUca(String.format("%.2f",(400 - Math.random() * 20)));

                powerRealtimeRepository.save(powerRealtime);
            }
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }

    }

}
