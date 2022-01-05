package com.example.power_prediction.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "device")
@Getter
@Setter
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,unique = true,insertable = false, updatable = false)
    private Integer id;
    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity=PowerBillByDay.class,cascade = CascadeType.REMOVE)
    @JoinColumn(name="deviceId",referencedColumnName="id")
    private List<PowerBillByDay> powerBillByDayList;

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
