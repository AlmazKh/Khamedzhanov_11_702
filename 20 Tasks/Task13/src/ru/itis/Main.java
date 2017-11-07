package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = n%1000;
        int f = n/1000;
        int m = s%10*100 + s%100/10*10 + s/100;
        if(f == m) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
