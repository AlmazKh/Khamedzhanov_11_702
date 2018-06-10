package ru.itis;

import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return reversed(o1) - reversed(o2);
    }

    private int reversed(int number) {
        int sum = 0;
        int multi = 0;
        while (number > 0){
            sum += number % 10;
            multi *= number % 10;
            number /= 10;
        }
        return Math.abs(sum - multi);
    }
}
