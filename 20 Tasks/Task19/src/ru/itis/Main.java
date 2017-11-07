package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    int a[] = new int[10];
	    int b[] = new int[10];
	    int count = 0;
	    int x = scanner.nextInt();
	    int y = scanner.nextInt();
        int i = 1;
        int N = 5;//кол-во цифр в числе +1

        while(x > 0) {
            a[x%10] = N - i;
            b[y%10] = N - i;
            x = x/10;
            y = y/10;
            i++;
        }
	    //в цикле заполнить массивы (записываем индексы)
        for(int j =0; j < 10; j++) {
            if (a[j] != b[j] && a[j] != 0 && b[j] != 0) {
                count++;//кол-во коров
            }
        }
        System.out.println(count);
    }
}
