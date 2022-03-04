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
            if (powerDistributionDays.size() == 0) {
                break;
            }
            Map msgMap = new HashMap();
            msgMap.put("deviceName", powerDistributionDays.get(0)[0]);
            Integer i = 1;
            Double mouthTotalKWh = 0.0;
            Double mouthHighKWh = 0.0;
            Double mouthLowKWh = 0.0;
            Double mouthMidKWh = 0.0;
            Double mouthTopKWh = 0.0;
            Double mouthTotalCharge = 0.0;
            Double mouthHighCharge = 0.0;
            Double mouthLowCharge = 0.0;
            Double mouthMidCharge = 0.0;
            Double mouthTopCharge = 0.0;

            for (Object[] o : powerDistributionDays) {
                mouthTotalKWh = Double.valueOf(String.valueOf(o[5])) + mouthTotalKWh;
                mouthHighKWh = Double.valueOf(String.valueOf(o[6])) + mouthHighKWh;
                mouthLowKWh = Double.valueOf(String.valueOf(o[7])) + mouthLowKWh;
                mouthMidKWh = Double.valueOf(String.valueOf(o[8])) + mouthMidKWh;
                mouthTopKWh = Double.valueOf(String.valueOf(o[9])) + mouthTopKWh;
                mouthTotalCharge = Double.valueOf(String.valueOf(o[10])) + mouthTotalCharge;
                mouthHighCharge = Double.valueOf(String.valueOf(o[11])) + mouthHighCharge;
                mouthLowCharge = Double.valueOf(String.valueOf(o[12])) + mouthLowCharge;
                mouthMidCharge = Double.valueOf(String.valueOf(o[13])) + mouthMidCharge;
                mouthTopCharge = Double.valueOf(String.valueOf(o[14])) + mouthTopCharge;


                msgMap.put("Quantity" + i + "r", o[5]);
                msgMap.put(i + "totalLoad", o[4]);
                msgMap.put(i + "haototal", o[5]);
                msgMap.put(i + "haof", o[6]);
                msgMap.put(i + "haog", o[7]);
                msgMap.put(i + "haop", o[8]);
                msgMap.put(i + "haoj", o[9]);
                msgMap.put("totalCharge" + i, o[10]);
                msgMap.put("highCharge" + i, o[11]);
                msgMap.put("lowCharge" + i, o[12]);
                msgMap.put("midCharge" + i, o[13]);
                msgMap.put("topCharge" + i, o[14]);
                i++;
            }
            msgMap.put("mouthTotalKWh", String.format("%.2f", (mouthTotalKWh)));
            msgMap.put("mouthHighKWh", String.format("%.2f", (mouthHighKWh)));
            msgMap.put("mouthLowKWh", String.format("%.2f", (mouthLowKWh)));
            msgMap.put("mouthMidKWh", String.format("%.2f", (mouthMidKWh)));
            msgMap.put("mouthTopKWh", String.format("%.2f", (mouthTopKWh)));
            msgMap.put("mouthTotalCharge", String.format("%.2f", (mouthTotalCharge)));
            msgMap.put("mouthHighCharge", String.format("%.2f", (mouthHighCharge)));
            msgMap.put("mouthLowCharge", String.format("%.2f", (mouthLowCharge)));
            msgMap.put("mouthMidCharge", String.format("%.2f", (mouthMidCharge)));
            msgMap.put("mouthTopCharge", String.format("%.2f", (mouthTopCharge)));


            if (mouthTotalKWh != 0) {
                msgMap.put("mouthHighKWhPercentage", String.format("%.2f", (mouthHighKWh / mouthTotalKWh)));
                msgMap.put("mouthLowKWhPercentage", String.format("%.2f", (mouthLowKWh / mouthTotalKWh)));
                msgMap.put("mouthMidKWhPercentage", String.format("%.2f", (mouthMidKWh / mouthTotalKWh)));
                msgMap.put("mouthTopKWhPercentage", String.format("%.2f", (mouthTopKWh / mouthTotalKWh)));
            }
            if (mouthTotalCharge != 0) {
                msgMap.put("mouthHighChargePercentage", String.format("%.2f", (mouthHighCharge / mouthTotalCharge)));
                msgMap.put("mouthLowChargePercentage", String.format("%.2f", (mouthLowCharge / mouthTotalCharge)));
                msgMap.put("mouthMidChargePercentage", String.format("%.2f", (mouthMidCharge / mouthTotalCharge)));
                msgMap.put("mouthTopChargePercentage", String.format("%.2f", (mouthTopCharge / mouthTotalCharge)));
            }
            mapList.add(msgMap);
        }
        return mapList;
    }
}

