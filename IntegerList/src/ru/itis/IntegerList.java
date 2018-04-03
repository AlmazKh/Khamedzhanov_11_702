package ru.itis;

public class IntegerList {
    private  static final int MAX_NUMBERS_COUNT = 10;
    private int numbers[];
    private int count;
    private int countTest;

    public IntegerList() {
        this.numbers = new int[MAX_NUMBERS_COUNT];
        this.count = 0;
        this.countTest = 0;
    }

    public void add(int number) {
        this.numbers[count++] = number;
    }
    public void addTest(int number) {
        this.numbers[countTest++] = number;
    }

    public IntegerList map(Function function) {
        IntegerList build = new IntegerList();
        for(int i = 0; i < count; i++) {
            build.add(function.rebuild(numbers[i]));
        }
        return build;
    }
    public IntegerList filter(Predicate predicate) {
        IntegerList buildTest = new IntegerList();
        for(int i = 0; i < count; i++) {
            if(predicate.test(numbers[i])){
                buildTest.addTest(numbers[i]);
            }
        }
        return buildTest;
    }
   public void print() {
        for(int i = 0; i < countTest; i++) {
            System.out.println(numbers[i]);
        }
   }
}
