package com.example.power_prediction.service.Impl;

import com.example.power_prediction.entity.AppStore;
import com.example.power_prediction.repository.AppStoreRepository;
import com.example.power_prediction.service.AppStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplAppStoreService implements AppStoreService {

    @Autowired
    AppStoreRepository appStoreRepository;

    @Override
    public List<AppStore> findAll() {
        return appStoreRepository.findAll();
    }

    @Override
    public int updateAppStore(AppStore appStore) {
        if(appStoreRepository.findById(appStore.getId()) != null) {
            appStoreRepository.save(appStore);
            return 1;
        }
        return 0;
    }

    @Override
    public List<AppStore> findAllByState(String state) {
        return appStoreRepository.findAllByState(state);
    }


}
