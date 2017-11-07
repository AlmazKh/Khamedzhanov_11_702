package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    double a = scanner.nextInt();
	    double b = scanner.nextInt();
	    double c = scanner.nextInt();
	    double D = b*b - 4*a*c;

	    if(D < 0) {
            System.out.println("NO solution");
        }
        if(D > 0) {
            double x1 = (-b + Math.sqrt(D))/2*a;
            double x2 = (-b - Math.sqrt(D))/2*a;
            System.out.println("Two solutions: " + x1 + " and " + x2);
        }
	    if(D == 0) {
	        double x = -b/2*a;
            System.out.println("One solutions: " + x);

        }


    }
}
