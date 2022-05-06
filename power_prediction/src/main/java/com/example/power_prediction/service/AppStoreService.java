package com.example.power_prediction.service;

import com.example.power_prediction.entity.AppStore;

import java.util.List;

public interface AppStoreService {
    List<AppStore> findAll();

    int updateAppStore(AppStore appStore);

    List<AppStore> findAllByState(String state);
}
