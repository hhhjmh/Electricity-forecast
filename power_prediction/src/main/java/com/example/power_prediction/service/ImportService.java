package com.example.power_prediction.service;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.util.List;

public interface ImportService {
    Workbook getWorkbook(InputStream inStr, String fileName) throws Exception;
    List getBankListByExcel(InputStream in, String fileName) throws Exception;
}
