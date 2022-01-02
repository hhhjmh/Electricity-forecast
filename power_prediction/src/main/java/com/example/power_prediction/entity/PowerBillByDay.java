package com.example.power_prediction.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "power_bill_by_day")
public class PowerBillByDay {

    private Integer id;
    private Integer dateTime;
    private String f_power;
    private String g_power;
    private String p_power;
    private String j_power;
    private String f_power_price;
    private String g_power_price;
    private String p_power_price;
    private String j_power_price;
    private Integer deviceId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dataTime")
    public Integer getDateTime() {
        return dateTime;
    }

    public void setDateTime(Integer dateTime) {
        this.dateTime = dateTime;
    }

    @Basic
    @Column(name = "f_power")
    public String getF_power() {
        return f_power;
    }

    public void setF_power(String f_power) {
        this.f_power = f_power;
    }

    @Basic
    @Column(name = "g_power")
    public String getG_power() {
        return g_power;
    }

    public void setG_power(String g_power) {
        this.g_power = g_power;
    }

    @Basic
    @Column(name = "p_power")
    public String getP_power() {
        return p_power;
    }

    public void setP_power(String p_power) {
        this.p_power = p_power;
    }

    @Basic
    @Column(name = "g_power")
    public String getJ_power() {
        return j_power;
    }

    public void setJ_power(String j_power) {
        this.j_power = j_power;
    }

    @Basic
    @Column(name = "f_power_price")
    public String getF_power_price() {
        return f_power_price;
    }

    public void setF_power_price(String f_power_price) {
        this.f_power_price = f_power_price;
    }

    @Basic
    @Column(name = "g_power_price")
    public String getG_power_price() {
        return g_power_price;
    }

    public void setG_power_price(String g_power_price) {
        this.g_power_price = g_power_price;
    }

    @Basic
    @Column(name = "p_power_price")
    public String getP_power_price() {
        return p_power_price;
    }

    public void setP_power_price(String p_power_price) {
        this.p_power_price = p_power_price;
    }

    @Basic
    @Column(name = "j_power_price")
    public String getJ_power_price() {
        return j_power_price;
    }

    public void setJ_power_price(String j_power_price) {
        this.j_power_price = j_power_price;
    }


    @Basic
    @Column(name = "device_id")
    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PowerBillByDay)) return false;
        PowerBillByDay that = (PowerBillByDay) o;
        return id.equals(that.id) &&
                deviceId.equals(that.deviceId) &&
                dateTime.equals(that.dateTime) &&
                f_power.equals(that.f_power) &&
                g_power.equals(that.g_power) &&
                p_power.equals(that.p_power) &&
                j_power.equals(that.j_power) &&
                f_power_price.equals(that.f_power_price) &&
                g_power_price.equals(that.g_power_price) &&
                p_power_price.equals(that.p_power_price) &&
                j_power_price.equals(that.j_power_price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, f_power, g_power, p_power, j_power, f_power_price, g_power_price, p_power_price, j_power_price, deviceId);
    }
}