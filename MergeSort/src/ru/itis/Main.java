package ru.itis;

public class Main {

    public static void main(String[] args) {
	    int [] a = {2, 8, 9, 6 ,1};
	    MergeSort_2 sort = new MergeSort_2();
		//MergeSort sort = new MergeSort();
		Generator generator = new Generator();
		generator.setCountOfElements();
		int array [] = new int[generator.getCountOfElements()];
		generator.write();
		generator.reader(array);
		long time = System.nanoTime();
	    sort.sort(array);
	    time = System.nanoTime() - time;
	    for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println("Время работы: " + time);
		System.out.println("Количество итераций: " + sort.getCountOfIterations());
		System.out.println("Количество чисел: " + generator.getCountOfElements());




	}
}
