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

        User []users = new User[10];
        //Car []cars = new Car[10];
        try {
            FileInputStream readOwners = new FileInputStream("users.txt");
            Scanner scanner = new Scanner(readOwners);
            while (scanner.hasNext()) {
                ID = scanner.next();
                name = scanner.next();
                age = scanner.next();
                User user = new User(ID, name, age);
                users[countOfUsers] = user;
                countOfUsers++;
            }
            scanner.close();
            FileInputStream readCars = new FileInputStream("cars.txt");
            Scanner scan = new Scanner(readCars);
            while (scan.hasNext()) {
                carID = scan.next();
                model = scan.next();
                ownerID = scan.next();
                //Car car = new Car(carID, model, ownerID);
                /*cars[countOfCars] = car;
                countOfCars++;*/
                    for (int j = 0; j < users.length; j++) {
                        if(ownerID.equals(users[j].getID())) {
                            users[j].countOfCars++;
                        }
                    }

            }
            scanner.close();
        } catch (Exception e) {

        }

        SearchCars searchCars = new SearchCars();
        searchCars.search(users);
    }
}
