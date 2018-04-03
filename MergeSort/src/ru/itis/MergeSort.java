package ru.itis;

import java.util.Arrays;

public class MergeSort {
    private int countOfIterations = 0;

   public void sort (int numbers[]) {
       if(numbers.length < 2) {
           return;
       }

       int leftPart[] = Arrays.copyOfRange(numbers, 0, numbers.length / 2);
       int rightPart[] = Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length);
       sort(leftPart);
       sort(rightPart);
       merge(leftPart, rightPart, numbers);
   }

   public void merge (int leftPart[], int rightPart[], int numbers[]) {
        int left = 0;
        int right = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(left < leftPart.length && right < rightPart.length) {
                if(leftPart[left] > rightPart[right]) {
                    numbers[i] = rightPart[right];
                    right++;
                } else {
                    numbers[i] = leftPart[left];
                    left++;
                }
            } else {
                if(left < leftPart.length) {
                    numbers[i] = leftPart[left];
                    left++;
                } else {
                    numbers[i] = rightPart[right];
                    right++;
                }
            }
            countOfIterations++;
        }

   }

    public int getCountOfIterations() {
        return countOfIterations;
    }
}
