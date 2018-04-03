package ru.itis;

import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MatrixImpl matrix = new MatrixImpl();
        /*matrix.set(1, 5, 10);
        matrix.get(1, 1);
        matrix.set(1, 5, 15);*/
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        matrix.generateNumbers(n);
        matrix.get(8, 3);

    }
}
