package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "power_quality_realtime", schema = "power", catalog = "")
public class PowerQualityRealtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer dataTime;
    private Integer deviceId;
    private String iaPhd;
    private String ibPhd;
    private String icPhd;
    private String uaPhd;
    private String ubPhd;
    private String ucPhd;
    private String frequencyDeviation;
    private String uaDeviation;
    private String ubDeviation;
    private String ucDeviation;
    private String uUabDeviation;
    private String uUbcDeviation;
    private String uUcaDeviation;
    private String iUnbalance;
    private String uUnbalance;

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
    @Column(name = "deviceId")
    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
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
    @Column(name = "frequencyDeviation")
    public String getFrequencyDeviation() {
        return frequencyDeviation;
    }

    public void setFrequencyDeviation(String frequencyDeviation) {
        this.frequencyDeviation = frequencyDeviation;
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
        PowerQualityRealtime that = (PowerQualityRealtime) o;
        return id == that.id &&
                Objects.equals(dataTime, that.dataTime) &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(iaPhd, that.iaPhd) &&
                Objects.equals(ibPhd, that.ibPhd) &&
                Objects.equals(icPhd, that.icPhd) &&
                Objects.equals(uaPhd, that.uaPhd) &&
                Objects.equals(ubPhd, that.ubPhd) &&
                Objects.equals(ucPhd, that.ucPhd) &&
                Objects.equals(frequencyDeviation, that.frequencyDeviation) &&
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
        return Objects.hash(id, dataTime, deviceId, iaPhd, ibPhd, icPhd, uaPhd, ubPhd, ucPhd, frequencyDeviation, uaDeviation, ubDeviation, ucDeviation, uUabDeviation, uUbcDeviation, uUcaDeviation, iUnbalance, uUnbalance);
    }
}
