package ru.itis;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String ID = "";
        String name = "";
        String age = "";
        String carID = "";
        String model = "";
        String ownerID = "";
        int countOfUsers = 0;
        int countOfCars = 0;

        int []ages = new int[100];
        //Car []cars = new Car[10];
        try {
            FileInputStream readOwners = new FileInputStream("users.txt");
            Scanner scanner = new Scanner(readOwners);
            FileInputStream readCars = new FileInputStream("cars.txt");
            Scanner scan = new Scanner(readCars);
            ID = scanner.next();
            name = scanner.next();
            age = scanner.next();
            carID = scan.next();
            model = scan.next();
            ownerID = scan.next();
            while (scan.hasNext()) {
                while (Integer.parseInt(ID) < Integer.parseInt(ownerID)) {
                    ID = scanner.next();
                    name = scanner.next();
                    age = scanner.next();
                }
                if(ID.equals(ownerID)) {
                   ages[Integer.parseInt(age)]++;
                }
                carID = scan.next();
                model = scan.next();
                ownerID = scan.next();

            }
            scanner.close();
            scan.close();

            /*while (scan.hasNext()) {
                carID = scan.next();
                model = scan.next();
                ownerID = scan.next();
                //Car car = new Car(carID, model, ownerID);
                *//*cars[countOfCars] = car;
                countOfCars++;*//*
                    for (int j = 0; j < users.length; j++) {
                        if(ownerID.equals(users[j].getID())) {
                            users[j].countOfCars++;
                        }
                    }

            }
            scanner.close();*/
        } catch (Exception e) {

        }

       /* SearchCars searchCars = new SearchCars();
        searchCars.search(users);*/
       for(int i = 0; i < ages.length; i++) {
           if(ages[i] != 0) {
               System.out.println(i + " " + ages[i]);
           }
       }
    }
}
