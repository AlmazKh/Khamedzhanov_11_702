package ru.itis;

public class Car {
    private String ID;
    private String model;
    private String ownerID;

    public Car(String ID, String model, String ownerID) {
        this.ID = ID;
        this.model = model;
        this.ownerID = ownerID;
    }

    public String getID() {
        return ID;
    }

    public String getModel() {
        return model;
    }

    public String getOwnerID() {
        return ownerID;
    }
}
