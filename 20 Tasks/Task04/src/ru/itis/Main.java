package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if (y2 > y && x2 > x || y2 < y && x2 < x) {
            if (y2 - y == x2 - x) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        if (y2 > y && x2 < x || y2 < y && x2 > x) {
            if(y2 - y == -1 *(x2 - x)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
