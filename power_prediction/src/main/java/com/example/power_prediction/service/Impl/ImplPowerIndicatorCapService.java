package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.PowerIndicatorCap;
import com.example.power_prediction.repository.PowerIndicatorCapRepository;
import com.example.power_prediction.service.PowerIndicatorCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplPowerIndicatorCapService implements PowerIndicatorCapService {
    
    @Autowired
    PowerIndicatorCapRepository powerIndicatorCapRepository;

    @Override
    public int AddPowerIndicatorCap(PowerIndicatorCap powerIndicatorCap) {
        PowerIndicatorCap tempPowerIndicatorCap = powerIndicatorCapRepository.findByDeviceIdAndTypes(powerIndicatorCap.getDeviceId(), powerIndicatorCap.getTypes());
        if(tempPowerIndicatorCap==null) {
            powerIndicatorCapRepository.save(powerIndicatorCap);
            return 1;
        }
        return 0;
    }

    @Override
    public int DeletePowerIndicatorCap(PowerIndicatorCap powerIndicatorCap) {
        PowerIndicatorCap tempPowerIndicatorCap = powerIndicatorCapRepository.findByDeviceIdAndTypes(powerIndicatorCap.getDeviceId(), powerIndicatorCap.getTypes());
        if(tempPowerIndicatorCap!=null) {
            powerIndicatorCapRepository.delete(tempPowerIndicatorCap);
            return 1;
        }
        return 0;
    }

    @Override
    public int UpdatePowerIndicatorCap(PowerIndicatorCap powerIndicatorCap) {
        PowerIndicatorCap temp = powerIndicatorCapRepository.findByDeviceIdAndTypes(powerIndicatorCap.getDeviceId(), powerIndicatorCap.getTypes());
        if(temp!=null) {
            powerIndicatorCap.setId(temp.getId());
            powerIndicatorCapRepository.save(powerIndicatorCap);
            return 1;
        }
        return 0;
    }

    @Override
    public List<PowerIndicatorCap> findAllByDeviceId(int deviceId) {
        return powerIndicatorCapRepository.findAllByDeviceId(deviceId);
    }

}
