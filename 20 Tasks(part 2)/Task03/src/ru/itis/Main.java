package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int n = scanner.nextInt();
        int d = a2 - a1;
        double s = (2 * a1 + d * (n - 1))*n/2;
        System.out.println(s);
    }
}
