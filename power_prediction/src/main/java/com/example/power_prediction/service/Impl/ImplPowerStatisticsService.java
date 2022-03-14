package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.Device;
import com.example.power_prediction.entity.PowerDistributionDay;
import com.example.power_prediction.repository.PowerDistributionDayRepository;
import com.example.power_prediction.repository.PowerDistributionHourRepository;
import com.example.power_prediction.service.PowerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ImplPowerStatisticsService implements PowerStatisticsService {
    @Autowired
    PowerDistributionDayRepository powerDistributionDayRepository;
    @Autowired
    PowerDistributionHourRepository powerDistributionHourRepository;


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


                if (type == 1) {   //type选择为1表示适用于月峰谷平尖
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
                    msgMap.put("Quantity" + i + "r", o[5]);
                    i++;
                }

                if (type == 2)//type选择为2表示适用于年电量分析
                {
                    Double mouthTotalKWh1 = 0.0;Double mouthTotalCharge1 = 0.0;
                    Double mouthTotalKWh2 = 0.0;Double mouthTotalCharge2 = 0.0;
                    Double mouthTotalKWh3 = 0.0;Double mouthTotalCharge3 = 0.0;
                    Double mouthTotalKWh4 = 0.0;Double mouthTotalCharge4 = 0.0;
                    Double mouthTotalKWh5 = 0.0;Double mouthTotalCharge5 = 0.0;
                    Double mouthTotalKWh6 = 0.0;Double mouthTotalCharge6 = 0.0;
                    Double mouthTotalKWh7 = 0.0;Double mouthTotalCharge7 = 0.0;
                    Double mouthTotalKWh8 = 0.0;Double mouthTotalCharge8 = 0.0;
                    Double mouthTotalKWh9 = 0.0;Double mouthTotalCharge9 = 0.0;
                    Double mouthTotalKWh10 = 0.0;Double mouthTotalCharge10 = 0.0;
                    Double mouthTotalKWh11 = 0.0;Double mouthTotalCharge11 = 0.0;
                    Double mouthTotalKWh12 = 0.0;Double mouthTotalCharge12 = 0.0;
                    Long timestamp = Long.valueOf(Integer.valueOf(String.valueOf(o[3])));
//                    Long timeStamp = Long.valueOf(timestamp * 1000);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timestamp * 1000L))));
//                    System.out.println(sd);
                    Integer mouth = Integer.valueOf(sd.substring(5, 7));
//                    System.out.println(mouth);
                    switch (mouth) {
                        case 1:
                            mouthTotalKWh1 += Double.valueOf(String.valueOf(o[5]));
                            mouthTotalCharge1 +=Double.valueOf(String.valueOf(o[10]));
                            break;
                        case 2:
                            mouthTotalKWh2 += Double.valueOf(String.valueOf(o[5]));
                            mouthTotalCharge2 +=Double.valueOf(String.valueOf(o[10]));
                            break;
                        case 3:
                            mouthTotalKWh3 += Double.valueOf(String.valueOf(o[5]));
                            mouthTotalCharge3 +=Double.valueOf(String.valueOf(o[10]));
                            break;
                        case 4:
                            mouthTotalKWh4 += Double.valueOf(String.valueOf(o[5]));
                            mouthTotalCharge4 +=Double.valueOf(String.valueOf(o[10]));
                            break;
                        case 5:
                            mouthTotalKWh5 += Double.valueOf(String.valueOf(o[5]));
                            mouthTotalCharge5 +=Double.valueOf(String.valueOf(o[10]));
                            break;
                        case 6:
                            mouthTotalKWh6 += Double.valueOf(String.valueOf(o[5]));
                            mouthTotalCharge6 +=Double.valueOf(String.valueOf(o[10]));
                            break;
                        case 7:
                            mouthTotalKWh7 += Double.valueOf(String.valueOf(o[5]));
                            mouthTotalCharge7 +=Double.valueOf(String.valueOf(o[10]));
                            break;
                        case 8:
                            mouthTotalKWh8 += Double.valueOf(String.valueOf(o[5]));
                            mouthTotalCharge8 +=Double.valueOf(String.valueOf(o[10]));
                            break;
                        case 9:
                            mouthTotalKWh9 += Double.valueOf(String.valueOf(o[5]));
                            mouthTotalCharge9 +=Double.valueOf(String.valueOf(o[10]));
                            break;
                        case 10:
                            mouthTotalKWh10 += Double.valueOf(String.valueOf(o[5]));
                            mouthTotalCharge10 +=Double.valueOf(String.valueOf(o[10]));
                            break;
                        case 11:
                            mouthTotalKWh11 += Double.valueOf(String.valueOf(o[5]));
                            mouthTotalCharge11 +=Double.valueOf(String.valueOf(o[10]));
                            break;
                        case 12:
                            mouthTotalKWh12 += Double.valueOf(String.valueOf(o[5]));
                            mouthTotalCharge12 +=Double.valueOf(String.valueOf(o[10]));
                            break;
                    }
                    msgMap.put("mouthTotalKWh1", String.format("%.2f", (mouthTotalKWh1)));
                    msgMap.put("mouthTotalKWh2", String.format("%.2f", (mouthTotalKWh2)));
                    msgMap.put("mouthTotalKWh3", String.format("%.2f", (mouthTotalKWh3)));
                    msgMap.put("mouthTotalKWh4", String.format("%.2f", (mouthTotalKWh4)));
                    msgMap.put("mouthTotalKWh5", String.format("%.2f", (mouthTotalKWh5)));
                    msgMap.put("mouthTotalKWh6", String.format("%.2f", (mouthTotalKWh6)));
                    msgMap.put("mouthTotalKWh7", String.format("%.2f", (mouthTotalKWh7)));
                    msgMap.put("mouthTotalKWh8", String.format("%.2f", (mouthTotalKWh8)));
                    msgMap.put("mouthTotalKWh9", String.format("%.2f", (mouthTotalKWh9)));
                    msgMap.put("mouthTotalKWh10", String.format("%.2f", (mouthTotalKWh10)));
                    msgMap.put("mouthTotalKWh11", String.format("%.2f", (mouthTotalKWh11)));
                    msgMap.put("mouthTotalKWh12", String.format("%.2f", (mouthTotalKWh12)));

                    msgMap.put("mouthTotalCharge1", String.format("%.2f", (mouthTotalCharge1)));
                    msgMap.put("mouthTotalCharge2", String.format("%.2f", (mouthTotalCharge2)));
                    msgMap.put("mouthTotalCharge3", String.format("%.2f", (mouthTotalCharge3)));
                    msgMap.put("mouthTotalCharge4", String.format("%.2f", (mouthTotalCharge4)));
                    msgMap.put("mouthTotalCharge5", String.format("%.2f", (mouthTotalCharge5)));
                    msgMap.put("mouthTotalCharge6", String.format("%.2f", (mouthTotalCharge6)));
                    msgMap.put("mouthTotalCharge7", String.format("%.2f", (mouthTotalCharge7)));
                    msgMap.put("mouthTotalCharge8", String.format("%.2f", (mouthTotalCharge8)));
                    msgMap.put("mouthTotalCharge9", String.format("%.2f", (mouthTotalCharge9)));
                    msgMap.put("mouthTotalCharge10", String.format("%.2f", (mouthTotalCharge10)));
                    msgMap.put("mouthTotalCharge11", String.format("%.2f", (mouthTotalCharge11)));
                    msgMap.put("mouthTotalCharge12", String.format("%.2f", (mouthTotalCharge12)));
                }

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
            if (type == 3) { //type选择为3表示适用于电量电费分析
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
            }
            mapList.add(msgMap);
        }
        return mapList;
    }

    @Override
    public List<Map> findMultipleDevicePowerMsgForDay(String multipleId, Integer start, Integer end) {

        String[] idList = multipleId.split(",");
//        List<Integer> idListNew = new ArrayList<>();
        List<Map> mapList = new ArrayList<>();
        for (String deviceId : idList) {
            List<Object[]> powerDistributionHours = powerDistributionHourRepository.findAllByDeviceAndDataTimeBetweenAsc(Integer.valueOf(deviceId), start, end);
            if (powerDistributionHours.size() == 0) {
                break;
            }
            Map hourMap = new HashMap();
            if (powerDistributionHours.get(0)[0] != null)
                hourMap.put("deviceName", powerDistributionHours.get(0)[0]);
            else continue;
            if (powerDistributionHours.get(0)[1] == null) {
                hourMap.put("totalKWh", 0);
            } else {
                hourMap.put("totalKWh", String.format("%.2f", powerDistributionHours.get(0)[1]));
            }
            mapList.add(hourMap);
        }
        return mapList;
    }
}

