package com.example.power_prediction.repository;

import com.example.power_prediction.entity.ShiftConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShiftConfigurationRepository extends JpaRepository<ShiftConfiguration,Integer> {

    ShiftConfiguration findByClassNameAndTeamName(String className, String teamName);

    List<ShiftConfiguration> findAllByClassName(String className);

}
