package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        n = n - 1;
        int part1 = n / 1000;
        int part2 = n % 1000;
        if (part1 % 10 + part1 % 100 / 10 + part1 / 100 == part2 % 10 + part2 % 100 / 10 + part2 / 100) {
            System.out.println("Almost happy");
        } else {
            n = n + 2;
            part1 = n / 1000;
            part2 = n % 1000;
            if (part1 % 10 + part1 % 100 / 10 + part1 / 100 == part2 % 10 + part2 % 100 / 10 + part2 / 100) {
                System.out.println("Almost happy");
            } else {
                System.out.println("NO");
            }
        }
    }
}
