package ru.itis;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if(y2 == y+2  || y2 == y-2) {
            if(x2 == x+1 || x2 == x-1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } else {
            if(y2 == y+1 || y2 == y-1) {
                if (x2 == x + 2 || x2 == x - 2) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}
