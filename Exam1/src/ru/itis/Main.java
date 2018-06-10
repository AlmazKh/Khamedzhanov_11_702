package ru.itis;

public class Main {

    public static void main(String[] args) {
        Person hero = new Person(10, 1000);
        ActionAdapter act = new ActionAdapter(100, hero);
        hero.useArtifact(act.action("Attack"));
    }
}
