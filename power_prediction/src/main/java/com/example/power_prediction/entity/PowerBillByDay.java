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
    private Integer dateTime;
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