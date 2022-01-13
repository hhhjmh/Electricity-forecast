package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "power_distribution_hour", schema = "power", catalog = "")
public class PowerDistributionHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Integer deviceId;
    private Integer dataTime;
    private String totalKWh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "dataTime")
    public Integer getDataTime() {
        return dataTime;
    }

    public void setDataTime(Integer dataTime) {
        this.dataTime = dataTime;
    }

    @Basic
    @Column(name = "totalKWh")
    public String getTotalKWh() {
        return totalKWh;
    }

    public void setTotalKWh(String totalKWh) {
        this.totalKWh = totalKWh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerDistributionHour that = (PowerDistributionHour) o;
        return id == that.id &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(dataTime, that.dataTime) &&
                Objects.equals(totalKWh, that.totalKWh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceId, dataTime, totalKWh);
    }
}
