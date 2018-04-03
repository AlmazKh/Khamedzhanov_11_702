package ru.itis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Reader {

    private int x;
    private int y;
    private String line;
    private int amountOfPoints = 0;

    public void setAmountOfPoints(int amountOfPoints) {
        //подсчет кол-ва точек
        try {
            FileInputStream input = new FileInputStream("input.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            while (bufferedReader.readLine() != null) {
                this.amountOfPoints += amountOfPoints;
            }
        } catch (Exception e) {}

        /*Point point = new Point();
        point.setAmountOfPoints(amountOfPoints);
        point.setPoints(); //определяется величина массива

        return amountOfPoints;*/
    }

    public int getAmountOfPoints() {
        return amountOfPoints;
    }

    public void readCoordinates() throws Exception {
        FileInputStream input = new FileInputStream("input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        //TODO: пределать считывание с файла
        while ((line = bufferedReader.readLine()) != null) {
            char[] charsLine = line.toCharArray();
            x = charsLine[0] - '0'; //TODO: прописать цикл, чтобы работало для чисел, а не только для цифр
            y = charsLine[2] - '0';
            Point point = new Point();
            point.setPoints(x, y);
        }
    }



    public void setLine(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
