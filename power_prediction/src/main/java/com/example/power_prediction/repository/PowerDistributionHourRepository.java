package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerDistributionHour;
import com.example.power_prediction.entity.PowerRealtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PowerDistributionHourRepository extends JpaRepository<PowerDistributionHour,Integer> {
    List<PowerDistributionHour> findAllByDeviceIdAndDataTimeBetween(Integer deviceId, Integer start, Integer end);
    List<PowerDistributionHour> findAllByDeviceIdAndDataTimeBetweenOrderByDataTimeDesc(Integer deviceId, Integer start, Integer end);


    @Query(value = "select device.name,sum(power_distribution_hour.totalKWh) from device,power_distribution_hour where power_distribution_hour.deviceId=:deviceId and device.id=power_distribution_hour.deviceId and power_distribution_hour.dataTime between :start and :timeEnd order by power_distribution_hour.dataTime ASC ", nativeQuery = true)
    List<Object[]> findAllByDeviceAndDataTimeBetweenAsc(@Param("deviceId") Integer deviceId, @Param("start")Integer start, @Param("timeEnd") Integer timeEnd);

    PowerDistributionHour findByDeviceIdAndDataTime(Integer deviceId, Integer dataTime);
}
