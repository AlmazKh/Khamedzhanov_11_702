package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = n/100000 + n/1000%10 +n%100/10;
        int f = n/10000%10 + n%1000/100 + n%10;
        if(s == f) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
