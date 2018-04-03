package ru.itis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        FileInputStream input = new FileInputStream("input.txt");
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

        int count =0;
        String line;
        int k = 0;
        double month[] = new double[12];
            Scanner scanner = new Scanner(input);

            while (k < 366) {
                double tempr = 0;
                line = scanner.nextLine();
                char charLine[] = line.toCharArray();
                int index3 = (charLine[3]) - '0';
                int index4 = (charLine[4]) - '0';
                String temp = "";

                for(int i = 0; i < 12; i++) {
                    if(index3 == 0) {
                        if(index4  == i+1) {
                            for(int j = 6; j < charLine.length; j++) {
                                temp += charLine[j];
                            }
                            tempr = Double.parseDouble(temp);
                            month[i] += tempr;
                        }
                    } else {
                        if(index3*10 + index4 == i+1) {
                            for(int f = 6; f < charLine.length; f++) {
                                temp += charLine[f];
                            }
                            tempr = Double.parseDouble(temp);
                            month[i] += tempr;
                        }
                    }
                }


                k++;
            }



        double midle = 0;
        for(int i = 0; i < 12; i++) {
            midle += month[i];
        }
        midle /= 366.0;


        for(int i = 0; i < 12; i++) {
            if(i < 7) {
                if(i % 2 == 0){
                    month[i] /= 31.0;
                }
                if(i == 1) {
                    month[i] /= 29.0;
                } else {
                    month[i] /= 30.0;
                }
            } else {
                if(i % 2 == 1){
                    month[i] /= 31.0;
                } else {
                    month[i] /= 30.0;
                }
            }
            System.out.println(month[i]);
        }

        double min = 0;
        int monthNumber = 0;
        for(int i = 0; i < 12; i++) {
            if((Math.abs(midle - month[i]) < min || (min == 0))) {
                min = Math.abs(midle - month[i]);
                monthNumber = i+1;
            }
        }
        System.out.println(monthNumber);
    }
}
