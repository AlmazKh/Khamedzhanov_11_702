package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int n = scanner.nextInt();

	    if(n%400 == 0 || (n%4 == 0 && n%100 != 0)) {
            System.out.println("13/09/" + n);
        } else {
            System.out.println("12/09/" + n);
        }
    }
}
