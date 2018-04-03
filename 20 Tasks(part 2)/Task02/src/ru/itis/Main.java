package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int k = scanner.nextInt();
        int d = a2 - a1;
        double s = a1 + d * (k - 1);
        System.out.println(s);
    }
}
