package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.Device;
import com.example.power_prediction.entity.PowerDistributionDay;
import com.example.power_prediction.repository.PowerDistributionDayRepository;
import com.example.power_prediction.service.PowerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImplPowerStatisticsService implements PowerStatisticsService {
    @Autowired
    PowerDistributionDayRepository powerDistributionDayRepository;

    @Override
    public List<Map> findMultipleDevicePowerMsg(String multipleId, Integer dataTime, Integer dayNum, Integer type) {
        String[] idList = multipleId.split(",");
//        List<Integer> idListNew = new ArrayList<>();
        List<Map> mapList = new ArrayList<>();
        for (String deviceId : idList) {
            List<Object[]> powerDistributionDays = powerDistributionDayRepository.findAllByDeviceAndDataTimeBetweenAsc(Integer.valueOf(deviceId), dataTime, dataTime + 86400 * dayNum - 1);
            if(powerDistributionDays.size()==0){
                break;
            }
            Map msgMap = new HashMap();
            msgMap.put("deviceName", powerDistributionDays.get(0)[0]);
            Integer i = 1;
            Double mouthTotalLoad = 0.0;
//            Double mouthTotalLoad = 0.0;
//            Double mouthTotalLoad = 0.0;
//            Double mouthTotalLoad = 0.0;
//            Double mouthTotalLoad = 0.0;
//            Double mouthTotalLoad = 0.0;
//            Double mouthTotalLoad = 0.0;
            for (Object[] o : powerDistributionDays) {
                mouthTotalLoad = Double.valueOf(String.valueOf(o[4])) + mouthTotalLoad;
//                mouthTotalLoad = Double.valueOf(String.valueOf(o[4])) + mouthTotalLoad;
//                mouthTotalLoad = Double.valueOf(String.valueOf(o[4])) + mouthTotalLoad;
//                mouthTotalLoad = Double.valueOf(String.valueOf(o[4])) + mouthTotalLoad;
//                mouthTotalLoad = Double.valueOf(String.valueOf(o[4])) + mouthTotalLoad;
//                mouthTotalLoad = Double.valueOf(String.valueOf(o[4])) + mouthTotalLoad;


                msgMap.put("totalLoad" + i, o[4]);
                msgMap.put("totalKWh" + i, o[5]);
                msgMap.put("highKWh" + i, o[6]);
                msgMap.put("lowKWh" + i, o[7]);
                msgMap.put("midKWh" + i, o[8]);
                msgMap.put("topKWh" + i, o[9]);
                msgMap.put("totalCharge" + i, o[10]);
                msgMap.put("highCharge" + i, o[11]);
                msgMap.put("lowCharge" + i, o[12]);
                msgMap.put("midCharge" + i, o[13]);
                msgMap.put("topCharge" + i, o[14]);
                i++;
            }
            msgMap.put("mouthTotalLoad", mouthTotalLoad);
            mapList.add(msgMap);
        }

        return mapList;
    }
}
