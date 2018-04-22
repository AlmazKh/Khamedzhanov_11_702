package ru.itis;

import java.util.ArrayList;

public class SearchCars {
    private int ages[][] = new int[10][2];
    private int count = 0;

    public void search(User [] users) {
        for(int i = 0; i < users.length; i++) {
            if(Integer.parseInt(users[i].getAge()) != ages[count][0]) {
                ages[count][0] = Integer.parseInt(users[i].getAge());
                count++;
            }
        }
        count--;
        while(count> 0) {
            for(int i = 0; i < users.length; i++) {
                if(Integer.parseInt(users[i].getAge()) == ages[count][0]) {
                    ages[count][1] += users[i].countOfCars;
                    count--;
                }
            }
        }

        for(int i = 0; i < ages.length; i++) {
            System.out.println(ages[i][0] + " " + ages[i][1]);
        }
    }
}
