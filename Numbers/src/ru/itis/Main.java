package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        int k =0;
        int n2 = n;

        while (n2 > 0) {
            n2 /= 10;
            k++;
        }
        int i = k - 1;
        int a[] = new int[k];

        while (n > 0) {
            a[i] = n%10;
            n /= 10;
            i--;
        }

        //4267 == 17
        int f = 1;

        for(int j = 0; j < k - 1; j++) {
            for(int z = j + 1; z < k; z++) {
                if(a[j] < a[z]) {
                    int k2 = k - j;
                    while(k2 > 1) {
                        f *= k2 - 1;
                        k2--;
                    }
                    count += f;
                    f = 1;
                }
            }
        }
        System.out.println(count);
    }

   /* public static void factorial(int k, int f) {
        while(k > 1) {
            f *= k - 1;
            k--;
        }
    }*/
}
