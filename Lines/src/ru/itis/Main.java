package ru.itis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {//throws Exception {
        Reader reader = new Reader();

        //reader.amountOfPoints(); //TODO: разобраться с размером массива!!!!

        try {
            reader.readCoordinates();
        } catch (Exception e) { }




    }
}
