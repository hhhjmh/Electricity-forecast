package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "power_forecast", schema = "power", catalog = "")
public class PowerForecast {
    private int id;
    private Integer deciveId;
    private String load;
    private Integer datatime;
    private Integer type;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "deciveId")
    public Integer getDeciveId() {
        return deciveId;
    }

    public void setDeciveId(Integer deciveId) {
        this.deciveId = deciveId;
    }

    @Basic
    @Column(name = "load")
    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
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
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PowerForecast that = (PowerForecast) o;
        return id == that.id &&
                Objects.equals(deciveId, that.deciveId) &&
                Objects.equals(load, that.load) &&
                Objects.equals(datatime, that.datatime) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deciveId, load, datatime, type);
    }
}
