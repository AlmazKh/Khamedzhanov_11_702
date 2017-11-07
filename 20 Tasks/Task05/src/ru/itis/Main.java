package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if (x - y == x2 - y2) {
            System.out.println("SAME");
        } else {
            if (Math.abs(x - y - x2 + y2) == 1) {
                System.out.println("NEIGHBOUR");
            } else {
                System.out.println("Error");
            }
        }
    }
}
