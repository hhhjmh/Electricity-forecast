package com.example.power_prediction;


import com.example.power_prediction.entity.PowerBillByDay;
import com.example.power_prediction.repository.DeviceRepository;
import com.example.power_prediction.repository.PowerBillByDayRepository;
import com.example.power_prediction.service.PowerPriceTimeService;
import com.example.power_prediction.util.TimeOperation;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.time.temporal.ChronoUnit;


@SpringBootTest
class CspTest {
    @Autowired
    PowerBillByDayRepository powerBillByDayRepository;
    @Autowired
    DeviceRepository deviceRepository;

    @Test
    void showPowerBillByDay() {
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

class JustJavaTest {
    @Test
    void Date() {
        LocalDate l1= LocalDate.of(2022, 1, 8);
        LocalDate l2= LocalDate.of(2022, 1, 8);
        LocalDate l3= LocalDate.of(2022, 1, 9);
        System.out.println(TimeOperation.isBetween(l2, l1, l3, ChronoUnit.DAYS));
    }

    @Test
    void Time(){
        LocalTime t1=LocalTime.of(23,0);
        LocalTime t2=LocalTime.of(23,30);
        LocalTime t3=LocalTime.of(0,0);
        System.out.println(t3.minus(1, ChronoUnit.SECONDS));
        System.out.println(ChronoUnit.SECONDS.between(t1, t3));
        System.out.println(TimeOperation.isBetween(t2,t1,t3,ChronoUnit.SECONDS));
    }

}
