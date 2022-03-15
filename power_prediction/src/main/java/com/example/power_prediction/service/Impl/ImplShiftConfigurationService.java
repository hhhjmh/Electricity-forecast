package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.ShiftConfiguration;
import com.example.power_prediction.repository.ShiftConfigurationRepository;
import com.example.power_prediction.service.ShiftConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ImplShiftConfigurationService implements ShiftConfigurationService {

    @Autowired
    ShiftConfigurationRepository shiftConfigurationRepository;

    @Override
    public void AddShiftConfiguration(ShiftConfiguration shiftConfiguration) {
        ShiftConfiguration tempShiftConfiguration = shiftConfigurationRepository.findByClassNameAndTeamName(shiftConfiguration.getClassName(), shiftConfiguration.getTeamName());
        if(tempShiftConfiguration==null)
            shiftConfigurationRepository.save(shiftConfiguration);
    }

    @Override
    public void DeleteShiftConfiguration(ShiftConfiguration shiftConfiguration) {
        ShiftConfiguration tempShiftConfiguration = shiftConfigurationRepository.findByClassNameAndTeamName(shiftConfiguration.getClassName(), shiftConfiguration.getTeamName());
        if(tempShiftConfiguration!=null)
            shiftConfigurationRepository.delete(tempShiftConfiguration);
    }

    @Override
    public void UpdateShiftConfiguration(ShiftConfiguration shiftConfiguration) {
        if(shiftConfigurationRepository.findById(shiftConfiguration.getId())!=null) {
            shiftConfigurationRepository.save(shiftConfiguration);
        }
    }

    @Override
    public List<ShiftConfiguration> findAllByClassName(String className) {

        return shiftConfigurationRepository.findAllByClassName(className);
    }

    @Override
    public List<String > findAllClassName() {
        List<ShiftConfiguration> temp = shiftConfigurationRepository.findAll();
        List<String> ret = new LinkedList<>();

        for(int i=0; i<temp.size(); i++) {
            if(!ret.contains(temp.get(i).getClassName()))
                ret.add(temp.get(i).getClassName());
        }
        return ret;
    }
}
