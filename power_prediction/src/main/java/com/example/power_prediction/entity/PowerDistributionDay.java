package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "power_distribution_day", schema = "power", catalog = "")
public class PowerDistributionDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int deviceId;
    private int dataTime;
    private String totalLoad;
    private String totalkWh;
    private String highKWh;
    private String lowKWh;
    private String midKWh;
    private String topKWh;
    private String totalCharge;
    private String highCharge;
    private String lowCharge;
    private String midCharge;
    private String topCharge;

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
    @Column(name = "dataTime")
    public int getDataTime() {
        return dataTime;
    }

    public void setDataTime(int dataTime) {
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
    @Column(name = "totalkWh")
    public String getTotalkWh() {
        return totalkWh;
    }

    public void setTotalkWh(String totalkWh) {
        this.totalkWh = totalkWh;
    }

    @Basic
    @Column(name = "highKWh")
    public String getHighKWh() {
        return highKWh;
    }

    public void setHighKWh(String highKWh) {
        this.highKWh = highKWh;
    }

    @Basic
    @Column(name = "lowKWh")
    public String getLowKWh() {
        return lowKWh;
    }

    public void setLowKWh(String lowKWh) {
        this.lowKWh = lowKWh;
    }

    @Basic
    @Column(name = "midKWh")
    public String getMidKWh() {
        return midKWh;
    }

    public void setMidKWh(String midKWh) {
        this.midKWh = midKWh;
    }

    @Basic
    @Column(name = "topKWh")
    public String getTopKWh() {
        return topKWh;
    }

    public void setTopKWh(String topKWh) {
        this.topKWh = topKWh;
    }

    @Basic
    @Column(name = "totalCharge")
    public String getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(String totalCharge) {
        this.totalCharge = totalCharge;
    }

    @Basic
    @Column(name = "highCharge")
    public String getHighCharge() {
        return highCharge;
    }

    public void setHighCharge(String highCharge) {
        this.highCharge = highCharge;
    }

    @Basic
    @Column(name = "lowCharge")
    public String getLowCharge() {
        return lowCharge;
    }

    public void setLowCharge(String lowCharge) {
        this.lowCharge = lowCharge;
    }

    @Basic
    @Column(name = "midCharge")
    public String getMidCharge() {
        return midCharge;
    }

    public void setMidCharge(String midCharge) {
        this.midCharge = midCharge;
    }

    @Basic
    @Column(name = "topCharge")
    public String getTopCharge() {
        return topCharge;
    }

    public void setTopCharge(String topCharge) {
        this.topCharge = topCharge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerDistributionDay that = (PowerDistributionDay) o;
        return id == that.id &&
                deviceId == that.deviceId &&
                dataTime == that.dataTime &&
                Objects.equals(totalLoad, that.totalLoad) &&
                Objects.equals(totalkWh, that.totalkWh) &&
                Objects.equals(highKWh, that.highKWh) &&
                Objects.equals(lowKWh, that.lowKWh) &&
                Objects.equals(midKWh, that.midKWh) &&
                Objects.equals(topKWh, that.topKWh) &&
                Objects.equals(totalCharge, that.totalCharge) &&
                Objects.equals(highCharge, that.highCharge) &&
                Objects.equals(lowCharge, that.lowCharge) &&
                Objects.equals(midCharge, that.midCharge) &&
                Objects.equals(topCharge, that.topCharge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceId, dataTime, totalLoad, totalkWh, highKWh, lowKWh, midKWh, topKWh, totalCharge, highCharge, lowCharge, midCharge, topCharge);
    }
}
