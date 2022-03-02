package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerDistributionDay;
import com.example.power_prediction.entity.PowerDistributionHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PowerDistributionDayRepository extends JpaRepository<PowerDistributionDay,Integer> {
    List<PowerDistributionDay> findAllByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);

    @Query(value = "select device.name,power_distribution_day.* from device,power_distribution_day where power_distribution_day.deviceId in (:idList) and device.id=power_distribution_day.deviceId and power_distribution_day.dataTime=:dataTime", nativeQuery = true)
    List<Object[]> findPowerDistributionDayByMultipleIdAndDataTime(@Param("idList") List<Integer> idList,@Param("dataTime") Integer dataTime);

    @Query(value = "select device.name,power_distribution_day.* from device,power_distribution_day where power_distribution_day.deviceId=:deviceId and device.id=power_distribution_day.deviceId and power_distribution_day.dataTime between :start and :timeEnd order by power_distribution_day.dataTime ASC ", nativeQuery = true)
    List<Object[]> findAllByDeviceAndDataTimeBetweenAsc(@Param("deviceId") Integer deviceId,@Param("start")Integer start,@Param("timeEnd") Integer timeEnd);

//
    List<PowerDistributionDay> findAllByDeviceIdInAndDataTimeBetweenOrderByDeviceId(List<Integer> idList,Integer start,Integer end);
}
