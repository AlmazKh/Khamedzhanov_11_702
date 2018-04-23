package ru.itis;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int ID;
        String name = "";
        int age;
        String carID = "";
        String model = "";
        int ownerID;

        int []ages = new int[100];
        //Car []cars = new Car[10];
        try {
            FileInputStream readOwners = new FileInputStream("users.txt");
            Scanner scanner = new Scanner(readOwners);
            FileInputStream readCars = new FileInputStream("cars.txt");
            Scanner scan = new Scanner(readCars);
            ID = scanner.nextInt();
            name = scanner.next();
            age = scanner.nextInt();
            carID = scan.next();
            model = scan.next();
            ownerID = scan.nextInt();
            while (scan.hasNext()) {
                while (ID < ownerID) {
                    ID = scanner.nextInt();
                    name = scanner.next();
                    age = scanner.nextInt();
                }
                if(ID == ownerID) {
                   ages[age]++;
                }
                carID = scan.next();
                model = scan.next();
                ownerID = scan.nextInt();

            }
            ID = scanner.nextInt();
            name = scanner.next();
            age = scanner.nextInt();
            ages[age]++;
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
