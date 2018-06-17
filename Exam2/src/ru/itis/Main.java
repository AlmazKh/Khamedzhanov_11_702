package ru.itis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(123, 102, 103);
        list.sort(new MyComparator());
        System.out.println(list);
    }
}
