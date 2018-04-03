package ru.itis;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class MainScanner {
    public static void main(String[] args) throws Exception {
        FileInputStream input = new FileInputStream("input.txt");
        Scanner scanner = new Scanner(input);
        String s = "";
        while (scanner.hasNext()) {
            s += scanner.nextLine();
        }
    }
}
