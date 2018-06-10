package ru.itis;

public class Person {
    private int power;
    private int hp;
    private Artifact art;

    public Person(int power, int hp, Artifact art) {
        this.power = power;
        this.hp = hp;
        this.art = art;
    }

    void useArtifact (String action) {
        System.out.println(action);
    }
}
