package ru.itis;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;

public class MatrixImpl implements Matrix {
    private int count;
    private int checkCount;
    ArrayList <Number> numbers = new ArrayList<Number>();
    @Override
    public void set(int i, int j, int value) {
        for(int k = 0; k < numbers.size(); k++) {
            if(numbers.get(k).getI() == i && numbers.get(k).getJ() == j) {
                return;
            }
        }
        numbers.add(new Number(i, j, value));
        count++;
    }

    @Override
    public int get(int i, int j) {
        for(int k = 0; k < numbers.size(); k++) {
            if(numbers.get(k).getI() == i && numbers.get(k).getJ() == j) {
                System.out.println(numbers.get(k).getValue());
            } /*else {
                System.out.println(0);
            }*/
        }
        return 0;
    }

    public void generateNumbers(int n) {
        try {
            FileWriter file = new FileWriter("Numbers.txt");

            int i = 0;
            int j = 0;
            int number = 0;
            int count = 0;
            for(int k = 0; k < n; k++) {
                random(i, j , number);
                file.write(numbers.get(k).getI() + " " + numbers.get(k).getJ() + " " + numbers.get(k).getValue());
                file.write("\r\n");
            }
            file.close();
        } catch (Exception e) {

        }

    }
    public void random(int i, int j, int number) {
        Random random = new Random();

        i = random.nextInt(21) - 10;
        j = random.nextInt(21) - 10;
        number = random.nextInt(10) + 1;
        set(i, j, number);
        if (count == checkCount) {
            random(i, j , number);
        }
        checkCount++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(int checkCount) {
        this.checkCount = checkCount;
    }
}
