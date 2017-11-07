package ru.itis;

import java.time.LocalTime;

public class ParkingPlace {
    private final int PARKING_SIZE = 10;
    private Car cars[];
    private int count;

    private LocalTime beginTime;// = LocalTime.parse("09:00:00");;
    private LocalTime finishTime;// = LocalTime.parse("00:00:00");;

    public ParkingPlace(LocalTime beginTime, LocalTime finishTime) {
        this.cars = new Car[PARKING_SIZE];
        this.beginTime = beginTime;
        this.finishTime = finishTime;
        count = 0;
    }

    public void enterCar( Car car) {
        LocalTime currentTime = LocalTime.now();
        if(currentTime.isAfter(beginTime) && currentTime.isBefore(finishTime)) {
            if(count < PARKING_SIZE) {
                cars[count] = car;
                count++;
            } else {
                System.out.println("All places are occupied");
            }
        } else {
            System.out.println("Parking  isn`t working");
            System.exit(0);
        }
    }

    public void outCar( Car car) {
        LocalTime currentTime = LocalTime.now();
        if(currentTime.isAfter(beginTime) && currentTime.isBefore(finishTime)) {
            for(int i = 0; i < cars.length; i++) {
                if(car.equals(cars[i])) {
                    cars[i] = null;
                    count--;
                }
            }
        } else {
            System.out.println("Parking  isn`t working");
        }
    }


}
