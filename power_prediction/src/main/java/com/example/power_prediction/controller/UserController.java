package com.example.power_prediction.controller;


import com.example.power_prediction.entity.User;
import com.example.power_prediction.service.UserService;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Map<String, Object> userLogin(@RequestBody User user) {
        return userService.login(user);
    }


}
