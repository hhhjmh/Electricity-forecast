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