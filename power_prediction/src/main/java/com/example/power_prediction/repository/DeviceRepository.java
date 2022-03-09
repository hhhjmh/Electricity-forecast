package com.example.power_prediction.repository;

import com.example.power_prediction.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device,Integer> {
    Device findAllById(Integer id);

    List<Device> findAllByState(Integer state);


    @Transactional
    @Modifying
    @Query(value = "update device set state=:state where id in :idList", nativeQuery = true)
    void updateDeviceState(@Param("state") Integer state, @Param("idList") List<Integer> idList);

    void  deleteByIdIn(List<Integer > idList);

    List<Device> findAllByDistributionState(String distributionState);

    List<Device> findAllByDistributionStateAndState(String distributionState, Integer state);
}
