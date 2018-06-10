package ru.itis;

public class Main {

    public static void main(String[] args) {
        Artifact art = new Artifact(100);
        Person hero = new Person(10, 1000, art);
        ActionAdapter act = new ActionAdapter(100);
        hero.useArtifact(act.action("Attackkkkk"));
        hero.useArtifact(act.action("Attack"));
        hero.useArtifact(act.action("Heal"));
    }
}
