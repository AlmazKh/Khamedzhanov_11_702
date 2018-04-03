package ru.itis;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number1 = scanner.nextLine();
        String number2 = scanner.nextLine();

        StringBuilder str1 = new StringBuilder(number1);
        StringBuilder str2 = new StringBuilder(number2);
        StringBuilder answer = new StringBuilder("");


        ArrayList<StringBuilder> list = new ArrayList<>();
        int inBrain = 0;
            for(int i = str1.length() - 1; i > -1; i--) {
                StringBuilder str = new StringBuilder("");
                for(int j = str2.length() - 1; j > -1; j--) {
                    int mult = (str1.charAt(i) - '0') * (str2.charAt(j) - '0') + inBrain;
                    str.append(mult % 10);
                    inBrain = mult / 10;
                }

                str.reverse();
                int k = i + 1;
                while(str1.length() - k != 0) {
                    str.append(0);
                    k++;
                }
                list.add(str);
             }

             for( int i = 0; i < list.size(); i++) {
                answer = sum(answer, list.get(i));
             }
        System.out.println(answer);
    }

    public static StringBuilder sum (StringBuilder str1, StringBuilder str2){

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

        StringBuilder answer = new StringBuilder("");
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
        answer.reverse();
        return answer;
    }
}
