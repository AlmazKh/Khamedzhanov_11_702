package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfNumbers = scanner.nextInt();
        int countOfThreads = scanner.nextInt();

	    int arr[] = new int[countOfNumbers];
	    int sumFor = 0;
	    int sumThreads = 0;

	    for(int i = 0; i < countOfNumbers; i++) {
	        arr[i] = (int)(Math.random() * 1000);
            System.out.println(arr[i]);
            sumFor += arr[i];
        }
        System.out.println(sumFor);

    }
}
