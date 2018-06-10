package ru.itis;

import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)  {
        Checking checking = new Checking();
    try {
        System.out.println(checking.check("input.txt"));
    } catch (Exception e) {
        e.printStackTrace();
    }


    }



    }

