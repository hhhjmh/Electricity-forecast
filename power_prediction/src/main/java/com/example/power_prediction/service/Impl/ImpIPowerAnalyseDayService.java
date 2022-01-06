package com.example.power_prediction.service.Impl;


import com.example.power_prediction.entity.PowerAnalyseDayAvg;
import com.example.power_prediction.entity.PowerAnalyseDayMax;
import com.example.power_prediction.entity.PowerAnalyseDayMin;
import com.example.power_prediction.entity.PowerRealtime;
import com.example.power_prediction.repository.PowerAnalyseDayAvgRepository;
import com.example.power_prediction.repository.PowerAnalyseDayMaxRepository;
import com.example.power_prediction.repository.PowerAnalyseDayMinRepository;
import com.example.power_prediction.repository.PowerRealtimeRepository;
import com.example.power_prediction.service.PowerAnalyseDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.List;

@Service
public class ImpIPowerAnalyseDayService implements PowerAnalyseDayService {

    @Autowired
    PowerAnalyseDayAvgRepository powerAnalyseDayAvgRepository;

    @Autowired
    PowerAnalyseDayMaxRepository powerAnalyseDayMaxRepository;

    @Autowired
    PowerAnalyseDayMinRepository powerAnalyseDayMinRepository;

    @Autowired
    PowerRealtimeRepository powerRealtimeRepository;

    @Override
    public PowerAnalyseDayAvg getDayAvgByID(int deviceId, Integer dataTime) {

        return powerAnalyseDayAvgRepository.findByDeviceIdAndDataTime(deviceId, dataTime);
    }

    @Override
    public PowerAnalyseDayMax getDayMaxByID(int deviceId, Integer dataTime) {

        return powerAnalyseDayMaxRepository.findByDeviceIdAndDataTime(deviceId, dataTime);
    }

    @Override
    public PowerAnalyseDayMin getDayMinByID(int deviceId, Integer dataTime) {

        return powerAnalyseDayMinRepository.findByDeviceIdAndDataTime(deviceId, dataTime);
    }

    /**
     *
     * @param deviceId
     * @param start
     * @param end
     *
     *     private String totalLoad;
     *     private String aLoad;
     *     private String bLoad;
     *     private String cLoad;
     *     private String totalReactivePower;
     *     private String aReactivePower;
     *     private String bReactivePower;
     *     private String cReactivePower;
     *     private String totalPowerFactor;
     *     private String aPowerFactor;
     *     private String bPowerFactor;
     *     private String cPowerFactor;
     *     private String ia;
     *     private String ib;
     *     private String ic;
     *     private String zeroi;
     *     private String ua;
     *     private String ub;
     *     private String uc;
     *     private String uab;
     *     private String ubc;
     *     private String uca;
     */

    @Override
    public void getMax(Integer deviceId, Integer start, Integer end) {
        List<PowerRealtime> dayData =  powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);;
        double maxtotalLoad= 0;
        double maxaLoad = 0;
        double maxbLoad = 0;
        double maxcLoad = 0;
        double maxtotalReactivePower = 0;
        double maxaReactivePower = 0;
        double maxbReactivePower = 0;
        double maxcReactivePower = 0;
        double maxtotalPowerFactor = 0;
        double maxaPowerFactor = 0;
        double maxbPowerFactor = 0;
        double maxcPowerFactor = 0;
        double maxIa = 0;
        double maxIb = 0;
        double maxIc = 0;
        double maxzeroi = 0;
        double maxua = 0;
        double maxub = 0;
        double maxuc = 0;
        double maxuab = 0;
        double maxubc= 0;
        double maxuca= 0;


        int indextotalLoad= 0;
        int indexaLoad = 0;
        int indexbLoad = 0;
        int indexcLoad = 0;
        int indextotalReactivePower = 0;
        int indexaReactivePower = 0;
        int indexbReactivePower = 0;
        int indexcReactivePower = 0;
        int indextotalPowerFactor = 0;
        int indexaPowerFactor = 0;
        int indexbPowerFactor = 0;
        int indexcPowerFactor = 0;
        int indexIa = 0;
        int indexIb = 0;
        int indexIc = 0;
        int indexzeroi = 0;
        int indexua = 0;
        int indexub = 0;
        int indexuc = 0;
        int indexuab = 0;
        int indexubc= 0;
        int indexuca= 0;

        for(int i=0; i<dayData.size(); i++) {

            if(maxtotalLoad<Double.parseDouble(dayData.get(i).getTotalLoad())) {
                indextotalLoad = i;
                maxtotalLoad = Double.parseDouble(dayData.get(i).getTotalLoad());
            }
            if(maxaLoad<Double.parseDouble(dayData.get(i).getaLoad())) {
                indexaLoad = i;
                maxaLoad = Double.parseDouble(dayData.get(i).getaLoad());
            }
            if(maxbLoad<Double.parseDouble(dayData.get(i).getbLoad())) {
                indexbLoad = i;
                maxbLoad = Double.parseDouble(dayData.get(i).getbLoad());
            }
            if(maxcLoad<Double.parseDouble(dayData.get(i).getcLoad())) {
                indexcLoad = i;
                maxcLoad = Double.parseDouble(dayData.get(i).getcLoad());
            }

            if(maxtotalReactivePower<Double.parseDouble(dayData.get(i).getTotalReactivePower())) {
                indextotalReactivePower = i;
                maxtotalReactivePower = Double.parseDouble(dayData.get(i).getTotalReactivePower());
            }
            if(maxaReactivePower<Double.parseDouble(dayData.get(i).getaReactivePower())) {
                indexaReactivePower = i;
                maxaReactivePower = Double.parseDouble(dayData.get(i).getaReactivePower());
            }
            if(maxbReactivePower<Double.parseDouble(dayData.get(i).getbReactivePower())) {
                indexbReactivePower = i;
                maxbReactivePower = Double.parseDouble(dayData.get(i).getbReactivePower());
            }
            if(maxcReactivePower<Double.parseDouble(dayData.get(i).getcReactivePower())) {
                indexcReactivePower = i;
                maxcReactivePower = Double.parseDouble(dayData.get(i).getcReactivePower());
            }

            if(maxtotalPowerFactor<Double.parseDouble(dayData.get(i).getTotalPowerFactor())) {
                indextotalPowerFactor = i;
                maxtotalPowerFactor = Double.parseDouble(dayData.get(i).getTotalPowerFactor());
            }
            if(maxaPowerFactor<Double.parseDouble(dayData.get(i).getaPowerFactor())) {
                indexaPowerFactor = i;
                maxaPowerFactor = Double.parseDouble(dayData.get(i).getaPowerFactor());
            }
            if(maxbPowerFactor<Double.parseDouble(dayData.get(i).getbPowerFactor())) {
                indexbPowerFactor = i;
                maxbPowerFactor = Double.parseDouble(dayData.get(i).getbPowerFactor());
            }
            if(maxcPowerFactor<Double.parseDouble(dayData.get(i).getcPowerFactor())) {
                indexcPowerFactor = i;
                maxcPowerFactor = Double.parseDouble(dayData.get(i).getcPowerFactor());
            }

            if(maxIa<Double.parseDouble(dayData.get(i).getIa())) {
                indexIa = i;
                maxIa = Double.parseDouble(dayData.get(i).getIa());
            }
            if(maxIb<Double.parseDouble(dayData.get(i).getIb())) {
                indexIb = i;
                maxIb = Double.parseDouble(dayData.get(i).getIb());
            }
            if(maxIc<Double.parseDouble(dayData.get(i).getIc())) {
                indexIc = i;
                maxIc = Double.parseDouble(dayData.get(i).getIc());
            }


            if(maxzeroi<Double.parseDouble(dayData.get(i).getZeroi())) {
                indexzeroi = i;
                maxzeroi = Double.parseDouble(dayData.get(i).getZeroi());
            }
            if(maxua<Double.parseDouble(dayData.get(i).getUa())) {
                indexua = i;
                maxua = Double.parseDouble(dayData.get(i).getUa());
            }
            if(maxub<Double.parseDouble(dayData.get(i).getUb())) {
                indexub = i;
                maxub = Double.parseDouble(dayData.get(i).getUb());
            }
            if(maxuc<Double.parseDouble(dayData.get(i).getUc())) {
                indexuc = i;
                maxuc = Double.parseDouble(dayData.get(i).getUc());
            }

            if(maxuab<Double.parseDouble(dayData.get(i).getUab())) {
                indexuab = i;
                maxuab = Double.parseDouble(dayData.get(i).getUab());
            }
            if(maxubc<Double.parseDouble(dayData.get(i).getUbc())) {
                indexubc = i;
                maxubc = Double.parseDouble(dayData.get(i).getUbc());
            }
            if(maxuca<Double.parseDouble(dayData.get(i).getUca())) {
                indexuca = i;
                maxuca = Double.parseDouble(dayData.get(i).getUca());
            }
        }

        PowerAnalyseDayMax powerAnalyseDayMax = new PowerAnalyseDayMax();
        powerAnalyseDayMax.setDeviceId(deviceId);
        powerAnalyseDayMax.setDataTime(start);

        powerAnalyseDayMax.setTotalLoad(dayData.get(indextotalLoad).getTotalLoad());
        powerAnalyseDayMax.setTotalLoadTime(dayData.get(indextotalLoad).getDataTime());
        powerAnalyseDayMax.setaLoad(dayData.get(indexaLoad).getaLoad());
        powerAnalyseDayMax.setaLoadTime(dayData.get(indexaLoad).getDataTime());
        powerAnalyseDayMax.setbLoad(dayData.get(indexbLoad).getbLoad());
        powerAnalyseDayMax.setbLoadTime(dayData.get(indexbLoad).getDataTime());
        powerAnalyseDayMax.setcLoad(dayData.get(indexcLoad).getaLoad());
        powerAnalyseDayMax.setcLoadTime(dayData.get(indexcLoad).getDataTime());

        powerAnalyseDayMax.setTotalReactivePower(dayData.get(indextotalReactivePower).getTotalReactivePower());
        powerAnalyseDayMax.setTotalReactivePowerTime(dayData.get(indextotalReactivePower).getDataTime());
        powerAnalyseDayMax.setaReactivePower(dayData.get(indexaReactivePower).getaReactivePower());
        powerAnalyseDayMax.setaReactivePowerTime(dayData.get(indexaReactivePower).getDataTime());
        powerAnalyseDayMax.setbReactivePower(dayData.get(indexbReactivePower).getbReactivePower());
        powerAnalyseDayMax.setbReactivePowerTime(dayData.get(indexbReactivePower).getDataTime());
        powerAnalyseDayMax.setcReactivePower(dayData.get(indexcReactivePower).getbReactivePower());
        powerAnalyseDayMax.setcReactivePowerTime(dayData.get(indexcReactivePower).getDataTime());

        powerAnalyseDayMax.setTotalPowerFactor(dayData.get(indextotalPowerFactor).getTotalPowerFactor());
        powerAnalyseDayMax.setTotalPowerFactorTime(dayData.get(indextotalPowerFactor).getDataTime());
        powerAnalyseDayMax.setaPowerFactor(dayData.get(indexaPowerFactor).getaPowerFactor());
        powerAnalyseDayMax.setaPowerFactorTime(dayData.get(indexaPowerFactor).getDataTime());
        powerAnalyseDayMax.setbPowerFactor(dayData.get(indexbPowerFactor).getbPowerFactor());
        powerAnalyseDayMax.setbPowerFactorTime(dayData.get(indexbPowerFactor).getDataTime());
        powerAnalyseDayMax.setcPowerFactor(dayData.get(indexcPowerFactor).getcPowerFactor());
        powerAnalyseDayMax.setcPowerFactorTime(dayData.get(indexcPowerFactor).getDataTime());


        powerAnalyseDayMax.setIa(dayData.get(indexIa).getIa());
        powerAnalyseDayMax.setIaTime(dayData.get(indexIa).getDataTime());
        powerAnalyseDayMax.setIb(dayData.get(indexIb).getIb());
        powerAnalyseDayMax.setIbTime(dayData.get(indexIb).getDataTime());
        powerAnalyseDayMax.setIc(dayData.get(indexIc).getIc());
        powerAnalyseDayMax.setIcTime(dayData.get(indexIc).getDataTime());

        powerAnalyseDayMax.setZeroi(dayData.get(indexzeroi).getZeroi());
        powerAnalyseDayMax.setZeroiTime(dayData.get(indexzeroi).getDataTime());
        powerAnalyseDayMax.setUa(dayData.get(indexua).getUa());
        powerAnalyseDayMax.setUaTime(dayData.get(indexua).getDataTime());
        powerAnalyseDayMax.setUb(dayData.get(indexub).getUb());
        powerAnalyseDayMax.setUbTime(dayData.get(indexub).getDataTime());
        powerAnalyseDayMax.setUc(dayData.get(indexuc).getUc());
        powerAnalyseDayMax.setUcTime(dayData.get(indexuc).getDataTime());

        powerAnalyseDayMax.setUab(dayData.get(indexuab).getUab());
        powerAnalyseDayMax.setUabTime(dayData.get(indexuab).getDataTime());
        powerAnalyseDayMax.setUbc(dayData.get(indexubc).getUbc());
        powerAnalyseDayMax.setUbcTime(dayData.get(indexubc).getDataTime());
        powerAnalyseDayMax.setUca(dayData.get(indexuca).getUca());
        powerAnalyseDayMax.setUcaTime(dayData.get(indexuca).getDataTime());


        if (powerAnalyseDayMaxRepository.findByDeviceIdAndDataTime(deviceId, start) != null) {
            PowerAnalyseDayMax p1 = powerAnalyseDayMaxRepository.findByDeviceIdAndDataTime(deviceId, start);
            powerAnalyseDayMax.setId(p1.getId());
        }
        powerAnalyseDayMaxRepository.save(powerAnalyseDayMax);


    }

    @Override
    public void getMin(Integer deviceId, Integer start, Integer end) {
        List<PowerRealtime> dayData =  powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);;
        double mintotalLoad= 100000;
        double minaLoad = 100000;
        double minbLoad = 100000;
        double mincLoad = 100000;
        double mintotalReactivePower = 100000;
        double minaReactivePower = 100000;
        double minbReactivePower = 100000;
        double mincReactivePower = 100000;
        double mintotalPowerFactor = 100000;
        double minaPowerFactor = 100000;
        double minbPowerFactor = 100000;
        double mincPowerFactor = 100000;
        double minIa = 100000;
        double minIb = 100000;
        double minIc = 100000;
        double minzeroi = 100000;
        double minua = 100000;
        double minub = 100000;
        double minuc = 100000;
        double minuab = 100000;
        double minubc= 100000;
        double minuca= 100000;


        int indextotalLoad= 0;
        int indexaLoad = 0;
        int indexbLoad = 0;
        int indexcLoad = 0;
        int indextotalReactivePower = 0;
        int indexaReactivePower = 0;
        int indexbReactivePower = 0;
        int indexcReactivePower = 0;
        int indextotalPowerFactor = 0;
        int indexaPowerFactor = 0;
        int indexbPowerFactor = 0;
        int indexcPowerFactor = 0;
        int indexIa = 0;
        int indexIb = 0;
        int indexIc = 0;
        int indexzeroi = 0;
        int indexua = 0;
        int indexub = 0;
        int indexuc = 0;
        int indexuab = 0;
        int indexubc= 0;
        int indexuca= 0;

        for(int i=0; i<dayData.size(); i++) {

            if(mintotalLoad>Double.parseDouble(dayData.get(i).getTotalLoad())) {
                indextotalLoad = i;
                mintotalLoad = Double.parseDouble(dayData.get(i).getTotalLoad());
            }
            if(minaLoad>Double.parseDouble(dayData.get(i).getaLoad())) {
                indexaLoad = i;
                minaLoad = Double.parseDouble(dayData.get(i).getaLoad());
            }
            if(minbLoad>Double.parseDouble(dayData.get(i).getbLoad())) {
                indexbLoad = i;
                minbLoad = Double.parseDouble(dayData.get(i).getbLoad());
            }
            if(mincLoad>Double.parseDouble(dayData.get(i).getcLoad())) {
                indexcLoad = i;
                mincLoad = Double.parseDouble(dayData.get(i).getcLoad());
            }

            if(mintotalReactivePower>Double.parseDouble(dayData.get(i).getTotalReactivePower())) {
                indextotalReactivePower = i;
                mintotalReactivePower = Double.parseDouble(dayData.get(i).getTotalReactivePower());
            }
            if(minaReactivePower>Double.parseDouble(dayData.get(i).getaReactivePower())) {
                indexaReactivePower = i;
                minaReactivePower = Double.parseDouble(dayData.get(i).getaReactivePower());
            }
            if(minbReactivePower>Double.parseDouble(dayData.get(i).getbReactivePower())) {
                indexbReactivePower = i;
                minbReactivePower = Double.parseDouble(dayData.get(i).getbReactivePower());
            }
            if(mincReactivePower>Double.parseDouble(dayData.get(i).getcReactivePower())) {
                indexcReactivePower = i;
                mincReactivePower = Double.parseDouble(dayData.get(i).getcReactivePower());
            }

            if(mintotalPowerFactor>Double.parseDouble(dayData.get(i).getTotalPowerFactor())) {
                indextotalPowerFactor = i;
                mintotalPowerFactor = Double.parseDouble(dayData.get(i).getTotalPowerFactor());
            }
            if(minaPowerFactor>Double.parseDouble(dayData.get(i).getaPowerFactor())) {
                indexaPowerFactor = i;
                minaPowerFactor = Double.parseDouble(dayData.get(i).getaPowerFactor());
            }
            if(minbPowerFactor>Double.parseDouble(dayData.get(i).getbPowerFactor())) {
                indexbPowerFactor = i;
                minbPowerFactor = Double.parseDouble(dayData.get(i).getbPowerFactor());
            }
            if(mincPowerFactor>Double.parseDouble(dayData.get(i).getcPowerFactor())) {
                indexcPowerFactor = i;
                mincPowerFactor = Double.parseDouble(dayData.get(i).getcPowerFactor());
            }

            if(minIa>Double.parseDouble(dayData.get(i).getIa())) {
                indexIa = i;
                minIa = Double.parseDouble(dayData.get(i).getIa());
            }
            if(minIb>Double.parseDouble(dayData.get(i).getIb())) {
                indexIb = i;
                minIb = Double.parseDouble(dayData.get(i).getIb());
            }
            if(minIb>Double.parseDouble(dayData.get(i).getIc())) {
                indexIc = i;
                minIc = Double.parseDouble(dayData.get(i).getIc());
            }


            if(minzeroi>Double.parseDouble(dayData.get(i).getZeroi())) {
                indexzeroi = i;
                minzeroi = Double.parseDouble(dayData.get(i).getZeroi());
            }
            if(minua>Double.parseDouble(dayData.get(i).getUa())) {
                indexua = i;
                minua = Double.parseDouble(dayData.get(i).getUa());
            }
            if(minub>Double.parseDouble(dayData.get(i).getUb())) {
                indexub = i;
                minub = Double.parseDouble(dayData.get(i).getUb());
            }
            if(minuc>Double.parseDouble(dayData.get(i).getUc())) {
                indexuc = i;
                minuc = Double.parseDouble(dayData.get(i).getUc());
            }

            if(minuab>Double.parseDouble(dayData.get(i).getUab())) {
                indexuab = i;
                minuab = Double.parseDouble(dayData.get(i).getUab());
            }
            if(minubc>Double.parseDouble(dayData.get(i).getUbc())) {
                indexubc = i;
                minubc = Double.parseDouble(dayData.get(i).getUbc());
            }
            if(minuca>Double.parseDouble(dayData.get(i).getUca())) {
                indexuca = i;
                minuca = Double.parseDouble(dayData.get(i).getUca());
            }

        }

        PowerAnalyseDayMin powerAnalyseDayMin = new PowerAnalyseDayMin();
        powerAnalyseDayMin.setDeviceId(deviceId);
        powerAnalyseDayMin.setDataTime(start);

        powerAnalyseDayMin.setTotalLoad(dayData.get(indextotalLoad).getTotalLoad());
        powerAnalyseDayMin.setTotalLoadTime(dayData.get(indextotalLoad).getDataTime());
        powerAnalyseDayMin.setaLoad(dayData.get(indexaLoad).getaLoad());
        powerAnalyseDayMin.setaLoadTime(dayData.get(indexaLoad).getDataTime());
        powerAnalyseDayMin.setbLoad(dayData.get(indexbLoad).getbLoad());
        powerAnalyseDayMin.setbLoadTime(dayData.get(indexbLoad).getDataTime());
        powerAnalyseDayMin.setcLoad(dayData.get(indexcLoad).getaLoad());
        powerAnalyseDayMin.setcLoadTime(dayData.get(indexcLoad).getDataTime());

        powerAnalyseDayMin.setTotalReactivePower(dayData.get(indextotalReactivePower).getTotalReactivePower());
        powerAnalyseDayMin.setTotalReactivePowerTime(dayData.get(indextotalReactivePower).getDataTime());
        powerAnalyseDayMin.setaReactivePower(dayData.get(indexaReactivePower).getaReactivePower());
        powerAnalyseDayMin.setaReactivePowerTime(dayData.get(indexaReactivePower).getDataTime());
        powerAnalyseDayMin.setbReactivePower(dayData.get(indexbReactivePower).getbReactivePower());
        powerAnalyseDayMin.setbReactivePowerTime(dayData.get(indexbReactivePower).getDataTime());
        powerAnalyseDayMin.setcReactivePower(dayData.get(indexcReactivePower).getbReactivePower());
        powerAnalyseDayMin.setcReactivePowerTime(dayData.get(indexcReactivePower).getDataTime());

        powerAnalyseDayMin.setTotalPowerFactor(dayData.get(indextotalPowerFactor).getTotalPowerFactor());
        powerAnalyseDayMin.setTotalPowerFactorTime(dayData.get(indextotalPowerFactor).getDataTime());
        powerAnalyseDayMin.setaPowerFactor(dayData.get(indexaPowerFactor).getaPowerFactor());
        powerAnalyseDayMin.setaPowerFactorTime(dayData.get(indexaPowerFactor).getDataTime());
        powerAnalyseDayMin.setbPowerFactor(dayData.get(indexbPowerFactor).getbPowerFactor());
        powerAnalyseDayMin.setbPowerFactorTime(dayData.get(indexbPowerFactor).getDataTime());
        powerAnalyseDayMin.setcPowerFactor(dayData.get(indexcPowerFactor).getcPowerFactor());
        powerAnalyseDayMin.setcPowerFactorTime(dayData.get(indexcPowerFactor).getDataTime());


        powerAnalyseDayMin.setIa(dayData.get(indexIa).getIa());
        powerAnalyseDayMin.setIaTime(dayData.get(indexIa).getDataTime());
        powerAnalyseDayMin.setIb(dayData.get(indexIb).getIb());
        powerAnalyseDayMin.setIbTime(dayData.get(indexIb).getDataTime());
        powerAnalyseDayMin.setIc(dayData.get(indexIc).getIc());
        powerAnalyseDayMin.setIcTime(dayData.get(indexIc).getDataTime());

        powerAnalyseDayMin.setZeroi(dayData.get(indexzeroi).getZeroi());
        powerAnalyseDayMin.setZeroiTime(dayData.get(indexzeroi).getDataTime());
        powerAnalyseDayMin.setUa(dayData.get(indexua).getUa());
        powerAnalyseDayMin.setUaTime(dayData.get(indexua).getDataTime());
        powerAnalyseDayMin.setUb(dayData.get(indexub).getUb());
        powerAnalyseDayMin.setUbTime(dayData.get(indexub).getDataTime());
        powerAnalyseDayMin.setUc(dayData.get(indexuc).getUc());
        powerAnalyseDayMin.setUcTime(dayData.get(indexuc).getDataTime());

        powerAnalyseDayMin.setUab(dayData.get(indexuab).getUab());
        powerAnalyseDayMin.setUabTime(dayData.get(indexuab).getDataTime());
        powerAnalyseDayMin.setUbc(dayData.get(indexubc).getUbc());
        powerAnalyseDayMin.setUbcTime(dayData.get(indexubc).getDataTime());
        powerAnalyseDayMin.setUca(dayData.get(indexuca).getUca());
        powerAnalyseDayMin.setUcaTime(dayData.get(indexuca).getDataTime());

        if (powerAnalyseDayMinRepository.findByDeviceIdAndDataTime(deviceId, start) != null) {
            PowerAnalyseDayMin p1 = powerAnalyseDayMinRepository.findByDeviceIdAndDataTime(deviceId, start);
            powerAnalyseDayMin.setId(p1.getId());
        }
        powerAnalyseDayMinRepository.save(powerAnalyseDayMin);


    }

    @Override
    public void getAvg(Integer deviceId, Integer start, Integer end) {
        List<PowerRealtime> dayData =  powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);;
        double avgtotalLoad= 0;
        double avgaLoad = 0;
        double avgbLoad = 0;
        double avgcLoad = 0;
        double avgtotalReactivePower = 0;
        double avgaReactivePower = 0;
        double avgbReactivePower = 0;
        double avgcReactivePower = 0;
        double avgtotalPowerFactor = 0;
        double avgaPowerFactor = 0;
        double avgbPowerFactor = 0;
        double avgcPowerFactor = 0;
        double avgIa = 0;
        double avgIb = 0;
        double avgIc = 0;
        double avgzeroi = 0;
        double avgua = 0;
        double avgub = 0;
        double avguc = 0;
        double avguab = 0;
        double avgubc= 0;
        double avguca= 0;


        int size = dayData.size();


        for(int i=0; i<dayData.size(); i++) {
            avgtotalLoad += Double.parseDouble(dayData.get(i).getTotalLoad());
            avgaLoad += Double.parseDouble(dayData.get(i).getaLoad());
            avgbLoad += Double.parseDouble(dayData.get(i).getbLoad());
            avgcLoad += Double.parseDouble(dayData.get(i).getcLoad());
            avgtotalReactivePower += Double.parseDouble(dayData.get(i).getTotalReactivePower());
            avgaReactivePower += Double.parseDouble(dayData.get(i).getaReactivePower());
            avgbReactivePower += Double.parseDouble(dayData.get(i).getbReactivePower());
            avgcReactivePower += Double.parseDouble(dayData.get(i).getcReactivePower());
            avgtotalPowerFactor += Double.parseDouble(dayData.get(i).getTotalPowerFactor());
            avgaPowerFactor += Double.parseDouble(dayData.get(i).getaPowerFactor());
            avgbPowerFactor += Double.parseDouble(dayData.get(i).getbPowerFactor());
            avgcPowerFactor += Double.parseDouble(dayData.get(i).getcPowerFactor());
            avgIa += Double.parseDouble(dayData.get(i).getIa());
            avgIb += Double.parseDouble(dayData.get(i).getIb());
            avgIc += Double.parseDouble(dayData.get(i).getIc());
            avgzeroi += Double.parseDouble(dayData.get(i).getZeroi());
            avgua += Double.parseDouble(dayData.get(i).getUa());
            avgub += Double.parseDouble(dayData.get(i).getUb());
            avguc += Double.parseDouble(dayData.get(i).getUc());
            avguab += Double.parseDouble(dayData.get(i).getUab());
            avgubc += Double.parseDouble(dayData.get(i).getUbc());
            avguca += Double.parseDouble(dayData.get(i).getUca());




        }

        PowerAnalyseDayAvg powerAnalyseDayAvg = new PowerAnalyseDayAvg();
        powerAnalyseDayAvg.setDeviceId(deviceId);
        powerAnalyseDayAvg.setDataTime(start);

        NumberFormat df = NumberFormat.getNumberInstance();

        df.setMaximumFractionDigits(2);



        powerAnalyseDayAvg.setTotalLoad(String.valueOf(df.format(avgtotalLoad/size)));
        powerAnalyseDayAvg.setaLoad(String.valueOf(df.format(avgaLoad/size)));
        powerAnalyseDayAvg.setbLoad(String.valueOf(df.format(avgbLoad/size)));
        powerAnalyseDayAvg.setcLoad(String.valueOf(df.format(avgcLoad/size)));
        powerAnalyseDayAvg.setTotalReactivePower(String.valueOf(df.format(avgtotalReactivePower/size)));
        powerAnalyseDayAvg.setaReactivePower(String.valueOf(df.format(avgaReactivePower/size)));
        powerAnalyseDayAvg.setbReactivePower(String.valueOf(df.format(avgbReactivePower/size)));
        powerAnalyseDayAvg.setcReactivePower(String.valueOf(df.format(avgcReactivePower/size)));
        powerAnalyseDayAvg.setTotalPowerFactor(String.valueOf(df.format(avgtotalPowerFactor/size)));
        powerAnalyseDayAvg.setaPowerFactor(String.valueOf(df.format(avgaPowerFactor/size)));
        powerAnalyseDayAvg.setbPowerFactor(String.valueOf(df.format(avgbPowerFactor/size)));
        powerAnalyseDayAvg.setcPowerFactor(String.valueOf(df.format(avgcPowerFactor/size)));
        powerAnalyseDayAvg.setIa(String.valueOf(df.format(avgIa/size)));
        powerAnalyseDayAvg.setIb(String.valueOf(df.format(avgIb/size)));
        powerAnalyseDayAvg.setIc(String.valueOf(df.format(avgIc/size)));
        powerAnalyseDayAvg.setZeroi(String.valueOf(df.format(avgzeroi/size)));
        powerAnalyseDayAvg.setUa(String.valueOf(df.format(avgua/size)));
        powerAnalyseDayAvg.setUb(String.valueOf(df.format(avgub/size)));
        powerAnalyseDayAvg.setUc(String.valueOf(df.format(avguc/size)));
        powerAnalyseDayAvg.setUab(String.valueOf(df.format(avguab/size)));
        powerAnalyseDayAvg.setUbc(String.valueOf(df.format(avgubc/size)));
        powerAnalyseDayAvg.setUca(String.valueOf(df.format(avguca/size)));

        if (powerAnalyseDayAvgRepository.findByDeviceIdAndDataTime(deviceId, start) != null) {
            PowerAnalyseDayAvg p1 = powerAnalyseDayAvgRepository.findByDeviceIdAndDataTime(deviceId, start);
            powerAnalyseDayAvg.setId(p1.getId());
        }

        powerAnalyseDayAvgRepository.save(powerAnalyseDayAvg);


    }

}
