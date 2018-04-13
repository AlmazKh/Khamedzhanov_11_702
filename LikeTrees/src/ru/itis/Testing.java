package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Testing {
    private Tree tree;

    @Before
    public void setUp() {
        tree = new Tree();
    }

    @Test
    public void test1() {
        try {
            tree.setValues("test1.txt");
            tree.upgrade();
            System.out.println(tree.getM());
        } catch (Exception e) {
        }
        Assert.assertEquals(tree.getM(), 7);
    }

    @Test
    public void test2() {
        try {
            tree.setValues("test2.txt");
            tree.upgrade();
            System.out.println(tree.getM());
        } catch (Exception e) {
        }
        Assert.assertEquals(tree.getM(), 2);
    }

    @Test
    public void test3() {
        try {
            tree.setValues("test3.txt");
            tree.upgrade();
            System.out.println(tree.getM());
        } catch (Exception e) {
        }
        Assert.assertEquals(tree.getM(), 2);
    }
}
