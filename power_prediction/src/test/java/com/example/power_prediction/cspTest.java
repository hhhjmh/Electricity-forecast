package com.example.power_prediction;


import com.example.power_prediction.entity.PowerBillByDay;
import com.example.power_prediction.repository.DeviceRepository;
import com.example.power_prediction.repository.PowerBillByDayRepository;
import com.example.power_prediction.service.PowerPriceTimeService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CspTest {
    @Autowired
    PowerBillByDayRepository powerBillByDayRepository;
    @Autowired
    DeviceRepository deviceRepository;
    @Test
    void showPowerBillByDay(){
        //powerBillByDayRepository.save(powerBillByDay);

//      PowerBillByDay powerBillByDay=new PowerBillByDay();
//        powerBillByDay.setDateTime(4565452L);
//        powerBillByDay.setF_power("56");
//        powerBillByDay.setG_power("sdf");
//        powerBillByDay.setJ_power("dfd");
//        powerBillByDay.setP_power("asdf");
//        powerBillByDay.setF_power_price("56");
//        powerBillByDay.setG_power_price("sdf");
//        powerBillByDay.setJ_power_price("dfd");
//        powerBillByDay.setP_power_price("asdf");
//        powerBillByDay.setDevice(deviceRepository.findById(2).get());
//        powerBillByDayRepository.save(powerBillByDay);

        deviceRepository.delete(deviceRepository.findById(2).get());
        //System.out.println(deviceRepository.findAll());
        //System.out.println(powerBillByDayRepository.findAll());
    }

}
