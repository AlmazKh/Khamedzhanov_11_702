package ru.itis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Point {
    private int x;
    private int y;
    private int points[][];
    private int amountOfPoints;
    private int count;
    private  String line;

    public int getX() {
        return x;
    }

    public void setX(String x) {
        this.x = Integer.parseInt(x);
    }

    public int getY() {
        return y;
    }

    public void setY(String y) {
        this.y = Integer.parseInt(y);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int[][] getPoints() {
        return points;
    }

    public void setPoints() {
        this.points = new int[getAmountOfPoints()][2];
    }

    public void setPoints(int x, int y) {
        this.points[count][0] = x;
        this.points[count][1] = y;
        count ++;

    }

    public int[][] sortPoints() {
       /* Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });*/
       Quicksort(points, 0, points.length-1);


        return points;
    }
    public  void swap (int A[][], int x, int y) {
        int temp = A[x][0];
        A[x][0] = A[y][0];
        A[y][0] = temp;
    }

    public  int partition(int A[][], int f, int l) {
        int pivot = A[f][0];
        while (f < l) {
            while (A[f][0] < pivot) f++;
            while (A[l][0] > pivot) l--;
            swap (A, f, l);
        }
        return f;
    }

    public  void Quicksort(int A[][], int f, int l) {
        if (f >= l) return;
        int pivotIndex = partition(A, f, l);
        Quicksort(A, f, pivotIndex);
        Quicksort(A, pivotIndex+1, l);
    }

    public void print(int[][] points) {
        for(int i = 0; i < points.length; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }

    public int getAmountOfPoints() {
        return amountOfPoints;
    }

    public void setAmountOfPoints() throws Exception {
        FileInputStream input = new FileInputStream("input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

        while(bufferedReader.readLine() != null) {
            this.amountOfPoints ++;
            setPoints();
            //this.count++;
        }
    }

    public void readCoordinates() throws Exception {
        FileInputStream input = new FileInputStream("input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        //TODO: пределать считывание с файла
        while ((line = bufferedReader.readLine()) != null) {
            char[] charsLine = line.toCharArray();
            int i = 0;
            String x = "";
            String y = "";
            while(charsLine[i] != ' ') {
                x = x + charsLine[i];
                i++;
            }
            i++;
            while(i < charsLine.length) {
                y = y + charsLine[i];
                i++;
            }
            setX(x);
            setY(y);
            setPoints(getX(), getY());
        }
    }
}
