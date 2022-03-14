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
import java.util.Map;

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
    public Device findOneByDeviceId(Integer id) {

        return deviceRepository.findAllById(id);

    }

    @Override
    public List<Device> findAllByIsOrNotDistribution(Device device) {
        return deviceRepository.findAllByDistributionStateAndState(device.getDistributionState(), device.getState());
    }

    @Override
    public List<Device> findAllByIsOrNotDistributionAndStateAndType(DeviceRelationship deviceRelationship) {
        List<DeviceRelationship> deviceRelationships = deviceRelationshipRepository.findDistinctByType(deviceRelationship.getType());
        List<Integer> idList = new ArrayList<>();
        if (deviceRelationships.size() == 0) {
            return deviceRepository.findAllByState(1);
        } else {
            for (DeviceRelationship deviceRelationship1 : deviceRelationships) {
                idList.add(deviceRelationship1.getDeviceId());
            }
            return deviceRepository.findAllByIdIsNotInAndState(idList, 1);
        }
    }

    @Override
    public Integer addDeviceRelationship(DeviceRelationship deviceRelationship) {
        try {
            if (deviceRelationship.getSuperDeviceId() != null) {
                List<DeviceRelationship> superDevices = deviceRelationshipRepository.findAllByDeviceIdOrderBySublayerDeviceIdAsc(deviceRelationship.getSuperDeviceId());
                Integer flag = 0;
                for (DeviceRelationship superDevice : superDevices
                ) {

//                    if(superDevice.getSuperDeviceId()==null){
//                        break;
//                    }
                    if (superDevice.getSublayerDeviceId() == null && flag == 0) {
                        superDevice.setSublayerDeviceId(deviceRelationship.getDeviceId());
                        deviceRelationshipRepository.save(superDevice);
                        flag += 1;
                    } else if (flag == 0) {
                        {
                            DeviceRelationship newSuperDevice = new DeviceRelationship();
                            newSuperDevice.setDeviceId(superDevice.getDeviceId());
                            newSuperDevice.setType(superDevice.getType());
                            newSuperDevice.setSuperDeviceId(superDevice.getSuperDeviceId());
                            newSuperDevice.setSublayerDeviceId(deviceRelationship.getDeviceId());
                            deviceRelationshipRepository.save(newSuperDevice);
                            flag += 1;
                        }
                    }
                }
//                }else {
//                    DeviceRelationship superDeviceRelationship=new DeviceRelationship();
//                    superDeviceRelationship.setSublayerDeviceId(deviceRelationship.getDeviceId());
//                    superDeviceRelationship.setDeviceId(deviceRelationship.getSuperDeviceId());
//                    superDevice
//                }
            }
            deviceRelationshipRepository.save(deviceRelationship);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }


    @Override
    public Integer deleteDeviceRelationship(DeviceRelationship deviceRelationship) {

        try {
            List<DeviceRelationship> deviceRelationshipList = deviceRelationshipRepository.findAllByTypeAndDeviceIdOrSublayerDeviceIdOrSuperDeviceId(deviceRelationship.getType(), deviceRelationship.getDeviceId(), deviceRelationship.getDeviceId(), deviceRelationship.getDeviceId());
            for (DeviceRelationship d : deviceRelationshipList) {
                deleteDeviceTree(d, deviceRelationship);
            }
            return 1;
        } catch (Exception e) {
            return -1;
        }

    }

    @Override
    public Integer addMultipleDeviceRelationship(String multipleId, Integer superDeviceId, Integer type) {
        try {
            String[] idList = multipleId.split(",");
            for (String a : idList
            ) {
                DeviceRelationship deviceRelationship = new DeviceRelationship();
                deviceRelationship.setDeviceId(Integer.valueOf(a));
                deviceRelationship.setSuperDeviceId(superDeviceId);
                deviceRelationship.setType(type);
                addDeviceRelationship(deviceRelationship);
            }
            return 1;
        } catch (Exception e) {
            return -1;
        }
    }

    private void deleteDeviceTree(DeviceRelationship node, DeviceRelationship parentNode) {
        if (node.getSublayerDeviceId() == parentNode.getDeviceId()) {
            node.setSublayerDeviceId(null);
            deviceRelationshipRepository.save(node);
        } else if (node.getSuperDeviceId() == parentNode.getDeviceId()) {
            List<DeviceRelationship> deviceRelationshipList = deviceRelationshipRepository.findAllByTypeAndDeviceIdOrSuperDeviceId(node.getType(), node.getDeviceId(), node.getDeviceId());
            for (DeviceRelationship childNode : deviceRelationshipList) {
                deleteDeviceTree(childNode, node);
            }
        } else
            deviceRelationshipRepository.delete(node);
    }

}
