package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if(y == 2) {
            if(y2 == 3 || y2 == 4) {
                if(x == x2) {
                    System.out.println("Ход возможен");
                } else {
                    System.out.println("Неверный ход");
                }
            } else {
                System.out.println("Неверный ход");
            }
        }
        if(y != 2) {
            if(y2 == y-1 || y2 == y+1) {
                if(x == x2) {
                    System.out.println("Ход возможен");
                } else {
                    System.out.println("Неверный ход");
                }
            } else {
                System.out.println("Неверный ход");
            }
        }
    }
}
