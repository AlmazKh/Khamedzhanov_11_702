package ru.itis;

import java.io.*;
import java.util.Random;

public class Generator {
    private int countOfElements;

    public int getCountOfElements() {
        return countOfElements;
    }

    public void setCountOfElements() {
        Random random = new Random();
        this.countOfElements = random.nextInt(10000) + 100;
    }

    public void write() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("mas.txt"));
            Random random = new Random();
            for(int i = 0; i < countOfElements; i++) {
                int num = random.nextInt(10000);
                writer.write(String.valueOf(num));
                writer.write('\n');
            }
            writer.close();
        } catch (Exception e) {

        }
    }

    public void reader(int [] array) {
        try {
            FileInputStream input = new FileInputStream("mas.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            for(int i = 0; i < countOfElements; i++) {
                String str = reader.readLine();
                int modifier = 1;
                for(int j = str.length() - 1; j >= 0; j--) {
                    array[i] = array[i] + (str.charAt(j) - '0') * modifier;
                    modifier *= 10;
                }
            }
        } catch (Exception e) {

        }
    }
}