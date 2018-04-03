package ru.itis;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;


public class FileAssistant {

    String path;
    XSSFWorkbook myExcelBook;
    FileInputStream inputStream;
    File file;
    int exLine;

    FileAssistant() throws IOException {
        path =  new File("").getAbsolutePath();
        file = new File(path + "\\files\\table.xlsx");
        inputStream = new FileInputStream(file);
        myExcelBook =  new XSSFWorkbook(inputStream);
        XSSFSheet sheet = myExcelBook.getSheetAt(0);

        XSSFCell cell = sheet.createRow(0).createCell(0);
        cell.setCellValue("nanoTime");
        cell = sheet.getRow(0).createCell(1);
        cell.setCellValue("кол-во итераций");
        cell = sheet.getRow(0).createCell(2);
        cell.setCellValue("кол-во чисел");
        exLine = 1;
    }

    public int[][] getArraysFromFile(String name) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        File file = new File(path + "\\files\\" + name);
        try(FileReader reader = new FileReader(file))
        {
            int c = 0;
            int i = 0;
            while(c != -1){
                arrayLists.add(new ArrayList<>());
                ArrayList array = arrayLists.get(i);
                int j = 0;
                while ((c=reader.read())!=10 || c != -1) {
                    if (c != ' ') {
                        j *= 10;
                        j += (c - '0');
                    } else {
                        array.add(j);
                        j = 0;
                    }
                    if (c == 10) break;
                    if (c == -1) break;
                }
                if (c == -1) break;
                i++;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        int[][] ints = new int[arrayLists.size()][];
        for (int i = 0; i < arrayLists.size(); i++) {
            ints[i] = new int[arrayLists.get(i).size()];
            for (int j = 0; j < arrayLists.get(i).size(); j++){
                ints[i][j] = arrayLists.get(i).get(j);
            }
        }
        return ints;
    }

    public void writeExelLine(long nanoTime, int itr, int amount) {

        XSSFSheet sheet = myExcelBook.getSheetAt(0);

        XSSFCell cell = sheet.createRow(exLine).createCell(0);
        cell.setCellValue(nanoTime);
        cell = sheet.getRow(exLine).createCell(1);
        cell.setCellValue(itr);
        cell = sheet.getRow(exLine).createCell(2);
        cell.setCellValue(amount);
        exLine++;
        /*ExelLine exelLine = new ExelLine(amount, itr, nanoTime);
        exelLines.add(exelLine);*/
    }

    public void closeExelFile() throws IOException {
        inputStream.close();
        FileOutputStream out = new FileOutputStream(file);
        myExcelBook.write(out);
        out.close();
    }

}