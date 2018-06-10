package ru.itis;

public class ActionAdapter extends Artifact {

    public ActionAdapter(int power) {
        super(power);
    }

    String action (String action) {
        if(action.equals("Attack")) {
            return attack();
        }
        if(action.equals("Heal")) {
            return heal();
        }

        return "U can`t do this";
    }


}
