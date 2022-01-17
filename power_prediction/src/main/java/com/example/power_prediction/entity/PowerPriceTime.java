package com.example.power_prediction.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "power_price_time")
@Getter
@Setter
public class PowerPriceTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, insertable = false, updatable = false)
    private Integer id;
    @Column(name = "startTime", nullable = false)
    private Integer startTime; //规则生效时间 只精确到日 次日生效
    @Column(name = "f_power_startAt")
    private String f_power_startAt;
    @Column(name = "f_power_endAt")
    private String f_power_endAt;
    @Column(name = "f_power_price")
    private String f_power_price;
    @Column(name = "g_power_startAt")
    private String g_power_startAt;
    @Column(name = "g_power_endAt")
    private String g_power_endAt;
    @Column(name = "g_power_price")
    private String g_power_price;
    @Column(name = "p_power_startAt")
    private String p_power_startAt;
    @Column(name = "p_power_endAt")
    private String p_power_endAt;
    @Column(name = "p_power_price")
    private String p_power_price;
    @Column(name = "j_power_startAt")
    private String j_power_startAt;
    @Column(name = "j_power_endAt")
    private String j_power_endAt;
    @Column(name = "j_power_price")
    private String j_power_price;
    @Column(name = "deviceTypeId", nullable = false)
    private Integer deviceTypeId; //对应DeviceRelationShip的type字段

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public String getF_power_startAt() {
        return f_power_startAt;
    }

    public void setF_power_startAt(String f_power_startAt) {
        this.f_power_startAt = f_power_startAt;
    }

    public String getF_power_endAt() {
        return f_power_endAt;
    }

    public void setF_power_endAt(String f_power_endAt) {
        this.f_power_endAt = f_power_endAt;
    }

    public String getF_power_price() {
        return f_power_price;
    }

    public void setF_power_price(String f_power_price) {
        this.f_power_price = f_power_price;
    }

    public String getG_power_startAt() {
        return g_power_startAt;
    }

    public void setG_power_startAt(String g_power_startAt) {
        this.g_power_startAt = g_power_startAt;
    }

    public String getG_power_endAt() {
        return g_power_endAt;
    }

    public void setG_power_endAt(String g_power_endAt) {
        this.g_power_endAt = g_power_endAt;
    }

    public String getG_power_price() {
        return g_power_price;
    }

    public void setG_power_price(String g_power_price) {
        this.g_power_price = g_power_price;
    }

    public String getP_power_startAt() {
        return p_power_startAt;
    }

    public void setP_power_startAt(String p_power_startAt) {
        this.p_power_startAt = p_power_startAt;
    }

    public String getP_power_endAt() {
        return p_power_endAt;
    }

    public void setP_power_endAt(String p_power_endAt) {
        this.p_power_endAt = p_power_endAt;
    }

    public String getP_power_price() {
        return p_power_price;
    }

    public void setP_power_price(String p_power_price) {
        this.p_power_price = p_power_price;
    }

    public String getJ_power_startAt() {
        return j_power_startAt;
    }

    public void setJ_power_startAt(String j_power_startAt) {
        this.j_power_startAt = j_power_startAt;
    }

    public String getJ_power_endAt() {
        return j_power_endAt;
    }

    public void setJ_power_endAt(String j_power_endAt) {
        this.j_power_endAt = j_power_endAt;
    }

    public String getJ_power_price() {
        return j_power_price;
    }

    public void setJ_power_price(String j_power_price) {
        this.j_power_price = j_power_price;
    }

    public Integer getDeviceTypeId() {
        return deviceTypeId;
    }

    public void setDeviceTypeId(Integer deviceTypeId) {
        this.deviceTypeId = deviceTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PowerPriceTime that = (PowerPriceTime) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", f_power_startAt=" + f_power_startAt +
                ", f_power_endAt=" + f_power_endAt +
                ", f_power_price='" + f_power_price + '\'' +
                ", g_power_startAt=" + g_power_startAt +
                ", g_power_endAt=" + g_power_endAt +
                ", g_power_price='" + g_power_price + '\'' +
                ", p_power_startAt=" + p_power_startAt +
                ", p_power_endAt=" + p_power_endAt +
                ", p_power_price='" + p_power_price + '\'' +
                ", j_power_startAt=" + j_power_startAt +
                ", j_power_endAt=" + j_power_endAt +
                ", j_power_price='" + j_power_price + '\'' +
                ", deviceTypeId=" + deviceTypeId +
                '}';
    }
}