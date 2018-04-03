package ru.itis;


import java.io.FileInputStream;

public class Main {

    public static void main(String[] args) throws Exception {

        MyScanner scanner = new MyScanner("input.txt");
        String line = scanner.nextLine();
        System.out.println(line);
        scanner = new MyScanner("input.txt");
        int numb = scanner.nextInt();
        System.out.println(numb);

    }
}
