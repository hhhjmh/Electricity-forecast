package com.example.power_prediction.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "power_distribution_hour")
@Getter
@Setter
public class PowerDistributionHour {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "deviceId")
    private Integer deviceId;
    @Column(name = "dataTime")
    private Integer dataTime;
    @Column(name = "totalKWh")
    private String totalKWh;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PowerDistributionHour that = (PowerDistributionHour) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
