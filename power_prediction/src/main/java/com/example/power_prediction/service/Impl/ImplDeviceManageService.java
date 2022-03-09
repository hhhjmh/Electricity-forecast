package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.Device;
import com.example.power_prediction.entity.DeviceRelationship;
import com.example.power_prediction.repository.DeviceRelationshipRepository;
import com.example.power_prediction.repository.DeviceRepository;
import com.example.power_prediction.service.DeviceManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplDeviceManageService implements DeviceManageService {
    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    DeviceRelationshipRepository deviceRelationshipRepository;

    @Override
    public List<Device> findAllDeviceMsg() {
//       deviceRepository.findAllByAssetNumberIsNotNull();
//        for (Device d : devices) {
//            if (d.getAssetNumber() == null) {
//                devices.remove(d);
//            }
//        }
        return deviceRepository.findAll();
    }

    @Override
    public Integer updateByMultipleIdForDeviceState(Device device) {
        try {
            String[] idList = device.getName().split(",");
            List<Integer> idListNew = new ArrayList<>();
            for (String deviceId : idList) {
                idListNew.add(Integer.valueOf(deviceId));
            }
            deviceRepository.updateDeviceState(device.getState(), idListNew);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Integer save(Device device) {
        try {
            deviceRepository.save(device);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Integer deleteDevice(Device device) {
        try {
            deviceRepository.deleteById(device.getId());
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Device> findAllDeviceMsgByState(Integer state) {
        return deviceRepository.findAllByState(state);
    }

    @Override
    public Integer addDeviceRelationship(DeviceRelationship deviceRelationship) {
        try {
            if (deviceRelationship.getSuperDeviceId() != null) {
                DeviceRelationship superDevice = deviceRelationshipRepository.findFirstByDeviceId(deviceRelationship.getSuperDeviceId());
                superDevice.setSublayerDeviceId(deviceRelationship.getDeviceId());
                superDevice.setId(null);
                deviceRelationshipRepository.save(superDevice);
            }
            deviceRelationshipRepository.save(deviceRelationship);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public Device findOneByDeviceId(Integer id) {

        return deviceRepository.findAllById(id);

    }

    @Override
    public List<Device> findAllByIsOrNotDistribution(Device device) {
        return deviceRepository.findAllByDistributionStateAndState(device.getDistributionState(),device.getState());
    }
}
