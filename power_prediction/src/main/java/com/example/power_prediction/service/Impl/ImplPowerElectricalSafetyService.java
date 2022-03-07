package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.PowerElectricalSafety;
import com.example.power_prediction.entity.PowerElectricalSafety;
import com.example.power_prediction.entity.PowerElectricalSafety;
import com.example.power_prediction.repository.PowerElectricalSafetyRepository;
import com.example.power_prediction.service.PowerElectricalSafetyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplPowerElectricalSafetyService implements PowerElectricalSafetyService {

    @Autowired
    PowerElectricalSafetyRepository powerElectricalSafetyRepository;

    @Override
    public List<PowerElectricalSafety> findPowerElectricalSafetyByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerElectricalSafetyRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
    }

    @Override
    public void updateData(Integer deviceId, Integer start, Integer end) {

        PowerElectricalSafety powerElectricalSafety = new PowerElectricalSafety();
        powerElectricalSafety.setDeviceId(deviceId);
        powerElectricalSafety.setDataTime(start);
        int temp = (int)(Math.random()*10);
        powerElectricalSafety.setTotalLoad(temp);
        powerElectricalSafety.setaLoad(0);
        powerElectricalSafety.setbLoad(0);
        powerElectricalSafety.setcLoad(0);
        powerElectricalSafety.setIa(0);
        powerElectricalSafety.setIb(0);
        powerElectricalSafety.setIc(0);
        powerElectricalSafety.setZeroi(0);
        powerElectricalSafety.setUa(0);
        powerElectricalSafety.setUb(0);
        powerElectricalSafety.setUc(0);
        powerElectricalSafety.setUab(0);
        powerElectricalSafety.setUbc(0);
        powerElectricalSafety.setUca(0);

        powerElectricalSafety.setTemperature(0);
        powerElectricalSafety.setiUnbalance(0);
        powerElectricalSafety.setuUnbalance(0);

        powerElectricalSafety.setIaPhd(0);
        powerElectricalSafety.setIbPhd(0);
        powerElectricalSafety.setIcPhd(0);
        powerElectricalSafety.setUaPhd(0);
        powerElectricalSafety.setUbPhd(0);
        powerElectricalSafety.setUcPhd(0);
        powerElectricalSafety.setFrequencyDeviation(0);

        if (powerElectricalSafetyRepository.findByDeviceIdAndDataTime(deviceId, start) != null) {
            PowerElectricalSafety p1 = powerElectricalSafetyRepository.findByDeviceIdAndDataTime(deviceId, start);
            powerElectricalSafety.setId(p1.getId());
        }
        powerElectricalSafetyRepository.save(powerElectricalSafety);
    }

    @Override
    public List<PowerElectricalSafety> findYearByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start) {
        PowerElectricalSafety powerElectricalSafety = powerElectricalSafetyRepository.findByDeviceIdAndDataTime(deviceId, start);
        List<PowerElectricalSafety> p1 = new ArrayList<>();


        String timestampString = powerElectricalSafety.getDataTime().toString();
        int [] month = getMonth(timestampString);

        int startTime = start;
        int endTime = startTime + month[0]*86400;

        for(int i=0; i<12; i++) {
//            System.out.println(startTime + " " + endTime);
            PowerElectricalSafety temp = getMonthPower(deviceId, startTime, endTime);
            startTime = endTime;
            if(i<11)
                endTime = endTime + month[i+1]*86400;
            p1.add(temp);
        }



        return p1;
    }

    private PowerElectricalSafety getMonthPower(Integer deviceId, int startTime, int endTime) {
        List<PowerElectricalSafety> p2 = powerElectricalSafetyRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, startTime, endTime);
        PowerElectricalSafety p3 = new PowerElectricalSafety();

        int totalLoad = 0;
        int aLoad = 0;
        int bLoad = 0;
        int cLoad = 0;
        int ia = 0;
        int ib = 0;
        int ic = 0;
        int zeroi = 0;
        int ua = 0;
        int ub = 0;
        int uc = 0;
        int uab = 0;
        int ubc = 0;
        int uca = 0;
        int temperature = 0;
        int uUnbalance = 0;
        int iUnbalance = 0;
        int frequencyDeviation = 0;
        int iaPhd = 0;
        int ibPhd = 0;
        int icPhd = 0;
        int uaPhd = 0;
        int ubPhd = 0;
        int ucPhd = 0;


        for(int i=0; i<p2.size(); i++) {
            totalLoad += p2.get(i).getTotalLoad();
            aLoad +=  p2.get(i).getaLoad();
            bLoad +=  p2.get(i).getbLoad();
            cLoad +=  p2.get(i).getcLoad();
            ia +=  p2.get(i).getIa();
            ib +=  p2.get(i).getIb();
            ic +=  p2.get(i).getIc();
            zeroi +=  p2.get(i).getZeroi();
            ua +=  p2.get(i).getUa();
            ub +=  p2.get(i).getUb();
            uc +=  p2.get(i).getUc();
            uab +=  p2.get(i).getUab();
            ubc +=  p2.get(i).getUbc();
            uca +=  p2.get(i).getUca();
            temperature +=  p2.get(i).getTemperature();
            uUnbalance +=  p2.get(i).getuUnbalance();
            iUnbalance +=  p2.get(i).getiUnbalance();
            frequencyDeviation +=  p2.get(i).getFrequencyDeviation();
            iaPhd +=  p2.get(i).getIaPhd();
            ibPhd +=  p2.get(i).getIbPhd();
            icPhd +=  p2.get(i).getIcPhd();
            uaPhd +=  p2.get(i).getUaPhd();
            ubPhd +=  p2.get(i).getUbPhd();
            ucPhd +=  p2.get(i).getUcPhd();
        }

        p3.setDeviceId(deviceId);
        p3.setDataTime(startTime);
        p3.setTotalLoad(totalLoad);
        p3.setaLoad(aLoad);
        p3.setbLoad(bLoad);
        p3.setcLoad(cLoad);
        p3.setIa(ia);
        p3.setIb(ib);
        p3.setIc(ic);
        p3.setZeroi(zeroi);
        p3.setUa(ua);
        p3.setUb(ub);
        p3.setUc(uc);
        p3.setUab(uab);
        p3.setUbc(ubc);
        p3.setUca(uca);

        p3.setTemperature(temperature);
        p3.setiUnbalance(iUnbalance);
        p3.setuUnbalance(uUnbalance);

        p3.setIaPhd(iaPhd);
        p3.setIbPhd(ibPhd);
        p3.setIcPhd(icPhd);
        p3.setUaPhd(uaPhd);
        p3.setUbPhd(ubPhd);
        p3.setUcPhd(ucPhd);
        p3.setFrequencyDeviation(frequencyDeviation);



        return p3;
    }

    public int[] getMonth(String timestampString) {
        Long timestamp = Long.parseLong(timestampString)*1000;
        String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(timestamp));
        int year = Integer.parseInt(date.substring(6, 10));
        int day = (year%4==0) ? 29 : 28;
        int [] month = {31, day, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return month;

    }
}
