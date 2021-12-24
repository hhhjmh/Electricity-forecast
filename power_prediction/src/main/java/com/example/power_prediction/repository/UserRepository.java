package com.example.power_prediction.repository;

import com.example.power_prediction.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserId(Integer userId);
    User findByUsername(String username);

}
