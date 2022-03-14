package com.example.power_prediction.repository;

import com.example.power_prediction.entity.DeviceRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DeviceRelationshipRepository extends JpaRepository<DeviceRelationship, Integer> {


    @Query(value = "SELECT device.name,device_relationship.* from device,device_relationship where device.id=device_relationship.deviceId And device_relationship.type=:type1 And device.state = 1", nativeQuery = true)
    List<Object[]> findDeviceRelationship(@Param("type1") Integer type1);

    @Query(value = "SELECT device.name,device_relationship.*,device.userDepartment from device,device_relationship where device.id=device_relationship.deviceId And device_relationship.type=:type1 And device.userDepartment=:userDepartment And device.state = 1", nativeQuery = true)
    List<Object[]> findDeviceRelationshipAndUserDepartment(@Param("type1") Integer type1,@Param("userDepartment")String userDepartment);

    @Query(value = "SELECT device.name,device_relationship.* from device,device_relationship where device.id=device_relationship.deviceId And device_relationship.type=:type1 And device_relationship.sublayerDeviceId =:sublayerDeviceId And device.state = 1", nativeQuery = true)
    List<Object[]> findDeviceRelationshipBySublayerDeviceId(@Param("type1") Integer type1, @Param("sublayerDeviceId") Integer sublayerDeviceId);

    @Query(value = "SELECT device.name,device_relationship.* from device,device_relationship where device.id=device_relationship.deviceId And device_relationship.type=:type1 And device_relationship.superDeviceId =:superDeviceId And device.state = 1 ORDER BY  sublayerDeviceId Desc", nativeQuery = true)
    List<Object[]> findDeviceRelationshipBySuperDeviceId(@Param("type1") Integer type1, @Param("superDeviceId") Integer superDeviceId);

    DeviceRelationship findFirstByDeviceId(Integer deviceId);

    List<DeviceRelationship> findAllByDeviceIdOrderBySublayerDeviceIdAsc(Integer deviceId);

    DeviceRelationship findFirstByDeviceIdAndSublayerDeviceId(Integer deviceId,Integer sublayerDeviceId);

    List<DeviceRelationship> findDistinctByType(Integer type);


    @Query(value = "SELECT * from device_relationship where  type=:type1 And (superDeviceId =:superDeviceId Or deviceId=:deviceId Or  sublayerDeviceId=:sublayerDeviceId)", nativeQuery = true)
    List<DeviceRelationship> findAllByTypeAndDeviceIdOrSublayerDeviceIdOrSuperDeviceId(@Param("type1")Integer type1,@Param("deviceId")Integer deviceId,@Param("sublayerDeviceId")Integer sublayerDeviceId,@Param("superDeviceId")Integer superDeviceId);

    @Query(value = "SELECT * from device_relationship where  type=:type1 And (superDeviceId =:superDeviceId Or deviceId=:deviceId)", nativeQuery = true)
    List<DeviceRelationship> findAllByTypeAndDeviceIdOrSuperDeviceId(@Param("type1")Integer type1,@Param("deviceId")Integer deviceId,@Param("superDeviceId")Integer superDeviceId);
}
