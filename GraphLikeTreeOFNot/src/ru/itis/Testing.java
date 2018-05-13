package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Testing {
    private Checking checking;

    @Before
    public void setUp() {
        checking = new Checking();
    }

    @Test
    public void test1() {
        try {
            Assert.assertTrue(checking.check("test1.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            Assert.assertFalse(checking.check("test2.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
