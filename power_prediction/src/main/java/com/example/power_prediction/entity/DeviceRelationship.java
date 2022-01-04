package com.example.power_prediction.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "device_relationship", schema = "power", catalog = "")
public class DeviceRelationship {
    private int id;
    private int deviceId;
    private int type;
    private Integer superDeviceId;
    private Integer sublayerDeviceId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "deviceId")
    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "superDeviceId")
    public Integer getSuperDeviceId() {
        return superDeviceId;
    }

    public void setSuperDeviceId(Integer superDeviceId) {
        this.superDeviceId = superDeviceId;
    }

    @Basic
    @Column(name = "sublayerDeviceId")
    public Integer getSublayerDeviceId() {
        return sublayerDeviceId;
    }

    public void setSublayerDeviceId(Integer sublayerDeviceId) {
        this.sublayerDeviceId = sublayerDeviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceRelationship that = (DeviceRelationship) o;
        return id == that.id &&
                deviceId == that.deviceId &&
                type == that.type &&
                Objects.equals(superDeviceId, that.superDeviceId) &&
                Objects.equals(sublayerDeviceId, that.sublayerDeviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceId, type, superDeviceId, sublayerDeviceId);
    }
}
