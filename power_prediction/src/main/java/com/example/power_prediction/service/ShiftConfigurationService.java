package com.example.power_prediction.service;

import com.example.power_prediction.entity.ShiftConfiguration;

import java.util.List;
import java.util.Set;

public interface ShiftConfigurationService {

    void AddShiftConfiguration(ShiftConfiguration shiftConfiguration);

    void DeleteShiftConfiguration(ShiftConfiguration shiftConfiguration);

    void UpdateShiftConfiguration(ShiftConfiguration shiftConfiguration);

    List<ShiftConfiguration> findAllByClassName(String className);

    List<String> findAllClassName();
}
