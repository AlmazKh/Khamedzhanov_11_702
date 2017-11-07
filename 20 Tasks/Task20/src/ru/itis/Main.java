package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int part1n = n%1000;
        int part2n = n/1000;
        int part1m = m%1000;
        int part2m = m/1000;
        int part1, part2;

        part1 = (part1n%10 + part1m%10)%10 + (part1n%100/10 + part1m%100/10)%10 + (part1n/100 + part1m/100)%10;
        part2 = (part2n%10 + part2m%10)%10 + (part2n%100/10 + part2m%100/10)%10 + (part2n/100 + part2m/100)%10;

        if(part1 == part2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
