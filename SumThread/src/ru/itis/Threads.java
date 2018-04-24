package ru.itis;

public class Threads extends Thread{
    private int start;
    private int end;
    private int[] array;
    private int sum = 0;

    public Threads(int start, int end, int[] arr) {
        super();
        this.start = start;
        this.end = end;
        this.array = arr;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            System.out.println(Thread.currentThread().getName());
            sum += array[i];
        }
    }

    public int getSum() {
        return sum;
    }
}
