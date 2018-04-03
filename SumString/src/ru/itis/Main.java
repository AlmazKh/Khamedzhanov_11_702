package ru.itis;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number1 = scanner.nextLine();
        String number2 = scanner.nextLine();

      /*  char numb1[] = number1.toCharArray();
        char numb2[] = number2.toCharArray();*/

        StringBuilder str1 = new StringBuilder(number1);
        StringBuilder str2 = new StringBuilder(number2);
        StringBuilder answer = new StringBuilder("");

        str1.reverse();
        str2.reverse();

        while (str1.length() != str2.length()) {
            if(str1.length() < str2.length()) {
                str1.append(0);
            } else {
                str2.append(0);
            }
        }

        str1.reverse();
        str2.reverse();
        boolean inBrain = false;
        for(int i = str1.length() - 1; i > -1; i--) {
            int sum = str1.charAt(i) - '0' + str2.charAt(i) - '0';
            if(sum > 9) {
                if( inBrain) {
                    sum++;
                    answer.append((sum) % 10);
                } else {
                    answer.append((sum) % 10);
                }
                inBrain = true;
            } else {
                if( inBrain) {
                    sum++;
                    if(sum == 10) {
                        answer.append(0);
                        continue;
                    } else {
                        answer.append(sum);
                    }
                } else {
                    answer.append(sum);
                }
                inBrain = false;
            }
        }
        if(inBrain) {
            answer.append(1);
        }
        System.out.println(answer.reverse());
    }
}
