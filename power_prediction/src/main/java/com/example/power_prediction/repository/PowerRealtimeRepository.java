package com.example.power_prediction.repository;

import com.example.power_prediction.entity.PowerRealtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerRealtimeRepository extends JpaRepository<PowerRealtime,Integer> {
}
