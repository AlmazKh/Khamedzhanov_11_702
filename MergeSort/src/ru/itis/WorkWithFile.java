/*
package ru.itis;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class WorkWithFile {
    String path;
    HSSFWorkbook excelFile;
    FileInputStream inputStream;
    File file;
    int exLine;

    WorkWithFile() throws IOException {
        path =  new File("").getAbsolutePath();
        file = new File(path + "\\files\\table.xlsx");
        inputStream = new FileInputStream(file);
        excelFile =  new HSSFWorkbook(inputStream);
        HSSFSheet sheet = excelFile.getSheetAt(0);

        HSSFCell cell = sheet.createRow(0).createCell(0);
        cell.setCellValue("nanoTime");
        cell = sheet.getRow(0).createCell(1);
        cell.setCellValue("Количество итераций");
        cell = sheet.getRow(0).createCell(2);
        cell.setCellValue("Количество чисел");
        exLine = 1;
    }
}
*/
