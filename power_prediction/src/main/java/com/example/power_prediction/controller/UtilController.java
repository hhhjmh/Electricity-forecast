package com.example.power_prediction.controller;

import com.example.power_prediction.entity.Device;
import com.example.power_prediction.entity.DeviceRelationship;
import com.example.power_prediction.service.ImportService;
import com.example.power_prediction.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.ZoneId;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/util")
public class UtilController {
    @Autowired
    UtilService utilService;
    @Autowired
    ImportService importService;

    @ResponseBody
    @RequestMapping("/insertPowerRealtime/{batchSize}")
    public Integer insertPowerRealtime(@PathVariable Integer batchSize) {
        return utilService.batchInsertingDataForPowerRealTime(1638288600, 1, 3000, 1500, 50, 1000, 500, 20, 3000, 500, 15, batchSize);
    }


    @ResponseBody
    @RequestMapping("/insertPowerDistribution/{batchSize}")
    public Integer insertPowerDistributionDay(@PathVariable Integer batchSize) {
        return utilService.batchInsertingDataForPowerDistributionDay(1, 1638547200, batchSize, 1500, 2500, 12000, 18000, 200);
    }

    @ResponseBody
    @RequestMapping("/insertPowerDistributionHour/{batchSize}")
    public Integer insertPowerDistributionHour(@PathVariable Integer batchSize) {
        return utilService.batchInsertingDataForPowerDistributionHour(1, 1638374400, batchSize, 20, 40);
    }

    @ResponseBody
    @RequestMapping("/insertPowerQualityRealtime/{dataTime}")
    public Integer insertPowerQualityRealtime(@PathVariable Integer dataTime) {
        return utilService.batchInsertingDataForPowerQualityRealtime(1, dataTime, (dataTime + 30 * 86400), 10, 8, 5, 4);
    }


    @ResponseBody
    @PostMapping("/deviceRelationshipTree")
    public List findDeviceRelationship(@RequestBody Device device) {
        Integer method = 0;
        return utilService.findAllDeviceRelationship(device.getId(), device.getUserDepartment(), method);
    }

    @ResponseBody
    @PostMapping("/deviceRelationshipTreeForAll")
    public List findAllDeviceRelationship(@RequestBody Device device) {
        Integer method = 1;
        return utilService.findAllDeviceRelationship(device.getId(), device.getUserDepartment(), method);
    }

    @ResponseBody
    @RequestMapping("/timeZone")
    public ZoneId timeZone() {
        return utilService.getZoneId();
    }

    @RequestMapping("/setTimeZone")
    public void setTimeZone(@RequestParam String timezone) {
        utilService.setZoneId(timezone);
    }



    @PostMapping(value = "/upload")
    @ResponseBody
    public String uploadExcel(@RequestParam("uploadFile") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return "文件不能为空";
        }
        InputStream inputStream = file.getInputStream();
        List<List<Object>> list = importService.getBankListByExcel(inputStream, file.getOriginalFilename());
        inputStream.close();
        for (int i = 0; i < list.size(); i++) {
            List<Object> lo = list.get(i);
            try {
//暂未确定上传内容
//                Integer a= Integer.valueOf(lo.get(1).toString());
//                System.out.println(a);
            } catch (Exception e) {
                System.out.print(e);
                return "格式错误";
            }
        }
        return "上传成功";
    }
}
