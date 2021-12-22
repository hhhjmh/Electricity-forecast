package com.example.power_prediction.service;

import com.example.power_prediction.entity.User;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface UserService {
    Map<String, Object> login(User user);
}
