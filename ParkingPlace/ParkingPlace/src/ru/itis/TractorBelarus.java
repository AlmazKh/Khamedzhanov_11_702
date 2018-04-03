package ru.itis;

public class TractorBelarus extends Car {
    private int potatoes;
    public TractorBelarus(String model, int number, int potatoes) {
        super(model, number);
        this.potatoes = potatoes;
    }

    public void goToParking() {
        parkingPlace.enterCar(this);
        System.out.println("Potatoes = " + potatoes);
    }
}
