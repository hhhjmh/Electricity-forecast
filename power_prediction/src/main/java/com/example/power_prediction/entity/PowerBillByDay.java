package com.example.power_prediction.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
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

    public  Map<String, Object> toMap(){
        Map<String, Object> tmp = new HashMap<>();
        tmp.put("f_power", this.getF_power());
        tmp.put("f_power_price", this.getF_power_price());
        tmp.put("g_power", this.getG_power());
        tmp.put("g_power_price", this.getG_power_price());
        tmp.put("p_power", this.getP_power());
        tmp.put("p_power_price", this.getP_power_price());
        tmp.put("j_power", this.getJ_power());
        tmp.put("j_power_price", this.getJ_power_price());
        return tmp;
    }
}