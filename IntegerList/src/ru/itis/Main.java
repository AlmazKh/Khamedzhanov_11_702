package ru.itis;

public class Main {

    public static void main(String[] args) {
	IntegerList list = new IntegerList();
	list.add(10);
	list.add(11);
	list.add(13);
	list.add(17);
	    Function rebuild = new Function() {

            @Override
            public int rebuild(int number) {
                int sum = 0;
                while(number > 0) {
                    sum += number % 10;
                    number /= 10;
                }
                return sum;
            }
	    };
	   IntegerList newListMap = list.map(rebuild);

	   Predicate test = new Predicate() {
           @Override
           public boolean test(int number) {
               if(number % 2 == 0) {
                   return true;
               } else {
                   return false;
               }
               }
           };
	   IntegerList newListTest = newListMap.filter(test);
	   newListTest.print();
       }
    }

