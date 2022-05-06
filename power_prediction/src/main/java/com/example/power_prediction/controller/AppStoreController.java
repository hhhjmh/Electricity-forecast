package com.example.power_prediction.controller;

import com.example.power_prediction.entity.AppStore;
import com.example.power_prediction.service.AppStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/appStore")
public class AppStoreController {

    @Autowired
    AppStoreService appStoreService;

    @PostMapping("/findAll")
    public List<AppStore> findAll() {
        return appStoreService.findAll();
    }

    @PostMapping("/update")
    public int update(@RequestBody AppStore appStore) {
        return appStoreService.updateAppStore(appStore);
    }

    @PostMapping("/findAllByState")
    public List<AppStore> findAllByState(@RequestBody AppStore appStore) {
        return appStoreService.findAllByState(appStore.getState());
    }
}
