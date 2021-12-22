package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "power_analyse_month_max", schema = "power", catalog = "")
public class PowerAnalyseMonthMax {
    private int id;
    private Integer dataTime;
    private String totalLoad;
    private String aLoad;
    private String bLoad;
    private String cLoad;
    private String totalReactivePower;
    private String aReactivePower;
    private String bReactivePower;
    private String cReactivePower;
    private String totalPowerFactor;
    private String aPowerFactor;
    private String bPowerFactor;
    private String cPowerFactor;
    private String ia;
    private String ib;
    private String ic;
    private String zeroi;
    private String ua;
    private String ub;
    private String uc;
    private String uab;
    private String ubc;
    private String uca;
    private String iaPhd;
    private String ibPhd;
    private String icPhd;
    private String uaPhd;
    private String ubPhd;
    private String ucPhd;
    private String uaDeviation;
    private String ubDeviation;
    private String ucDeviation;
    private String uUabDeviation;
    private String uUbcDeviation;
    private String uUcaDeviation;
    private String iUnbalance;
    private String uUnbalance;

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
    @Column(name = "totalLoad")
    public String getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(String totalLoad) {
        this.totalLoad = totalLoad;
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
    @Column(name = "bLoad")
    public String getbLoad() {
        return bLoad;
    }

    public void setbLoad(String bLoad) {
        this.bLoad = bLoad;
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
    @Column(name = "totalReactivePower")
    public String getTotalReactivePower() {
        return totalReactivePower;
    }

    public void setTotalReactivePower(String totalReactivePower) {
        this.totalReactivePower = totalReactivePower;
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
    @Column(name = "bReactivePower")
    public String getbReactivePower() {
        return bReactivePower;
    }

    public void setbReactivePower(String bReactivePower) {
        this.bReactivePower = bReactivePower;
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
    @Column(name = "totalPowerFactor")
    public String getTotalPowerFactor() {
        return totalPowerFactor;
    }

    public void setTotalPowerFactor(String totalPowerFactor) {
        this.totalPowerFactor = totalPowerFactor;
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
    @Column(name = "bPowerFactor")
    public String getbPowerFactor() {
        return bPowerFactor;
    }

    public void setbPowerFactor(String bPowerFactor) {
        this.bPowerFactor = bPowerFactor;
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
    @Column(name = "ia")
    public String getIa() {
        return ia;
    }

    public void setIa(String ia) {
        this.ia = ia;
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
    @Column(name = "ic")
    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
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
    @Column(name = "ua")
    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
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
    @Column(name = "uc")
    public String getUc() {
        return uc;
    }

    public void setUc(String uc) {
        this.uc = uc;
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
    @Column(name = "ubc")
    public String getUbc() {
        return ubc;
    }

    public void setUbc(String ubc) {
        this.ubc = ubc;
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
    @Column(name = "iaPHD")
    public String getIaPhd() {
        return iaPhd;
    }

    public void setIaPhd(String iaPhd) {
        this.iaPhd = iaPhd;
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
    @Column(name = "icPHD")
    public String getIcPhd() {
        return icPhd;
    }

    public void setIcPhd(String icPhd) {
        this.icPhd = icPhd;
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
    @Column(name = "ubPHD")
    public String getUbPhd() {
        return ubPhd;
    }

    public void setUbPhd(String ubPhd) {
        this.ubPhd = ubPhd;
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
    @Column(name = "uaDeviation")
    public String getUaDeviation() {
        return uaDeviation;
    }

    public void setUaDeviation(String uaDeviation) {
        this.uaDeviation = uaDeviation;
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
    @Column(name = "ucDeviation")
    public String getUcDeviation() {
        return ucDeviation;
    }

    public void setUcDeviation(String ucDeviation) {
        this.ucDeviation = ucDeviation;
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
    @Column(name = "uUbcDeviation")
    public String getuUbcDeviation() {
        return uUbcDeviation;
    }

    public void setuUbcDeviation(String uUbcDeviation) {
        this.uUbcDeviation = uUbcDeviation;
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
    @Column(name = "iUnbalance")
    public String getiUnbalance() {
        return iUnbalance;
    }

    public void setiUnbalance(String iUnbalance) {
        this.iUnbalance = iUnbalance;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerAnalyseMonthMax that = (PowerAnalyseMonthMax) o;
        return id == that.id &&
                Objects.equals(dataTime, that.dataTime) &&
                Objects.equals(totalLoad, that.totalLoad) &&
                Objects.equals(aLoad, that.aLoad) &&
                Objects.equals(bLoad, that.bLoad) &&
                Objects.equals(cLoad, that.cLoad) &&
                Objects.equals(totalReactivePower, that.totalReactivePower) &&
                Objects.equals(aReactivePower, that.aReactivePower) &&
                Objects.equals(bReactivePower, that.bReactivePower) &&
                Objects.equals(cReactivePower, that.cReactivePower) &&
                Objects.equals(totalPowerFactor, that.totalPowerFactor) &&
                Objects.equals(aPowerFactor, that.aPowerFactor) &&
                Objects.equals(bPowerFactor, that.bPowerFactor) &&
                Objects.equals(cPowerFactor, that.cPowerFactor) &&
                Objects.equals(ia, that.ia) &&
                Objects.equals(ib, that.ib) &&
                Objects.equals(ic, that.ic) &&
                Objects.equals(zeroi, that.zeroi) &&
                Objects.equals(ua, that.ua) &&
                Objects.equals(ub, that.ub) &&
                Objects.equals(uc, that.uc) &&
                Objects.equals(uab, that.uab) &&
                Objects.equals(ubc, that.ubc) &&
                Objects.equals(uca, that.uca) &&
                Objects.equals(iaPhd, that.iaPhd) &&
                Objects.equals(ibPhd, that.ibPhd) &&
                Objects.equals(icPhd, that.icPhd) &&
                Objects.equals(uaPhd, that.uaPhd) &&
                Objects.equals(ubPhd, that.ubPhd) &&
                Objects.equals(ucPhd, that.ucPhd) &&
                Objects.equals(uaDeviation, that.uaDeviation) &&
                Objects.equals(ubDeviation, that.ubDeviation) &&
                Objects.equals(ucDeviation, that.ucDeviation) &&
                Objects.equals(uUabDeviation, that.uUabDeviation) &&
                Objects.equals(uUbcDeviation, that.uUbcDeviation) &&
                Objects.equals(uUcaDeviation, that.uUcaDeviation) &&
                Objects.equals(iUnbalance, that.iUnbalance) &&
                Objects.equals(uUnbalance, that.uUnbalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataTime, totalLoad, aLoad, bLoad, cLoad, totalReactivePower, aReactivePower, bReactivePower, cReactivePower, totalPowerFactor, aPowerFactor, bPowerFactor, cPowerFactor, ia, ib, ic, zeroi, ua, ub, uc, uab, ubc, uca, iaPhd, ibPhd, icPhd, uaPhd, ubPhd, ucPhd, uaDeviation, ubDeviation, ucDeviation, uUabDeviation, uUbcDeviation, uUcaDeviation, iUnbalance, uUnbalance);
    }
}
