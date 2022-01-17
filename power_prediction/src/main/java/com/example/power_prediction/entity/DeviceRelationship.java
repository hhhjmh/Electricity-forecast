package com.example.power_prediction.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "device_relationship", schema = "power")
public class DeviceRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false,unique = true,insertable = false, updatable = false)
    private Integer id;
    private Integer deviceId;
    private Integer type;
    private Integer superDeviceId;
    private Integer sublayerDeviceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSuperDeviceId() {
        return superDeviceId;
    }

    public void setSuperDeviceId(Integer superDeviceId) {
        this.superDeviceId = superDeviceId;
    }

    public Integer getSublayerDeviceId() {
        return sublayerDeviceId;
    }

    public void setSublayerDeviceId(Integer sublayerDeviceId) {
        this.sublayerDeviceId = sublayerDeviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DeviceRelationship that = (DeviceRelationship) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
