package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "power_analyse_day_max", schema = "power", catalog = "")
public class PowerAnalyseDayMax {
    private int id;
    private Integer dataTime;
    private Integer totalLoadTime;
    private String totalLoad;
    private Integer aLoadTime;
    private String aLoad;
    private Integer bLoadTime;
    private String bLoad;
    private Integer cLoadTime;
    private String cLoad;
    private Integer totalReactivePowerTime;
    private String totalReactivePower;
    private Integer aReactivePowerTime;
    private String aReactivePower;
    private Integer bReactivePowerTime;
    private String bReactivePower;
    private Integer cReactivePowerTime;
    private String cReactivePower;
    private Integer totalPowerFactorTime;
    private String totalPowerFactor;
    private Integer aPowerFactorTime;
    private String aPowerFactor;
    private Integer bPowerFactorTime;
    private String bPowerFactor;
    private Integer cPowerFactorTime;
    private String cPowerFactor;
    private Integer iaTime;
    private String ia;
    private Integer ibTime;
    private String ib;
    private Integer icTime;
    private String ic;
    private Integer zeroiTime;
    private String zeroi;
    private Integer uaTime;
    private String ua;
    private Integer ubTime;
    private String ub;
    private Integer ucTime;
    private String uc;
    private Integer uabTime;
    private String uab;
    private Integer ubcTime;
    private String ubc;
    private Integer ucaTime;
    private String uca;
    private Integer iaPhdTime;
    private String iaPhd;
    private Integer ibPhdTime;
    private String ibPhd;
    private Integer icPhdTime;
    private String icPhd;
    private Integer uaPhdTime;
    private String uaPhd;
    private Integer ubPhdTime;
    private String ubPhd;
    private Integer ucPhdTime;
    private String ucPhd;
    private Integer uaDeviationTime;
    private String uaDeviation;
    private Integer ubDeviationTime;
    private String ubDeviation;
    private Integer ucDeviationTime;
    private String ucDeviation;
    private Integer uUabDeviationTime;
    private String uUabDeviation;
    private Integer uUbcDeviationTime;
    private String uUbcDeviation;
    private Integer uUcaDeviationTime;
    private String uUcaDeviation;
    private Integer iUnbalanceTime;
    private String iUnbalance;
    private Integer uUnbalanceTime;
    private String uUnbalance;

    private int deviceId;
    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }


    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dataTime")
    public Integer getDataTime() {
        return dataTime;
    }

    public void setDataTime(Integer dataTime) {
        this.dataTime = dataTime;
    }

    @Basic
    @Column(name = "totalLoadTime")
    public Integer getTotalLoadTime() {
        return totalLoadTime;
    }

    public void setTotalLoadTime(Integer totalLoadTime) {
        this.totalLoadTime = totalLoadTime;
    }

    @Basic
    @Column(name = "totalLoad")
    public String getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(String totalLoad) {
        this.totalLoad = totalLoad;
    }

    @Basic
    @Column(name = "aLoadTime")
    public Integer getaLoadTime() {
        return aLoadTime;
    }

    public void setaLoadTime(Integer aLoadTime) {
        this.aLoadTime = aLoadTime;
    }

    @Basic
    @Column(name = "aLoad")
    public String getaLoad() {
        return aLoad;
    }

    public void setaLoad(String aLoad) {
        this.aLoad = aLoad;
    }

    @Basic
    @Column(name = "bLoadTime")
    public Integer getbLoadTime() {
        return bLoadTime;
    }

    public void setbLoadTime(Integer bLoadTime) {
        this.bLoadTime = bLoadTime;
    }

    @Basic
    @Column(name = "bLoad")
    public String getbLoad() {
        return bLoad;
    }

    public void setbLoad(String bLoad) {
        this.bLoad = bLoad;
    }

    @Basic
    @Column(name = "cLoadTime")
    public Integer getcLoadTime() {
        return cLoadTime;
    }

    public void setcLoadTime(Integer cLoadTime) {
        this.cLoadTime = cLoadTime;
    }

    @Basic
    @Column(name = "cLoad")
    public String getcLoad() {
        return cLoad;
    }

    public void setcLoad(String cLoad) {
        this.cLoad = cLoad;
    }

    @Basic
    @Column(name = "totalReactivePowerTime")
    public Integer getTotalReactivePowerTime() {
        return totalReactivePowerTime;
    }

    public void setTotalReactivePowerTime(Integer totalReactivePowerTime) {
        this.totalReactivePowerTime = totalReactivePowerTime;
    }

    @Basic
    @Column(name = "totalReactivePower")
    public String getTotalReactivePower() {
        return totalReactivePower;
    }

    public void setTotalReactivePower(String totalReactivePower) {
        this.totalReactivePower = totalReactivePower;
    }

    @Basic
    @Column(name = "aReactivePowerTime")
    public Integer getaReactivePowerTime() {
        return aReactivePowerTime;
    }

    public void setaReactivePowerTime(Integer aReactivePowerTime) {
        this.aReactivePowerTime = aReactivePowerTime;
    }

    @Basic
    @Column(name = "aReactivePower")
    public String getaReactivePower() {
        return aReactivePower;
    }

    public void setaReactivePower(String aReactivePower) {
        this.aReactivePower = aReactivePower;
    }

    @Basic
    @Column(name = "bReactivePowerTime")
    public Integer getbReactivePowerTime() {
        return bReactivePowerTime;
    }

    public void setbReactivePowerTime(Integer bReactivePowerTime) {
        this.bReactivePowerTime = bReactivePowerTime;
    }

    @Basic
    @Column(name = "bReactivePower")
    public String getbReactivePower() {
        return bReactivePower;
    }

    public void setbReactivePower(String bReactivePower) {
        this.bReactivePower = bReactivePower;
    }

    @Basic
    @Column(name = "cReactivePowerTime")
    public Integer getcReactivePowerTime() {
        return cReactivePowerTime;
    }

    public void setcReactivePowerTime(Integer cReactivePowerTime) {
        this.cReactivePowerTime = cReactivePowerTime;
    }

    @Basic
    @Column(name = "cReactivePower")
    public String getcReactivePower() {
        return cReactivePower;
    }

    public void setcReactivePower(String cReactivePower) {
        this.cReactivePower = cReactivePower;
    }

    @Basic
    @Column(name = "totalPowerFactorTime")
    public Integer getTotalPowerFactorTime() {
        return totalPowerFactorTime;
    }

    public void setTotalPowerFactorTime(Integer totalPowerFactorTime) {
        this.totalPowerFactorTime = totalPowerFactorTime;
    }

    @Basic
    @Column(name = "totalPowerFactor")
    public String getTotalPowerFactor() {
        return totalPowerFactor;
    }

    public void setTotalPowerFactor(String totalPowerFactor) {
        this.totalPowerFactor = totalPowerFactor;
    }

    @Basic
    @Column(name = "aPowerFactorTime")
    public Integer getaPowerFactorTime() {
        return aPowerFactorTime;
    }

    public void setaPowerFactorTime(Integer aPowerFactorTime) {
        this.aPowerFactorTime = aPowerFactorTime;
    }

    @Basic
    @Column(name = "aPowerFactor")
    public String getaPowerFactor() {
        return aPowerFactor;
    }

    public void setaPowerFactor(String aPowerFactor) {
        this.aPowerFactor = aPowerFactor;
    }

    @Basic
    @Column(name = "bPowerFactorTime")
    public Integer getbPowerFactorTime() {
        return bPowerFactorTime;
    }

    public void setbPowerFactorTime(Integer bPowerFactorTime) {
        this.bPowerFactorTime = bPowerFactorTime;
    }

    @Basic
    @Column(name = "bPowerFactor")
    public String getbPowerFactor() {
        return bPowerFactor;
    }

    public void setbPowerFactor(String bPowerFactor) {
        this.bPowerFactor = bPowerFactor;
    }

    @Basic
    @Column(name = "cPowerFactorTime")
    public Integer getcPowerFactorTime() {
        return cPowerFactorTime;
    }

    public void setcPowerFactorTime(Integer cPowerFactorTime) {
        this.cPowerFactorTime = cPowerFactorTime;
    }

    @Basic
    @Column(name = "cPowerFactor")
    public String getcPowerFactor() {
        return cPowerFactor;
    }

    public void setcPowerFactor(String cPowerFactor) {
        this.cPowerFactor = cPowerFactor;
    }

    @Basic
    @Column(name = "iaTime")
    public Integer getIaTime() {
        return iaTime;
    }

    public void setIaTime(Integer iaTime) {
        this.iaTime = iaTime;
    }

    @Basic
    @Column(name = "ia")
    public String getIa() {
        return ia;
    }

    public void setIa(String ia) {
        this.ia = ia;
    }

    @Basic
    @Column(name = "ibTime")
    public Integer getIbTime() {
        return ibTime;
    }

    public void setIbTime(Integer ibTime) {
        this.ibTime = ibTime;
    }

    @Basic
    @Column(name = "ib")
    public String getIb() {
        return ib;
    }

    public void setIb(String ib) {
        this.ib = ib;
    }

    @Basic
    @Column(name = "icTime")
    public Integer getIcTime() {
        return icTime;
    }

    public void setIcTime(Integer icTime) {
        this.icTime = icTime;
    }

    @Basic
    @Column(name = "ic")
    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    @Basic
    @Column(name = "zeroiTime")
    public Integer getZeroiTime() {
        return zeroiTime;
    }

    public void setZeroiTime(Integer zeroiTime) {
        this.zeroiTime = zeroiTime;
    }

    @Basic
    @Column(name = "zeroi")
    public String getZeroi() {
        return zeroi;
    }

    public void setZeroi(String zeroi) {
        this.zeroi = zeroi;
    }

    @Basic
    @Column(name = "uaTime")
    public Integer getUaTime() {
        return uaTime;
    }

    public void setUaTime(Integer uaTime) {
        this.uaTime = uaTime;
    }

    @Basic
    @Column(name = "ua")
    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    @Basic
    @Column(name = "ubTime")
    public Integer getUbTime() {
        return ubTime;
    }

    public void setUbTime(Integer ubTime) {
        this.ubTime = ubTime;
    }

    @Basic
    @Column(name = "ub")
    public String getUb() {
        return ub;
    }

    public void setUb(String ub) {
        this.ub = ub;
    }

    @Basic
    @Column(name = "ucTime")
    public Integer getUcTime() {
        return ucTime;
    }

    public void setUcTime(Integer ucTime) {
        this.ucTime = ucTime;
    }

    @Basic
    @Column(name = "uc")
    public String getUc() {
        return uc;
    }

    public void setUc(String uc) {
        this.uc = uc;
    }

    @Basic
    @Column(name = "uabTime")
    public Integer getUabTime() {
        return uabTime;
    }

    public void setUabTime(Integer uabTime) {
        this.uabTime = uabTime;
    }

    @Basic
    @Column(name = "uab")
    public String getUab() {
        return uab;
    }

    public void setUab(String uab) {
        this.uab = uab;
    }

    @Basic
    @Column(name = "ubcTime")
    public Integer getUbcTime() {
        return ubcTime;
    }

    public void setUbcTime(Integer ubcTime) {
        this.ubcTime = ubcTime;
    }

    @Basic
    @Column(name = "ubc")
    public String getUbc() {
        return ubc;
    }

    public void setUbc(String ubc) {
        this.ubc = ubc;
    }

    @Basic
    @Column(name = "ucaTime")
    public Integer getUcaTime() {
        return ucaTime;
    }

    public void setUcaTime(Integer ucaTime) {
        this.ucaTime = ucaTime;
    }

    @Basic
    @Column(name = "uca")
    public String getUca() {
        return uca;
    }

    public void setUca(String uca) {
        this.uca = uca;
    }

    @Basic
    @Column(name = "iaPHDTime")
    public Integer getIaPhdTime() {
        return iaPhdTime;
    }

    public void setIaPhdTime(Integer iaPhdTime) {
        this.iaPhdTime = iaPhdTime;
    }

    @Basic
    @Column(name = "iaPHD")
    public String getIaPhd() {
        return iaPhd;
    }

    public void setIaPhd(String iaPhd) {
        this.iaPhd = iaPhd;
    }

    @Basic
    @Column(name = "ibPHDTime")
    public Integer getIbPhdTime() {
        return ibPhdTime;
    }

    public void setIbPhdTime(Integer ibPhdTime) {
        this.ibPhdTime = ibPhdTime;
    }

    @Basic
    @Column(name = "ibPHD")
    public String getIbPhd() {
        return ibPhd;
    }

    public void setIbPhd(String ibPhd) {
        this.ibPhd = ibPhd;
    }

    @Basic
    @Column(name = "icPHDTime")
    public Integer getIcPhdTime() {
        return icPhdTime;
    }

    public void setIcPhdTime(Integer icPhdTime) {
        this.icPhdTime = icPhdTime;
    }

    @Basic
    @Column(name = "icPHD")
    public String getIcPhd() {
        return icPhd;
    }

    public void setIcPhd(String icPhd) {
        this.icPhd = icPhd;
    }

    @Basic
    @Column(name = "uaPHDTime")
    public Integer getUaPhdTime() {
        return uaPhdTime;
    }

    public void setUaPhdTime(Integer uaPhdTime) {
        this.uaPhdTime = uaPhdTime;
    }

    @Basic
    @Column(name = "uaPHD")
    public String getUaPhd() {
        return uaPhd;
    }

    public void setUaPhd(String uaPhd) {
        this.uaPhd = uaPhd;
    }

    @Basic
    @Column(name = "ubPHDTime")
    public Integer getUbPhdTime() {
        return ubPhdTime;
    }

    public void setUbPhdTime(Integer ubPhdTime) {
        this.ubPhdTime = ubPhdTime;
    }

    @Basic
    @Column(name = "ubPHD")
    public String getUbPhd() {
        return ubPhd;
    }

    public void setUbPhd(String ubPhd) {
        this.ubPhd = ubPhd;
    }

    @Basic
    @Column(name = "ucPHDTime")
    public Integer getUcPhdTime() {
        return ucPhdTime;
    }

    public void setUcPhdTime(Integer ucPhdTime) {
        this.ucPhdTime = ucPhdTime;
    }

    @Basic
    @Column(name = "ucPHD")
    public String getUcPhd() {
        return ucPhd;
    }

    public void setUcPhd(String ucPhd) {
        this.ucPhd = ucPhd;
    }

    @Basic
    @Column(name = "uaDeviationTime")
    public Integer getUaDeviationTime() {
        return uaDeviationTime;
    }

    public void setUaDeviationTime(Integer uaDeviationTime) {
        this.uaDeviationTime = uaDeviationTime;
    }

    @Basic
    @Column(name = "uaDeviation")
    public String getUaDeviation() {
        return uaDeviation;
    }

    public void setUaDeviation(String uaDeviation) {
        this.uaDeviation = uaDeviation;
    }

    @Basic
    @Column(name = "ubDeviationTime")
    public Integer getUbDeviationTime() {
        return ubDeviationTime;
    }

    public void setUbDeviationTime(Integer ubDeviationTime) {
        this.ubDeviationTime = ubDeviationTime;
    }

    @Basic
    @Column(name = "ubDeviation")
    public String getUbDeviation() {
        return ubDeviation;
    }

    public void setUbDeviation(String ubDeviation) {
        this.ubDeviation = ubDeviation;
    }

    @Basic
    @Column(name = "ucDeviationTime")
    public Integer getUcDeviationTime() {
        return ucDeviationTime;
    }

    public void setUcDeviationTime(Integer ucDeviationTime) {
        this.ucDeviationTime = ucDeviationTime;
    }

    @Basic
    @Column(name = "ucDeviation")
    public String getUcDeviation() {
        return ucDeviation;
    }

    public void setUcDeviation(String ucDeviation) {
        this.ucDeviation = ucDeviation;
    }

    @Basic
    @Column(name = "uUabDeviationTime")
    public Integer getuUabDeviationTime() {
        return uUabDeviationTime;
    }

    public void setuUabDeviationTime(Integer uUabDeviationTime) {
        this.uUabDeviationTime = uUabDeviationTime;
    }

    @Basic
    @Column(name = "uUabDeviation")
    public String getuUabDeviation() {
        return uUabDeviation;
    }

    public void setuUabDeviation(String uUabDeviation) {
        this.uUabDeviation = uUabDeviation;
    }

    @Basic
    @Column(name = "uUbcDeviationTime")
    public Integer getuUbcDeviationTime() {
        return uUbcDeviationTime;
    }

    public void setuUbcDeviationTime(Integer uUbcDeviationTime) {
        this.uUbcDeviationTime = uUbcDeviationTime;
    }

    @Basic
    @Column(name = "uUbcDeviation")
    public String getuUbcDeviation() {
        return uUbcDeviation;
    }

    public void setuUbcDeviation(String uUbcDeviation) {
        this.uUbcDeviation = uUbcDeviation;
    }

    @Basic
    @Column(name = "uUcaDeviationTime")
    public Integer getuUcaDeviationTime() {
        return uUcaDeviationTime;
    }

    public void setuUcaDeviationTime(Integer uUcaDeviationTime) {
        this.uUcaDeviationTime = uUcaDeviationTime;
    }

    @Basic
    @Column(name = "uUcaDeviation")
    public String getuUcaDeviation() {
        return uUcaDeviation;
    }

    public void setuUcaDeviation(String uUcaDeviation) {
        this.uUcaDeviation = uUcaDeviation;
    }

    @Basic
    @Column(name = "iUnbalanceTime")
    public Integer getiUnbalanceTime() {
        return iUnbalanceTime;
    }

    public void setiUnbalanceTime(Integer iUnbalanceTime) {
        this.iUnbalanceTime = iUnbalanceTime;
    }

    @Basic
    @Column(name = "iUnbalance")
    public String getiUnbalance() {
        return iUnbalance;
    }

    public void setiUnbalance(String iUnbalance) {
        this.iUnbalance = iUnbalance;
    }

    @Basic
    @Column(name = "uUnbalanceTime")
    public Integer getuUnbalanceTime() {
        return uUnbalanceTime;
    }

    public void setuUnbalanceTime(Integer uUnbalanceTime) {
        this.uUnbalanceTime = uUnbalanceTime;
    }

    @Basic
    @Column(name = "uUnbalance")
    public String getuUnbalance() {
        return uUnbalance;
    }

    public void setuUnbalance(String uUnbalance) {
        this.uUnbalance = uUnbalance;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, dataTime, totalLoadTime, totalLoad, aLoadTime, aLoad, bLoadTime, bLoad, cLoadTime, cLoad, totalReactivePowerTime, totalReactivePower, aReactivePowerTime, aReactivePower, bReactivePowerTime, bReactivePower, cReactivePowerTime, cReactivePower, totalPowerFactorTime, totalPowerFactor, aPowerFactorTime, aPowerFactor, bPowerFactorTime, bPowerFactor, cPowerFactorTime, cPowerFactor, iaTime, ia, ibTime, ib, icTime, ic, zeroiTime, zeroi, uaTime, ua, ubTime, ub, ucTime, uc, uabTime, uab, ubcTime, ubc, ucaTime, uca, iaPhdTime, iaPhd, ibPhdTime, ibPhd, icPhdTime, icPhd, uaPhdTime, uaPhd, ubPhdTime, ubPhd, ucPhdTime, ucPhd, uaDeviationTime, uaDeviation, ubDeviationTime, ubDeviation, ucDeviationTime, ucDeviation, uUabDeviationTime, uUabDeviation, uUbcDeviationTime, uUbcDeviation, uUcaDeviationTime, uUcaDeviation, iUnbalanceTime, iUnbalance, uUnbalanceTime, uUnbalance);
    }
}
