package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = n%1000;
        int f = n/1000;
        int m = s%10 + s%100/10 + s/100;
        int z = f%10 + f%100/10 + f/100;
        if(z == m) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
