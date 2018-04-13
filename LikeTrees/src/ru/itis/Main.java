package ru.itis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
        Tree tree = new Tree();
        tree.setValues("test1.txt");
        tree.upgrade();
            System.out.println(tree.getM());
        } catch (Exception e) {
        }


    }
}
