package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.PowerDistributionDay;
import com.example.power_prediction.entity.PowerDistributionHour;
import com.example.power_prediction.entity.PowerQualityRealtime;
import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.repository.*;
import com.example.power_prediction.service.UtilService;
import com.example.power_prediction.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ImplUtilService implements UtilService {
    @Autowired
    PowerRealtimeRepository powerRealtimeRepository;
    @Autowired
    DeviceRelationshipRepository deviceRelationshipRepository;
    @Autowired
    PowerDistributionDayRepository powerDistributionDayRepository;
    @Autowired
    PowerDistributionHourRepository powerDistributionHourRepository;
    @Autowired
    UtilEntityRepository utilEntityRepository;
    @Autowired
    PowerQualityRealtimeRepository powerQualityRealtimeRepository;

    @Override
    public Integer batchInsertingDataForPowerRealTime(Integer dataTime, Integer deviceId, Integer loadMax, Integer loadMin, Integer loadBias, Integer reactivePowerMax, Integer reactivePowerMin, Integer reactivePowerBias, Integer I_, Integer IBias, Integer zeroMultiples, Integer batchSize) {
        try {
            long now = System.currentTimeMillis();
            for (int a = 0; a < batchSize; a++) {
                PowerRealtime powerRealtime = new PowerRealtime();
                //设置5分钟间隔
                now = now - now % (1000 * 60 * 5) + (1000 * 60 * 5);

//                powerRealtime.setDataTime(Math.toIntExact(now / 1000));
                powerRealtime.setDataTime(dataTime);
                dataTime = dataTime + 60 * 5;
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

                powerRealtime.setTotalPowerFactor(String.format("%.4f", (1 - Math.random() / 10)));
                powerRealtime.setaPowerFactor(String.format("%.4f", (1 - Math.random() / 10)));
                powerRealtime.setbPowerFactor(String.format("%.4f", (1 - Math.random() / 10)));
                powerRealtime.setcPowerFactor(String.format("%.4f", (1 - Math.random() / 10)));

                powerRealtime.setUa(String.format("%.2f", (230 - Math.random() * 10)));
                powerRealtime.setUb(String.format("%.2f", (230 - Math.random() * 10)));
                powerRealtime.setUc(String.format("%.2f", (230 - Math.random() * 10)));

                powerRealtime.setIa(String.format("%.2f", (I_ - Math.random() * IBias)));
                powerRealtime.setIb(String.format("%.2f", (I_ - Math.random() * IBias)));
                powerRealtime.setIc(String.format("%.2f", (I_ - Math.random() * IBias)));
                powerRealtime.setZeroi((String.format("%.2f", (I_ - Math.random() * IBias) / zeroMultiples)));

                powerRealtime.setUab(String.format("%.2f", (400 - Math.random() * 20)));
                powerRealtime.setUbc(String.format("%.2f", (400 - Math.random() * 20)));
                powerRealtime.setUca(String.format("%.2f", (400 - Math.random() * 20)));

                powerRealtimeRepository.save(powerRealtime);
            }
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }

    }

    @Override
    public Integer batchInsertingDataForPowerDistributionDay(Integer deviceId, Integer dataTime, Integer batchSize, Integer loadMin, Integer loadMax, Integer lowKWhMin, Integer lowKWhMax, Integer bias) {
        try {

            //System.out.println(utilEntityRepository.findByVariableAttributeNameAndState("highPowerRate", 1));
            Double highPowerRate = Double.valueOf(utilEntityRepository.findByVariableAttributeNameAndState("highPowerRate", 1).getVariableAttributeNum());
            Double lowPowerRate = Double.valueOf(utilEntityRepository.findByVariableAttributeNameAndState("lowPowerRate", 1).getVariableAttributeNum());
            Double midPowerRate = Double.valueOf(utilEntityRepository.findByVariableAttributeNameAndState("midPowerRate", 1).getVariableAttributeNum());
            for (int i = 0; i < batchSize; i++) {
                PowerDistributionDay powerDistributionDay = new PowerDistributionDay();
                powerDistributionDay.setDeviceId(deviceId);
                Double lowKWh = lowKWhMin + (Math.random() * (lowKWhMax - lowKWhMin));
                Double highKWh = lowKWh / 2 - Math.random() * bias;
                Double midKWh = lowKWh / 5 + Math.random() * bias;
                Double totalKWh = lowKWh + highKWh + midKWh;
                powerDistributionDay.setTotalLoad(String.format("%.2f", loadMin + (Math.random() * (loadMax - loadMin))));

                powerDistributionDay.setMidKWh(String.format("%.2f", midKWh));
                powerDistributionDay.setHighKWh(String.format("%.2f", highKWh));
                powerDistributionDay.setLowKWh(String.format("%.2f", lowKWh));
                powerDistributionDay.setTotalkWh(String.format("%.2f", totalKWh));

                Double highCharge = highKWh * highPowerRate;
                Double lowCharge = lowKWh * lowPowerRate;
                Double midCharge = midKWh * midPowerRate;
                Double totalCharge = highCharge + lowCharge + midCharge;

                powerDistributionDay.setHighCharge(String.format("%.2f", highCharge));
                powerDistributionDay.setLowCharge(String.format("%.2f", lowCharge));
                powerDistributionDay.setMidCharge(String.format("%.2f", midCharge));
                powerDistributionDay.setTotalCharge(String.format("%.2f", totalCharge));


                powerDistributionDay.setTopCharge(String.valueOf(0));
                powerDistributionDay.setTopKWh(String.valueOf(0));
                powerDistributionDay.setDataTime(dataTime);

                dataTime = dataTime + (60 * 60 * 24);
                powerDistributionDayRepository.save(powerDistributionDay);

            }
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }


    }

    @Override
    public Integer batchInsertingDataForPowerQualityRealtime(Integer deviceId, Integer start, Integer end, Integer IPhd, Integer IPhdBias, Integer UPhd, Integer UPhdBias) {
        try {
            List<PowerRealtime> powerRealtimeList = powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
            for (PowerRealtime powerRealtime : powerRealtimeList
            ) {
                PowerQualityRealtime powerQualityRealtime = calculatePowerQualityRealtime(powerRealtime);
                powerQualityRealtime.setFrequencyDeviation(String.format("%.2f", -0.05 + Math.random() / 10));
                Double basicIPhd = IPhd - Math.random() * IPhdBias;
                powerQualityRealtime.setIaPhd(String.format("%.2f", (basicIPhd + Math.random())));
                powerQualityRealtime.setIbPhd(String.format("%.2f", (basicIPhd + Math.random())));
                powerQualityRealtime.setIcPhd(String.format("%.2f", (basicIPhd + Math.random())));
                Double basicUPhd = UPhd - Math.random() * UPhdBias;
                powerQualityRealtime.setUaPhd(String.format("%.2f", (basicUPhd + Math.random())));
                powerQualityRealtime.setUbPhd(String.format("%.2f", (basicUPhd + Math.random())));
                powerQualityRealtime.setUcPhd(String.format("%.2f", (basicUPhd + Math.random())));


                powerQualityRealtimeRepository.save(powerQualityRealtime);
            }

            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }

    }

    @Override
    public Integer batchInsertingDataForPowerDistributionHour(Integer deviceId, Integer start, Integer batchSize, Integer basicKWh, Integer highKWh) {
        try {
            for (int i = 0; i < batchSize; i++) {
                PowerDistributionHour powerDistributionHour = new PowerDistributionHour();
                powerDistributionHour.setDataTime(start);
                powerDistributionHour.setDeviceId(deviceId);
                Double totalKWh = basicKWh + (Math.random() * (highKWh - basicKWh));
                powerDistributionHour.setTotalKWh(String.format("%.2f", (totalKWh)));
                powerDistributionHourRepository.save(powerDistributionHour);
                start += 300;
            }
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }

    }

    public PowerQualityRealtime calculatePowerQualityRealtime(PowerRealtime powerRealtime) {
        PowerQualityRealtime powerQualityRealtime = new PowerQualityRealtime();
        Double basicU = 220.0;
        Double basicUu = 380.0;
        powerQualityRealtime.setUaDeviation(String.format("%.2f", (Double.valueOf(powerRealtime.getUa()) - basicU) / basicU * 100));
        powerQualityRealtime.setUbDeviation(String.format("%.2f", (Double.valueOf(powerRealtime.getUb()) - basicU) / basicU * 100));
        powerQualityRealtime.setUcDeviation(String.format("%.2f", (Double.valueOf(powerRealtime.getUc()) - basicU) / basicU * 100));
        powerQualityRealtime.setuUabDeviation(String.format("%.2f", (Double.valueOf(powerRealtime.getUab()) - basicUu) / basicUu * 100));
        powerQualityRealtime.setuUbcDeviation(String.format("%.2f", (Double.valueOf(powerRealtime.getUbc()) - basicUu) / basicUu * 100));
        powerQualityRealtime.setuUcaDeviation(String.format("%.2f", (Double.valueOf(powerRealtime.getUca()) - basicUu) / basicUu * 100));
        powerQualityRealtime.setDataTime(powerRealtime.getDataTime());
        powerQualityRealtime.setDeviceId(powerRealtime.getDeviceId());
        Double Ua = Double.valueOf(powerRealtime.getUa());
        Double Ub = Double.valueOf(powerRealtime.getUb());
        Double Uc = Double.valueOf(powerRealtime.getUc());
        Double Umin = Ua;
        Double Umax = Ua;
        if (Ub < Umin) {
            Umin = Ub;
        }
        if (Uc < Umin) {
            Umin = Uc;
        }
        if (Ub > Umax) {
            Umax = Ub;
        }
        if (Uc > Umax) {
            Umax = Uc;
        }
        Double Ia = Double.valueOf(powerRealtime.getIa());
        Double Ib = Double.valueOf(powerRealtime.getIb());
        Double Ic = Double.valueOf(powerRealtime.getIc());
        Double Imin = Ia;
        Double Imax = Ia;
        if (Ib < Imin) {
            Imin = Ib;
        }
        if (Ic < Imin) {
            Imin = Ic;
        }
        if (Ib > Imax) {
            Imax = Ib;
        }
        if (Ic > Imax) {
            Imax = Ic;
        }
        powerQualityRealtime.setiUnbalance(String.format("%.2f", (Umax - Umin) / Umax * 100));
        powerQualityRealtime.setuUnbalance(String.format("%.2f", (Imax - Imin) / Imax * 100));


        return powerQualityRealtime;
    }

    @Override
    public List findAllDeviceRelationship(Integer type, String userDepartment, Integer method) {

        ArrayList arrayList = new ArrayList();
        List<Object[]> objects = new ArrayList<>();
        if (method == 0) {
            objects = deviceRelationshipRepository.findDeviceRelationshipAndUserDepartment(type, userDepartment);
        } else if (method == 1) {
            objects = deviceRelationshipRepository.findDeviceRelationship(type);
        }
        if (objects == null) {
            System.out.println("error");
            return null;
        } else {
            for (Object[] o : objects
            ) {
                Map<String, Object> topMap = new HashMap<>();
                if (o[4] == null) { //superDeviceID为null
                    topMap.put("label", o[0]);
                    topMap.put("children", recursionTree(objects, (Integer) o[2], type));
                    topMap.put("id", o[1]);
                    arrayList.add(topMap);
                }

            }
            return arrayList;
        }
    }

    public ArrayList recursionTree(List<Object[]> objects, Integer topId, Integer type) {
        ArrayList arrayList = new ArrayList();
        String deviceName = null;
        for (Object[] o : objects) {

            if (o[5] != null && o[4] == topId) {
                List<Object[]> newObjects = deviceRelationshipRepository.findDeviceRelationshipBySuperDeviceId(type, (Integer) o[2]);
                if (newObjects == null)
                    break;
                ArrayList arrayList1 = recursionTree(newObjects, (Integer) o[2], type);

                Map map = new HashMap();
                map.put("children", arrayList1);
                map.put("label", o[0]);
                map.put("id", o[1]);

                if (deviceName != null && deviceName.equals((String) o[0])) {
                    break;
                }

                deviceName = (String) o[0];
                arrayList.add(map);
            } else if (o[4] == topId) {
                Map<String, Object> subMap = new HashMap<>();
                subMap.put("label", o[0]);
                subMap.put("id", o[1]);
                arrayList.add(subMap);
            }
        }
        return arrayList;
    }


}
