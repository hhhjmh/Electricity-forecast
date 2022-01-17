package com.example.power_prediction.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "power_bill_by_day")
@Getter
@Setter
public class PowerBillByDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,unique = true,insertable = false, updatable = false)
    private Integer id;
    @Column(name = "date_time", nullable = false)
    private String dateTime;
    @Column(name = "f_power", nullable = false)
    private String f_power;
    @Column(name = "g_power", nullable = false)
    private String g_power;
    @Column(name = "p_power", nullable = false)
    private String p_power;
    @Column(name = "j_power", nullable = false)
    private String j_power;
    @Column(name = "f_power_price", nullable = false)
    private String f_power_price;
    @Column(name = "g_power_price", nullable = false)
    private String g_power_price;
    @Column(name = "p_power_price", nullable = false)
    private String p_power_price;
    @Column(name = "j_power_price", nullable = false)
    private String j_power_price;
    @Column(name = "deviceId", nullable = false)
    private Integer deviceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getF_power() {
        return f_power;
    }

    public void setF_power(String f_power) {
        this.f_power = f_power;
    }

    public String getG_power() {
        return g_power;
    }

    public void setG_power(String g_power) {
        this.g_power = g_power;
    }

    public String getP_power() {
        return p_power;
    }

    public void setP_power(String p_power) {
        this.p_power = p_power;
    }

    public String getJ_power() {
        return j_power;
    }

    public void setJ_power(String j_power) {
        this.j_power = j_power;
    }

    public String getF_power_price() {
        return f_power_price;
    }

    public void setF_power_price(String f_power_price) {
        this.f_power_price = f_power_price;
    }

    public String getG_power_price() {
        return g_power_price;
    }

    public void setG_power_price(String g_power_price) {
        this.g_power_price = g_power_price;
    }

    public String getP_power_price() {
        return p_power_price;
    }

    public void setP_power_price(String p_power_price) {
        this.p_power_price = p_power_price;
    }

    public String getJ_power_price() {
        return j_power_price;
    }

    public void setJ_power_price(String j_power_price) {
        this.j_power_price = j_power_price;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PowerBillByDay that = (PowerBillByDay) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "PowerBillByDay{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", f_power='" + f_power + '\'' +
                ", g_power='" + g_power + '\'' +
                ", p_power='" + p_power + '\'' +
                ", j_power='" + j_power + '\'' +
                ", f_power_price='" + f_power_price + '\'' +
                ", g_power_price='" + g_power_price + '\'' +
                ", p_power_price='" + p_power_price + '\'' +
                ", j_power_price='" + j_power_price + '\'' +
                ", device=" + deviceId +
                '}';
    }
}