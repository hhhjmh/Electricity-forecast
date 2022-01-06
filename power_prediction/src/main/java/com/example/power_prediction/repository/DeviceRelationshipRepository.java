package com.example.power_prediction.repository;

import com.example.power_prediction.entity.DeviceRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DeviceRelationshipRepository extends JpaRepository<DeviceRelationship, Integer> {


    @Query(value = "SELECT device.name,device_relationship.* from device,device_relationship where device.id=device_relationship.deviceId And device_relationship.type=:type1 ", nativeQuery = true)
    List<Object[]> findDeviceRelationship(@Param("type1") Integer type1);

    @Query(value = "SELECT device.name,device_relationship.* from device,device_relationship where device.id=device_relationship.deviceId And device_relationship.type=:type1 And device_relationship.sublayerDeviceId =:sublayerDeviceId", nativeQuery = true)
    List<Object[]> findDeviceRelationshipBySublayerDeviceId(@Param("type1") Integer type1, @Param("sublayerDeviceId") Integer sublayerDeviceId);

    @Query(value = "SELECT device.name,device_relationship.* from device,device_relationship where device.id=device_relationship.deviceId And device_relationship.type=:type1 And device_relationship.superDeviceId =:superDeviceId", nativeQuery = true)
    List<Object[]> findDeviceRelationshipBySuperDeviceId(@Param("type1") Integer type1, @Param("superDeviceId") Integer sublayerDeviceId);

    DeviceRelationship findByDeviceId(Integer deviceId);

}
