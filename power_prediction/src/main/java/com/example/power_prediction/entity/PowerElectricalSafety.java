package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "power_electrical_safety", schema = "power", catalog = "")
public class PowerElectricalSafety {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int deviceId;
    private Integer dataTime;
    private Integer totalLoad;
    private Integer aLoad;
    private Integer bLoad;
    private Integer cLoad;
    private Integer ia;
    private Integer ib;
    private Integer ic;
    private Integer zeroi;
    private Integer ua;
    private Integer ub;
    private Integer uc;
    private Integer uab;
    private Integer ubc;
    private Integer uca;
    private Integer temperature;
    private Integer uUnbalance;
    private Integer iUnbalance;
    private Integer frequencyDeviation;
    private Integer iaPhd;
    private Integer ibPhd;
    private Integer icPhd;
    private Integer uaPhd;
    private Integer ubPhd;
    private Integer ucPhd;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getuUnbalance() {
        return uUnbalance;
    }

    public void setuUnbalance(Integer uUnbalance) {
        this.uUnbalance = uUnbalance;
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
    @Column(name = "dataTime")
    public Integer getDataTime() {
        return dataTime;
    }

    public void setDataTime(Integer dataTime) {
        this.dataTime = dataTime;
    }

    @Basic
    @Column(name = "totalLoad")
    public Integer getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(Integer totalLoad) {
        this.totalLoad = totalLoad;
    }

    @Basic
    @Column(name = "aLoad")
    public Integer getaLoad() {
        return aLoad;
    }

    public void setaLoad(Integer aLoad) {
        this.aLoad = aLoad;
    }

    @Basic
    @Column(name = "bLoad")
    public Integer getbLoad() {
        return bLoad;
    }

    public void setbLoad(Integer bLoad) {
        this.bLoad = bLoad;
    }

    @Basic
    @Column(name = "cLoad")
    public Integer getcLoad() {
        return cLoad;
    }

    public void setcLoad(Integer cLoad) {
        this.cLoad = cLoad;
    }

    @Basic
    @Column(name = "ia")
    public Integer getIa() {
        return ia;
    }

    public void setIa(Integer ia) {
        this.ia = ia;
    }

    @Basic
    @Column(name = "ib")
    public Integer getIb() {
        return ib;
    }

    public void setIb(Integer ib) {
        this.ib = ib;
    }

    @Basic
    @Column(name = "ic")
    public Integer getIc() {
        return ic;
    }

    public void setIc(Integer ic) {
        this.ic = ic;
    }

    @Basic
    @Column(name = "zeroi")
    public Integer getZeroi() {
        return zeroi;
    }

    public void setZeroi(Integer zeroi) {
        this.zeroi = zeroi;
    }

    @Basic
    @Column(name = "ua")
    public Integer getUa() {
        return ua;
    }

    public void setUa(Integer ua) {
        this.ua = ua;
    }

    @Basic
    @Column(name = "ub")
    public Integer getUb() {
        return ub;
    }

    public void setUb(Integer ub) {
        this.ub = ub;
    }

    @Basic
    @Column(name = "uc")
    public Integer getUc() {
        return uc;
    }

    public void setUc(Integer uc) {
        this.uc = uc;
    }

    @Basic
    @Column(name = "uab")
    public Integer getUab() {
        return uab;
    }

    public void setUab(Integer uab) {
        this.uab = uab;
    }

    @Basic
    @Column(name = "ubc")
    public Integer getUbc() {
        return ubc;
    }

    public void setUbc(Integer ubc) {
        this.ubc = ubc;
    }

    @Basic
    @Column(name = "uca")
    public Integer getUca() {
        return uca;
    }

    public void setUca(Integer uca) {
        this.uca = uca;
    }

    @Basic
    @Column(name = "temperature")
    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }



    @Basic
    @Column(name = "iUnbalance")
    public Integer getiUnbalance() {
        return iUnbalance;
    }

    public void setiUnbalance(Integer iUnbalance) {
        this.iUnbalance = iUnbalance;
    }

    @Basic
    @Column(name = "frequencyDeviation")
    public Integer getFrequencyDeviation() {
        return frequencyDeviation;
    }

    public void setFrequencyDeviation(Integer frequencyDeviation) {
        this.frequencyDeviation = frequencyDeviation;
    }

    @Basic
    @Column(name = "iaPHD")
    public Integer getIaPhd() {
        return iaPhd;
    }

    public void setIaPhd(Integer iaPhd) {
        this.iaPhd = iaPhd;
    }

    @Basic
    @Column(name = "ibPHD")
    public Integer getIbPhd() {
        return ibPhd;
    }

    public void setIbPhd(Integer ibPhd) {
        this.ibPhd = ibPhd;
    }

    @Basic
    @Column(name = "icPHD")
    public Integer getIcPhd() {
        return icPhd;
    }

    public void setIcPhd(Integer icPhd) {
        this.icPhd = icPhd;
    }

    @Basic
    @Column(name = "uaPHD")
    public Integer getUaPhd() {
        return uaPhd;
    }

    public void setUaPhd(Integer uaPhd) {
        this.uaPhd = uaPhd;
    }

    @Basic
    @Column(name = "ubPHD")
    public Integer getUbPhd() {
        return ubPhd;
    }

    public void setUbPhd(Integer ubPhd) {
        this.ubPhd = ubPhd;
    }

    @Basic
    @Column(name = "ucPHD")
    public Integer getUcPhd() {
        return ucPhd;
    }

    public void setUcPhd(Integer ucPhd) {
        this.ucPhd = ucPhd;
    }

}
