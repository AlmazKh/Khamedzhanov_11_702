package ru.itis;

public class ActionAdapter extends Artifact {
    private Person hero;

    public ActionAdapter(int power,  Person hero) {
        super(power);
        this.hero = hero;
    }

    String action (String action) {
        Artifact art = new Artifact(getPower());
        if(action.equals("Attack")) {
            return attack();
        }
        if(action.equals("Heal")) {
            return heal();
        }

        return "U can`t do this";
    }


}
