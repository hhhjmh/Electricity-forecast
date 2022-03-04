package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "power_indicator_cap", schema = "power", catalog = "")
public class PowerIndicatorCapEntity {
    private int id;
    private int deviceId;
    private String totalLoad;
    private String aLoad;
    private String bLoad;
    private String cLoad;
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
    private String temperature;
    private String uUcaDeviation;
    private String iUnbalance;
    private String frequencyDeviation;
    private String iaPhd;
    private String ibPhd;
    private String icPhd;
    private String uaPhd;
    private String ubPhd;
    private String ucPhd;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "deviceId")
    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
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
    @Column(name = "temperature")
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
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
    @Column(name = "frequencyDeviation")
    public String getFrequencyDeviation() {
        return frequencyDeviation;
    }

    public void setFrequencyDeviation(String frequencyDeviation) {
        this.frequencyDeviation = frequencyDeviation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerIndicatorCapEntity that = (PowerIndicatorCapEntity) o;
        return id == that.id &&
                deviceId == that.deviceId &&
                Objects.equals(totalLoad, that.totalLoad) &&
                Objects.equals(aLoad, that.aLoad) &&
                Objects.equals(bLoad, that.bLoad) &&
                Objects.equals(cLoad, that.cLoad) &&
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
                Objects.equals(temperature, that.temperature) &&
                Objects.equals(uUcaDeviation, that.uUcaDeviation) &&
                Objects.equals(iUnbalance, that.iUnbalance) &&
                Objects.equals(frequencyDeviation, that.frequencyDeviation) &&
                Objects.equals(iaPhd, that.iaPhd) &&
                Objects.equals(ibPhd, that.ibPhd) &&
                Objects.equals(icPhd, that.icPhd) &&
                Objects.equals(uaPhd, that.uaPhd) &&
                Objects.equals(ubPhd, that.ubPhd) &&
                Objects.equals(ucPhd, that.ucPhd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceId, totalLoad, aLoad, bLoad, cLoad, ia, ib, ic, zeroi, ua, ub, uc, uab, ubc, uca, temperature, uUcaDeviation, iUnbalance, frequencyDeviation, iaPhd, ibPhd, icPhd, uaPhd, ubPhd, ucPhd);
    }
}
