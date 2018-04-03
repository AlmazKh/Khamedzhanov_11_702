package ru.itis;

public class ExperimentalMain {
    public static void main(String[] args) {
    int a[] = new int[]{5, 4, 7, 5, 3};
    int t, j;
    for(int i = 0; i < a.length - 1; i++) {
        if(a[i] > a[i+1]) {
            t = a[i+1];
            a[i+1] = a[i];
            j = i;
            while(j > 0 && t < a[j-1]) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = t;
        }
    }

    }
}
