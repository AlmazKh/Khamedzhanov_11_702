package ru.itis;

public class Main {

    public static int find(int numbers[], int lower, int higher, int number) {
        int mid = lower + (higher - lower)/2;
        if(numbers[mid] > number){
            print(numbers, lower, mid);
            return find(numbers, lower, mid, number);
        }
        if(numbers[mid] < number) {
            print(numbers, mid, higher);
            return find(numbers, mid, higher, number);
        }
        if(numbers[mid] == number) {
            return mid;
        }
        return -1;
    }

    public static void print(int numbers[], int lower, int higher) {
        //TODO: красивый вывод
    }

    public static void main(String[] args) {
	    int numbers[] = {2, 4, 8, 11, 11, 13, 16, 19, 20};
	    int number = 19;
	    int lower = 0;
	    int higher = numbers.length;
	    int index = find(numbers, lower, higher, number);
        System.out.println(index);

    }
}
