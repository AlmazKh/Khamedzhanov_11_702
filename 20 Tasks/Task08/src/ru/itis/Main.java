package ru.itis;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r1 = scanner.nextInt();
        double x1 = scanner.nextInt();
        double y1 = scanner.nextInt();
        double r2 = scanner.nextInt();
        double x2 = scanner.nextInt();
        double y2 = scanner.nextInt();
        double distance = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));

        if(distance > r1+r2) {
            System.out.println("NO");
        }
        if(distance + r1 < r2 || distance + r2 < r1) {
            System.out.println("NO");
        }
        if(distance <= r1+r2) {
            System.out.println("YES");
        }
        if(distance + r1 == r2 || distance + r2 == r1) {
            System.out.println("YES");
        }
    }
}
