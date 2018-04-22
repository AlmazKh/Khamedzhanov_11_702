package ru.itis;

public class User {
    private String ID;
    private String name;
    private String age;
    public int countOfCars = 0;

    public User(String ID, String name, String age) {
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public int getCountOfCars() {
        return countOfCars;
    }
}
