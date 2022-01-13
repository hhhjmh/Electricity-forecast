package com.example.power_prediction.service.Impl;


import com.example.power_prediction.entity.*;
import com.example.power_prediction.repository.*;
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

    @Autowired
    PowerQualityRealtimeRepository powerQualityRealtimeRepository;

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
     *
     *
     *     private String iaPhd;
     *     private String ibPhd;
     *     private String icPhd;
     *     private String uaPhd;
     *     private String ubPhd;
     *     private String ucPhd;
     *     private String frequencyDeviation;
     *     private String uaDeviation;
     *     private String ubDeviation;
     *     private String ucDeviation;
     *     private String uUabDeviation;
     *     private String uUbcDeviation;
     *     private String uUcaDeviation;
     *     private String iUnbalance;
     *     private String uUnbalance;
     */

    @Override
    public void getMax(Integer deviceId, Integer start, Integer end) {
        List<PowerRealtime> dayData =  powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
        List<PowerQualityRealtime> dayData_2 = powerQualityRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
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

        double maxiaPhd = 0;
        double maxibPhd = 0;
        double maxicPhd = 0;
        double maxuaPhd = 0;
        double maxubPhd = 0;
        double maxucPhd = 0;
        double maxfrequencyDeviation = 0;
        double maxuaDeviation = 0;
        double maxubDeviation= 0;
        double maxucDeviation= 0;
        double maxuUabDeviation = 0;
        double maxuUbcDeviation = 0;
        double maxuUcaDeviation = 0;
        double maxiUnbalance = 0;
        double maxuUnbalance = 0;


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

        int indexiaPhd = 0;
        int indexibPhd = 0;
        int indexicPhd = 0;
        int indexuaPhd = 0;
        int indexubPhd = 0;
        int indexucPhd = 0;
        int indexfrequencyDeviation = 0;
        int indexuaDeviation = 0;
        int indexubDeviation= 0;
        int indexucDeviation= 0;
        int indexuUabDeviation = 0;
        int indexuUbcDeviation = 0;
        int indexuUcaDeviation = 0;
        int indexiUnbalance = 0;
        int indexuUnbalance = 0;


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

            if(maxiaPhd<Double.parseDouble(dayData_2.get(i).getIaPhd())) {
                indexiaPhd = i;
                maxiaPhd = Double.parseDouble(dayData_2.get(i).getIaPhd());
            }
            if(maxibPhd<Double.parseDouble(dayData_2.get(i).getIbPhd())) {
                indexibPhd = i;
                maxibPhd = Double.parseDouble(dayData_2.get(i).getIbPhd());
            }
            if(maxicPhd<Double.parseDouble(dayData_2.get(i).getIcPhd())) {
                indexicPhd = i;
                maxicPhd = Double.parseDouble(dayData_2.get(i).getIcPhd());
            }

            if(maxuaPhd<Double.parseDouble(dayData_2.get(i).getUaPhd())) {
                indexiaPhd = i;
                maxuaPhd = Double.parseDouble(dayData_2.get(i).getUaPhd());
            }
            if(maxubPhd<Double.parseDouble(dayData_2.get(i).getUbPhd())) {
                indexibPhd = i;
                maxubPhd = Double.parseDouble(dayData_2.get(i).getUbPhd());
            }
            if(maxucPhd<Double.parseDouble(dayData_2.get(i).getUcPhd())) {
                indexicPhd = i;
                maxucPhd = Double.parseDouble(dayData_2.get(i).getUcPhd());
            }

            if(maxfrequencyDeviation<Double.parseDouble(dayData_2.get(i).getFrequencyDeviation())) {
                indexfrequencyDeviation = i;
                maxfrequencyDeviation = Double.parseDouble(dayData_2.get(i).getFrequencyDeviation());
            }
            if(maxuaDeviation<Double.parseDouble(dayData_2.get(i).getUaDeviation())) {
                indexuaDeviation = i;
                maxuaDeviation = Double.parseDouble(dayData_2.get(i).getUaDeviation());
            }
            if(maxubDeviation<Double.parseDouble(dayData_2.get(i).getUbDeviation())) {
                indexubDeviation = i;
                maxubDeviation = Double.parseDouble(dayData_2.get(i).getUbDeviation());
            }
            if(maxucDeviation<Double.parseDouble(dayData_2.get(i).getUcDeviation())) {
                indexucDeviation = i;
                maxucDeviation = Double.parseDouble(dayData_2.get(i).getUcDeviation());
            }

            if(maxuUabDeviation<Double.parseDouble(dayData_2.get(i).getuUabDeviation())) {
                indexuUabDeviation = i;
                maxuUabDeviation = Double.parseDouble(dayData_2.get(i).getuUabDeviation());
            }
            if(maxuUbcDeviation<Double.parseDouble(dayData_2.get(i).getuUbcDeviation())) {
                indexuUbcDeviation = i;
                maxuUbcDeviation = Double.parseDouble(dayData_2.get(i).getuUbcDeviation());
            }
            if(maxuUcaDeviation<Double.parseDouble(dayData_2.get(i).getuUcaDeviation())) {
                indexuUcaDeviation = i;
                maxuUcaDeviation = Double.parseDouble(dayData_2.get(i).getuUcaDeviation());
            }

            if(maxiUnbalance<Double.parseDouble(dayData_2.get(i).getiUnbalance())) {
                indexiUnbalance = i;
                maxiUnbalance = Double.parseDouble(dayData_2.get(i).getiUnbalance());
            }
            if(maxuUnbalance<Double.parseDouble(dayData_2.get(i).getuUnbalance())) {
                indexuUnbalance = i;
                maxuUnbalance = Double.parseDouble(dayData_2.get(i).getuUnbalance());
            }

        }

        PowerAnalyseDayMax powerAnalyseDayMax = new PowerAnalyseDayMax();
        powerAnalyseDayMax.setDeviceId(deviceId);
        powerAnalyseDayMax.setDataTime(start);

        powerAnalyseDayMax.setIaPhd(dayData_2.get(indexiaPhd).getIaPhd());
        powerAnalyseDayMax.setIaPhdTime(dayData_2.get(indexiaPhd).getDataTime());
        powerAnalyseDayMax.setIbPhd(dayData_2.get(indexibPhd).getIbPhd());
        powerAnalyseDayMax.setIbPhdTime(dayData_2.get(indexibPhd).getDataTime());
        powerAnalyseDayMax.setIcPhd(dayData_2.get(indexicPhd).getIaPhd());
        powerAnalyseDayMax.setIcPhdTime(dayData_2.get(indexicPhd).getDataTime());

        powerAnalyseDayMax.setUaPhd(dayData_2.get(indexuaPhd).getUaPhd());
        powerAnalyseDayMax.setUaPhdTime(dayData_2.get(indexuaPhd).getDataTime());
        powerAnalyseDayMax.setUbPhd(dayData_2.get(indexubPhd).getUbPhd());
        powerAnalyseDayMax.setUbPhdTime(dayData_2.get(indexubPhd).getDataTime());
        powerAnalyseDayMax.setUcPhd(dayData_2.get(indexucPhd).getUaPhd());
        powerAnalyseDayMax.setUcPhdTime(dayData_2.get(indexucPhd).getDataTime());

        powerAnalyseDayMax.setFrequencyDeviation(dayData_2.get(indexfrequencyDeviation).getFrequencyDeviation());
        powerAnalyseDayMax.setFrequencyDeviationTime(dayData_2.get(indexfrequencyDeviation).getDataTime());
        powerAnalyseDayMax.setUaDeviation(dayData_2.get(indexuaDeviation).getUaDeviation());
        powerAnalyseDayMax.setUaDeviationTime(dayData_2.get(indexuaDeviation).getDataTime());
        powerAnalyseDayMax.setUbDeviation(dayData_2.get(indexubDeviation).getUbDeviation());
        powerAnalyseDayMax.setUbDeviationTime(dayData_2.get(indexubDeviation).getDataTime());
        powerAnalyseDayMax.setUcDeviation(dayData_2.get(indexucDeviation).getUcDeviation());
        powerAnalyseDayMax.setUcDeviationTime(dayData_2.get(indexucDeviation).getDataTime());

        powerAnalyseDayMax.setuUabDeviation(dayData_2.get(indexuUabDeviation).getuUabDeviation());
        powerAnalyseDayMax.setuUabDeviationTime(dayData_2.get(indexuUabDeviation).getDataTime());
        powerAnalyseDayMax.setuUbcDeviation(dayData_2.get(indexuUbcDeviation).getuUbcDeviation());
        powerAnalyseDayMax.setuUbcDeviationTime(dayData_2.get(indexuUbcDeviation).getDataTime());
        powerAnalyseDayMax.setuUcaDeviation(dayData_2.get(indexuUcaDeviation).getuUcaDeviation());
        powerAnalyseDayMax.setuUcaDeviationTime(dayData_2.get(indexuUcaDeviation).getDataTime());

        powerAnalyseDayMax.setiUnbalance(dayData_2.get(indexiUnbalance).getiUnbalance());
        powerAnalyseDayMax.setiUnbalanceTime(dayData_2.get(indexiUnbalance).getDataTime());
        powerAnalyseDayMax.setuUnbalance(dayData_2.get(indexuUnbalance).getuUnbalance());
        powerAnalyseDayMax.setuUnbalanceTime(dayData_2.get(indexuUnbalance).getDataTime());


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
        List<PowerRealtime> dayData =  powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
        List<PowerQualityRealtime> dayData_2 = powerQualityRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
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

        double miniaPhd = 10000;
        double minibPhd = 10000;
        double minicPhd = 10000;
        double minuaPhd = 10000;
        double minubPhd = 10000;
        double minucPhd = 10000;
        double minfrequencyDeviation = 10000;
        double minuaDeviation = 10000;
        double minubDeviation= 10000;
        double minucDeviation= 10000;
        double minuUabDeviation = 10000;
        double minuUbcDeviation = 10000;
        double minuUcaDeviation = 10000;
        double miniUnbalance = 10000;
        double minuUnbalance = 10000;


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

        int indexiaPhd = 0;
        int indexibPhd = 0;
        int indexicPhd = 0;
        int indexuaPhd = 0;
        int indexubPhd = 0;
        int indexucPhd = 0;
        int indexfrequencyDeviation = 0;
        int indexuaDeviation = 0;
        int indexubDeviation= 0;
        int indexucDeviation= 0;
        int indexuUabDeviation = 0;
        int indexuUbcDeviation = 0;
        int indexuUcaDeviation = 0;
        int indexiUnbalance = 0;
        int indexuUnbalance = 0;



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

            if(miniaPhd>Double.parseDouble(dayData_2.get(i).getIaPhd())) {
                indexiaPhd = i;
                miniaPhd = Double.parseDouble(dayData_2.get(i).getIaPhd());
            }
            if(minibPhd>Double.parseDouble(dayData_2.get(i).getIbPhd())) {
                indexibPhd = i;
                minibPhd = Double.parseDouble(dayData_2.get(i).getIbPhd());
            }
            if(minicPhd>Double.parseDouble(dayData_2.get(i).getIcPhd())) {
                indexicPhd = i;
                minicPhd = Double.parseDouble(dayData_2.get(i).getIcPhd());
            }

            if(minuaPhd>Double.parseDouble(dayData_2.get(i).getUaPhd())) {
                indexiaPhd = i;
                minuaPhd = Double.parseDouble(dayData_2.get(i).getUaPhd());
            }
            if(minubPhd>Double.parseDouble(dayData_2.get(i).getUbPhd())) {
                indexibPhd = i;
                minubPhd = Double.parseDouble(dayData_2.get(i).getUbPhd());
            }
            if(minucPhd>Double.parseDouble(dayData_2.get(i).getUcPhd())) {
                indexicPhd = i;
                minucPhd = Double.parseDouble(dayData_2.get(i).getUcPhd());
            }

            if(minfrequencyDeviation>Double.parseDouble(dayData_2.get(i).getFrequencyDeviation())) {
                indexfrequencyDeviation = i;
                minfrequencyDeviation = Double.parseDouble(dayData_2.get(i).getFrequencyDeviation());
            }
            if(minuaDeviation>Double.parseDouble(dayData_2.get(i).getUaDeviation())) {
                indexuaDeviation = i;
                minuaDeviation = Double.parseDouble(dayData_2.get(i).getUaDeviation());
            }
            if(minubDeviation>Double.parseDouble(dayData_2.get(i).getUbDeviation())) {
                indexubDeviation = i;
                minubDeviation = Double.parseDouble(dayData_2.get(i).getUbDeviation());
            }
            if(minucDeviation>Double.parseDouble(dayData_2.get(i).getUcDeviation())) {
                indexucDeviation = i;
                minucDeviation = Double.parseDouble(dayData_2.get(i).getUcDeviation());
            }

            if(minuUabDeviation>Double.parseDouble(dayData_2.get(i).getuUabDeviation())) {
                indexuUabDeviation = i;
                minuUabDeviation = Double.parseDouble(dayData_2.get(i).getuUabDeviation());
            }
            if(minuUbcDeviation>Double.parseDouble(dayData_2.get(i).getuUbcDeviation())) {
                indexuUbcDeviation = i;
                minuUbcDeviation = Double.parseDouble(dayData_2.get(i).getuUbcDeviation());
            }
            if(minuUcaDeviation>Double.parseDouble(dayData_2.get(i).getuUcaDeviation())) {
                indexuUcaDeviation = i;
                minuUcaDeviation = Double.parseDouble(dayData_2.get(i).getuUcaDeviation());
            }

            if(miniUnbalance>Double.parseDouble(dayData_2.get(i).getiUnbalance())) {
                indexiUnbalance = i;
                miniUnbalance = Double.parseDouble(dayData_2.get(i).getiUnbalance());
            }
            if(minuUnbalance>Double.parseDouble(dayData_2.get(i).getuUnbalance())) {
                indexuUnbalance = i;
                minuUnbalance = Double.parseDouble(dayData_2.get(i).getuUnbalance());
            }


        }

        PowerAnalyseDayMin powerAnalyseDayMin = new PowerAnalyseDayMin();
        powerAnalyseDayMin.setDeviceId(deviceId);
        powerAnalyseDayMin.setDataTime(start);

        powerAnalyseDayMin.setIaPhd(dayData_2.get(indexiaPhd).getIaPhd());
        powerAnalyseDayMin.setIaPhdTime(dayData_2.get(indexiaPhd).getDataTime());
        powerAnalyseDayMin.setIbPhd(dayData_2.get(indexibPhd).getIbPhd());
        powerAnalyseDayMin.setIbPhdTime(dayData_2.get(indexibPhd).getDataTime());
        powerAnalyseDayMin.setIcPhd(dayData_2.get(indexicPhd).getIaPhd());
        powerAnalyseDayMin.setIcPhdTime(dayData_2.get(indexicPhd).getDataTime());

        powerAnalyseDayMin.setUaPhd(dayData_2.get(indexuaPhd).getUaPhd());
        powerAnalyseDayMin.setUaPhdTime(dayData_2.get(indexuaPhd).getDataTime());
        powerAnalyseDayMin.setUbPhd(dayData_2.get(indexubPhd).getUbPhd());
        powerAnalyseDayMin.setUbPhdTime(dayData_2.get(indexubPhd).getDataTime());
        powerAnalyseDayMin.setUcPhd(dayData_2.get(indexucPhd).getUaPhd());
        powerAnalyseDayMin.setUcPhdTime(dayData_2.get(indexucPhd).getDataTime());

        powerAnalyseDayMin.setFrequencyDeviation(dayData_2.get(indexfrequencyDeviation).getFrequencyDeviation());
        powerAnalyseDayMin.setFrequencyDeviationTime(dayData_2.get(indexfrequencyDeviation).getDataTime());
        powerAnalyseDayMin.setUaDeviation(dayData_2.get(indexuaDeviation).getUaDeviation());
        powerAnalyseDayMin.setUaDeviationTime(dayData_2.get(indexuaDeviation).getDataTime());
        powerAnalyseDayMin.setUbDeviation(dayData_2.get(indexubDeviation).getUbDeviation());
        powerAnalyseDayMin.setUbDeviationTime(dayData_2.get(indexubDeviation).getDataTime());
        powerAnalyseDayMin.setUcDeviation(dayData_2.get(indexucDeviation).getUcDeviation());
        powerAnalyseDayMin.setUcDeviationTime(dayData_2.get(indexucDeviation).getDataTime());

        powerAnalyseDayMin.setuUabDeviation(dayData_2.get(indexuUabDeviation).getuUabDeviation());
        powerAnalyseDayMin.setuUabDeviationTime(dayData_2.get(indexuUabDeviation).getDataTime());
        powerAnalyseDayMin.setuUbcDeviation(dayData_2.get(indexuUbcDeviation).getuUbcDeviation());
        powerAnalyseDayMin.setuUbcDeviationTime(dayData_2.get(indexuUbcDeviation).getDataTime());
        powerAnalyseDayMin.setuUcaDeviation(dayData_2.get(indexuUcaDeviation).getuUcaDeviation());
        powerAnalyseDayMin.setuUcaDeviationTime(dayData_2.get(indexuUcaDeviation).getDataTime());

        powerAnalyseDayMin.setiUnbalance(dayData_2.get(indexiUnbalance).getiUnbalance());
        powerAnalyseDayMin.setiUnbalanceTime(dayData_2.get(indexiUnbalance).getDataTime());
        powerAnalyseDayMin.setuUnbalance(dayData_2.get(indexuUnbalance).getuUnbalance());
        powerAnalyseDayMin.setuUnbalanceTime(dayData_2.get(indexuUnbalance).getDataTime());


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
        List<PowerRealtime> dayData =  powerRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
        List<PowerQualityRealtime> dayData_2 = powerQualityRealtimeRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
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

        double avgiaPhd = 0;
        double avgibPhd = 0;
        double avgicPhd = 0;
        double avguaPhd = 0;
        double avgubPhd = 0;
        double avgucPhd = 0;
        double avgfrequencyDeviation = 0;
        double avguaDeviation = 0;
        double avgubDeviation= 0;
        double avgucDeviation= 0;
        double avguUabDeviation = 0;
        double avguUbcDeviation = 0;
        double avguUcaDeviation = 0;
        double avgiUnbalance = 0;
        double avguUnbalance = 0;



        int size = dayData.size();
        int size1 = dayData_2.size();

        for(int i=0; i<size; i++) {
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
        for(int i=0; i<size1; i++) {
            avgiaPhd += Double.parseDouble(dayData_2.get(i).getIaPhd());
            avgibPhd += Double.parseDouble(dayData_2.get(i).getIbPhd());
            avgicPhd += Double.parseDouble(dayData_2.get(i).getIcPhd());
            avguaPhd += Double.parseDouble(dayData_2.get(i).getUaPhd());
            avgubPhd += Double.parseDouble(dayData_2.get(i).getUbPhd());
            avgucPhd += Double.parseDouble(dayData_2.get(i).getUcPhd());
            avgfrequencyDeviation += Double.parseDouble(dayData_2.get(i).getFrequencyDeviation());
            avguaDeviation += Double.parseDouble(dayData_2.get(i).getUaDeviation());
            avgubDeviation += Double.parseDouble(dayData_2.get(i).getUbDeviation());
            avgucDeviation += Double.parseDouble(dayData_2.get(i).getUcDeviation());
            avguUabDeviation += Double.parseDouble(dayData_2.get(i).getuUabDeviation());
            avguUabDeviation += Double.parseDouble(dayData_2.get(i).getuUbcDeviation());
            avguUabDeviation += Double.parseDouble(dayData_2.get(i).getuUcaDeviation());
            avgiUnbalance += Double.parseDouble(dayData_2.get(i).getiUnbalance());
            avguUnbalance += Double.parseDouble(dayData_2.get(i).getuUnbalance());
        }

        PowerAnalyseDayAvg powerAnalyseDayAvg = new PowerAnalyseDayAvg();
        powerAnalyseDayAvg.setDeviceId(deviceId);
        powerAnalyseDayAvg.setDataTime(start);

        NumberFormat df = NumberFormat.getNumberInstance();

        df.setMaximumFractionDigits(2);


        powerAnalyseDayAvg.setTotalLoad(String.format("%.2f", avgtotalLoad/size));
        powerAnalyseDayAvg.setaLoad(String.format("%.2f", avgaLoad/size));
        powerAnalyseDayAvg.setbLoad(String.format("%.2f", avgbLoad/size));
        powerAnalyseDayAvg.setcLoad(String.format("%.2f", avgcLoad/size));
        powerAnalyseDayAvg.setTotalReactivePower(String.format("%.2f", avgtotalReactivePower/size));
        powerAnalyseDayAvg.setaReactivePower(String.format("%.2f", avgaReactivePower/size));
        powerAnalyseDayAvg.setbReactivePower(String.format("%.2f", avgbReactivePower/size));
        powerAnalyseDayAvg.setcReactivePower(String.format("%.2f", avgcReactivePower/size));
        powerAnalyseDayAvg.setTotalPowerFactor(String.format("%.2f", avgtotalPowerFactor/size));
        powerAnalyseDayAvg.setaPowerFactor(String.format("%.2f", avgaPowerFactor/size));
        powerAnalyseDayAvg.setbPowerFactor(String.format("%.2f", avgbPowerFactor/size));
        powerAnalyseDayAvg.setcPowerFactor(String.format("%.2f", avgcPowerFactor/size));
        powerAnalyseDayAvg.setIa(String.format("%.2f", avgIa/size));
        powerAnalyseDayAvg.setIb(String.format("%.2f", avgIb/size));
        powerAnalyseDayAvg.setIc(String.format("%.2f", avgIc/size));
        powerAnalyseDayAvg.setZeroi(String.format("%.2f", avgzeroi/size));
        powerAnalyseDayAvg.setUa(String.format("%.2f", avgua/size));
        powerAnalyseDayAvg.setUb(String.format("%.2f", avgub/size));
        powerAnalyseDayAvg.setUc(String.format("%.2f", avguc/size));
        powerAnalyseDayAvg.setUab(String.format("%.2f", avguab/size));
        powerAnalyseDayAvg.setUbc(String.format("%.2f", avgubc/size));
        powerAnalyseDayAvg.setUca(String.format("%.2f", avguca/size));

        if(size1!=0) {
            powerAnalyseDayAvg.setIaPhd(String.format("%.2f", avgiaPhd/size1));
            powerAnalyseDayAvg.setIbPhd(String.format("%.2f", avgibPhd/size1));
            powerAnalyseDayAvg.setIcPhd(String.format("%.2f", avgicPhd/size1));
            powerAnalyseDayAvg.setUaPhd(String.format("%.2f", avguaPhd/size1));
            powerAnalyseDayAvg.setUbPhd(String.format("%.2f", avgubPhd/size1));
            powerAnalyseDayAvg.setUcPhd(String.format("%.2f", avgucPhd/size1));
            powerAnalyseDayAvg.setFrequencyDeviation(String.format("%.2f", avgfrequencyDeviation/size1));
            powerAnalyseDayAvg.setUaDeviation(String.format("%.2f", avguaDeviation/size1));
            powerAnalyseDayAvg.setUbDeviation(String.format("%.2f", avgubDeviation/size1));
            powerAnalyseDayAvg.setUcDeviation(String.format("%.2f", avgucDeviation/size1));
            powerAnalyseDayAvg.setuUabDeviation(String.format("%.2f", avguUabDeviation/size1));
            powerAnalyseDayAvg.setuUbcDeviation(String.format("%.2f", avguUbcDeviation/size1));
            powerAnalyseDayAvg.setuUcaDeviation(String.format("%.2f", avguUcaDeviation/size1));
            powerAnalyseDayAvg.setiUnbalance(String.format("%.2f", avgiUnbalance/size1));
            powerAnalyseDayAvg.setuUnbalance(String.format("%.2f", avguUnbalance/size1));
        }





        if (powerAnalyseDayAvgRepository.findByDeviceIdAndDataTime(deviceId, start) != null) {
            PowerAnalyseDayAvg p1 = powerAnalyseDayAvgRepository.findByDeviceIdAndDataTime(deviceId, start);
            powerAnalyseDayAvg.setId(p1.getId());
        }

        powerAnalyseDayAvgRepository.save(powerAnalyseDayAvg);


    }

    @Override
    public List<PowerAnalyseDayAvg> findPowerAnalyseDayAvgByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerAnalyseDayAvgRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
    }

    @Override
    public List<PowerAnalyseDayMax> findPowerAnalyseDayMaxByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end) {
        return powerAnalyseDayMaxRepository.findAllByDeviceIdAndDataTimeBetween(deviceId, start, end);
    }

}
