package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.User;
import com.example.power_prediction.repository.UserRepository;
import com.example.power_prediction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ImplUserService implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Map<String, Object> login(User user) {

        Map<String, Object> map = new HashMap<>();
        User newUser = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if (newUser != null) {
            map.put("username", newUser.getUsername());
            map.put("root", newUser.getRoot());
            map.put("state", "Success");
            map.put("userDepartment,",newUser.getDepartment());
            System.out.println("Success");
        } else {
            map.put("state", "Fail");
            System.out.println("Fail");
        }
        return map;

    }
}
