package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Testing {
    private MyComparator myComparator;
    private List<Integer> list;

    @Before
    public void setUp() {
        myComparator = new MyComparator();
        list = new ArrayList<>();
    }

    @Test
    public void test1() {
       list.add(123);
       list.add(102);
       list.sort(myComparator);

    }

    @Test
    public void test2() {

    }

}
