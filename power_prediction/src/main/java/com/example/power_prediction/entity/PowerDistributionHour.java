package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "power_distribution_hour", schema = "power", catalog = "")
public class PowerDistributionHour {
    private int id;
    private Integer deivceId;
    private Integer datatime;
    private String totalKWh;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "deivceId")
    public Integer getDeivceId() {
        return deivceId;
    }

    public void setDeivceId(Integer deivceId) {
        this.deivceId = deivceId;
    }

    @Basic
    @Column(name = "datatime")
    public Integer getDatatime() {
        return datatime;
    }

    public void setDatatime(Integer datatime) {
        this.datatime = datatime;
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
                Objects.equals(deivceId, that.deivceId) &&
                Objects.equals(datatime, that.datatime) &&
                Objects.equals(totalKWh, that.totalKWh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deivceId, datatime, totalKWh);
    }
}
