package ru.itis;

public class Order {
    private String ID;
    private String ownerID;
    private String nameOfOrder;
    private String massa;

    public Order(String ID, String ownerID, String nameOfOrder, String massa) {
        this.ID = ID;
        this.ownerID = ownerID;
        this.nameOfOrder = nameOfOrder;
        this.massa = massa;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getNameOfOrder() {
        return nameOfOrder;
    }

    public void setNameOfOrder(String nameOfOrder) {
        this.nameOfOrder = nameOfOrder;
    }

    public String getMassa() {
        return massa;
    }

    public void setMassa(String massa) {
        this.massa = massa;
    }
}
