package ru.itis;

import java.io.FileInputStream;
import java.util.Scanner;

public class Tree {
    private int n;
    private int k;
    private int [] arr;
    private int M = 0;

   public void setValues() throws Exception {
       FileInputStream input = new FileInputStream("input.txt");
       Scanner scanner = new Scanner(input);

       n = Integer.parseInt(scanner.next());
       k = Integer.parseInt(scanner.next());
       arr = new int[n];
       int i = 0;
       while (scanner.hasNext()) {
           arr[i] = Integer.parseInt(scanner.next());
           i++;
       }
      /* for(int j = 0; j < arr.length; j++) {
           System.out.println(arr[j] + " ");
       }*/
   }
   public void upgrade () {
       int ways[] = new int[n];
       for(int i = 0; i < ways.length; i++) {
           ways[i] = upgrade(i);
       }
       for(int i = 0; i < ways.length; i++) {
           if(ways[i]/k == 1) {
               ways[i] = 0;
           }
           M += ways[i]/k;
           ways[i] -= (ways[i]/k)*(k - 1);
       }
   }

   public int upgrade( int i) {
       int count = 0;
       for (int j = 1; j < arr.length; j++) {
           if(arr[j] == i) {
               count++;
           }
       }
       return count;
   }

    public int getM() {
        return M;
    }
}
