package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        n = n - 1;
        if (n/100000 + n/1000%10 +n%100/10 == n/10000%10 + n%1000/100 + n%10) {
            System.out.println("Almost happy");
        } else {
            n = n + 2;
            if (n/100000 + n/1000%10 +n%100/10 == n/10000%10 + n%1000/100 + n%10) {
                System.out.println("Almost happy");
            } else {
                System.out.println("NO");
            }
        }
    }
}
