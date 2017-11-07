package ru.itis;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = 2.0;

        Car car = new Car("LADA", 121);
        car.go(n);

        double s = car.getS();
    }





}
