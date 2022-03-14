package com.example.power_prediction.service;

import com.example.power_prediction.entity.Device;
import com.example.power_prediction.entity.DeviceRelationship;

import java.util.List;

public interface DeviceManageService {
    List<Device> findAllDeviceMsg();

    Integer updateByMultipleIdForDeviceState(Device device);

    Integer save(Device device);

    Integer deleteDevice(Device device);

    List<Device> findAllDeviceMsgByState(Integer state);

    Integer addDeviceRelationship(DeviceRelationship deviceRelationship);

    Device findOneByDeviceId(Integer id);

    List<Device> findAllByIsOrNotDistribution(Device device);

    List<Device> findAllByIsOrNotDistributionAndStateAndType(DeviceRelationship deviceRelationship);

    Integer deleteDeviceRelationship(DeviceRelationship deviceRelationship);

    Integer addMultipleDeviceRelationship(String multipleId, Integer superDeviceId, Integer type);
}
