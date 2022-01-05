package com.example.power_prediction.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "power_price_time")
@Getter
@Setter
@ToString
public class PowerPriceTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,unique = true,insertable = false, updatable = false)
    private Integer id;

    @Column(name = "startTime", nullable = false)
    private Long startTime; //规则生效时间 只精确到日 次日生效

    @Column(name = "f_power_startAt", nullable = false)
    private Integer f_power_startAt;

    @Column(name = "f_power_endAt", nullable = false)
    private Integer f_power_endAt;

    @Column(name = "f_power_price", nullable = false)
    private String f_power_price;

    @Column(name = "g_power_startAt", nullable = false)
    private Integer g_power_startAt;

    @Column(name = "g_power_endAt", nullable = false)
    private Integer g_power_endAt;

    @Column(name = "g_power_price", nullable = false)
    private String g_power_price;

    @Column(name = "p_power_startAt", nullable = false)
    private Integer p_power_startAt;

    @Column(name = "p_power_endAt", nullable = false)
    private Integer p_power_endAt;

    @Column(name = "p_power_price", nullable = false)
    private String p_power_price;

    @Column(name = "j_power_startAt", nullable = false)
    private Integer j_power_startAt;

    @Column(name = "j_power_endAt", nullable = false)
    private Integer j_power_endAt;

    @Column(name = "j_power_price", nullable = false)
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
}