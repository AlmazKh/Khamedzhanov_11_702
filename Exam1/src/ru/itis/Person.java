package ru.itis;

public class Person {
    private int power;
    private int hp;

    public Person(int power, int hp) {
        this.power = power;
        this.hp = hp;
    }

    void useArtifact (String action) {
        System.out.println(action);
    }
}
