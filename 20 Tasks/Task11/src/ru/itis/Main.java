package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = scanner.nextInt();
        double y1 = scanner.nextInt();
        double x2 = scanner.nextInt();
        double y2 = scanner.nextInt();
        double x3 = scanner.nextInt();
        double y3 = scanner.nextInt();
        double a, b, c, p, S;

            a = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
            b = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
            c = Math.sqrt((x3-x1)*(x3-x1) + (y3-y1)*(y3-y1));
            p = (a + b + c)/2;
            S = Math.sqrt(p*(p - a)*(p - b)*(p - c));

        System.out.println(S);
    }
}
