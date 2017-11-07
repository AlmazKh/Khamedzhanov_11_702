package ru.itis;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Auto car1 = new Auto("BMW",001 );
        SportCar sportCar1 = new SportCar("Lada", 002);
        Plane plane1 = new Plane("Air", 123);
        Tank tank1 = new Tank("T-34", 1945);

        TractorBelarus tractor1 = new TractorBelarus("Belarus", 228);
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Potato = " + n);

        ParkingPlace parkingPlace1 = new ParkingPlace(LocalTime.parse("00:00:00"), LocalTime.parse("02:00:00"));

        car1.setParkingPlace(parkingPlace1);
        car1.goToParking();
        tank1.setParkingPlace(parkingPlace1);
        tank1.goToParking();
        car1.outParking();

    }
}
