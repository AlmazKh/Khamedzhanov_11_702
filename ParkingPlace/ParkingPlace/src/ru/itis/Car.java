package ru.itis;

public class Car {
    private int number;
    private String model;
    private ParkingPlace parkingPlace;

    public Car(String model, int number) {
        this.model = model;
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public int getNumber() {
        return  number;
    }

    public void setParkingPlace(ParkingPlace parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public void goToParking() {
        parkingPlace.enterCar(this);
    }

    public void outParking() {
        parkingPlace.outCar(this);
    }
}
