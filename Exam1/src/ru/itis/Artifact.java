package ru.itis;

public class Artifact implements Attack, Heal{
    private int power;
    //private int cost;

    public Artifact(int power) {
        this.power = power;
    }

    @Override
    public String attack() {
        return "Attaack!";
    }

    @Override
    public String heal() {
        return "Heal!";
    }

    public int getPower() {
        return power;
    }
}
