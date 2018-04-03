package ru.itis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Owner {
    private String ID;
    private String name;
    private String age;
    private String livingPlace;
    private int countOfOrders;

    public Owner(String ID, String name, String age, String livingPlace, int countOfOrders) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.livingPlace = livingPlace;
        this.countOfOrders = countOfOrders;
    }

    public int getCountOfOrders() {
        return countOfOrders;
    }

    public void setCountOfOrders(int countOfOrders) {
        this.countOfOrders ++;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLivingPlace() {
        return livingPlace;
    }

    public void setLivingPlace(String livingPlace) {
        this.livingPlace = livingPlace;
    }
}
