package com.example.power_prediction.entity;

<<<<<<< HEAD
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "device", schema = "power", catalog = "")
public class Device {
    private int id;
    private String name;
    private String userDepartment;

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

=======
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "device")
@Getter
@Setter
public class Device {
>>>>>>> dev
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,unique = true,insertable = false, updatable = false)
    private Integer id;
    @Column(name = "name")
    private String name;


    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
