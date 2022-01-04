package com.example.power_prediction.repository;

import com.example.power_prediction.entity.UtilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilEntityRepository extends JpaRepository<UtilEntity, Integer> {
    List<UtilEntity> findAllByVariableAttributeNameLikeAndState(String variableAttributeName,Integer state);
    UtilEntity findByVariableAttributeNameAndState(String variableAttributeName,Integer state);
}
