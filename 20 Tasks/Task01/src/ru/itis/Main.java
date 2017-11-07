package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	     int a[][] = new int[8][8];
         int k = 0;
         //заполнение доски
	     for(int i = 0; i < 8; i++) {
	         k++;
	         for(int j = 0; j < 8; j++) {
	             if(k%2==1) {
                     a[i][j]++;
                 }
	             k++;
             }
        }
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if(a[x-1][y-1]==1) {
            System.out.println("Black");
        } else {
            System.out.println("White");
        }
    }
}
