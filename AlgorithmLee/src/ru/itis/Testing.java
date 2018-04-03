package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Testing {
    private Algorithm lee;
   /* private Point start;
    private Point end;*/

    @Before
    public void setUp(){
        lee = new Algorithm();
        /*start = new Point(1, 1);
        end = new Point(6, 5);*/
    }

    @Test
    public void test1() {
        int [][] labyrinth = {
                {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
                {-2,  0,  0,  0,  0,  0,  0,  0,  0, -2},
                {-2, -2,  0, -2, -2,  0, -2,  0, -2, -2},
                {-2, -2,  0, -2, -2,  0, -2,  0, -2, -2},
                {-2, -2,  0, -2, -2, -2, -2,  0, -2, -2},
                {-2, -2,  0,  0,  0, -2, -2,  0, -2, -2},
                {-2, -2,  0, -2,  0,  0,  0,  0, -2, -2},
                {-2,  0,  0, -2, -2, -2, -2, -2, -2, -2},
                {-2,  0,  0,  0, -2, -2, -2, -2, -2, -2},
                {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
        };
        Point start = new Point(1, 1);
        Point end = new Point(6, 5);
        lee.searchWay(labyrinth, start, end);
        Assert.assertEquals(lee.getPosition(), 9);
    }

    @Test
    public void test2() {
        int [][] labyrinth = {
                {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
                {-2,  0,  0,  0,  0,  0,  0,  0,  0, -2},
                {-2, -2,  0, -2, -2,  0, -2,  0, -2, -2},
                {-2, -2,  0, -2, -2,  0, -2,  0, -2, -2},
                {-2, -2,  0, -2, -2, -2, -2,  0, -2, -2},
                {-2, -2,  0,  0,  0, -2, -2,  0, -2, -2},
                {-2, -2,  0, -2,  0,  0,  0,  0, -2, -2},
                {-2,  0,  0, -2, -2, -2, -2, -2, -2, -2},
                {-2,  0,  0,  0, -2, -2, -2, -2, -2, -2},
                {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
        };
        Point start = new Point(3, 5);
        Point end = new Point(6, 5);
        lee.searchWay(labyrinth, start, end);
        Assert.assertEquals(lee.getPosition(), 11);
    }

    @Test (expected = WayNotFoundException.class)
    public void test3() {
        int [][] labyrinth = {
                {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
                {-2,  0,  0,  0,  0, -2,  0,  0,  0, -2},
                {-2, -2,  0, -2, -2,  0, -2,  0, -2, -2},
                {-2, -2,  0, -2, -2,  0, -2,  0, -2, -2},
                {-2, -2,  0, -2, -2, -2, -2,  0, -2, -2},
                {-2, -2,  0, -2,  0, -2, -2,  0, -2, -2},
                {-2, -2,  0, -2,  0,  0,  0,  0, -2, -2},
                {-2,  0,  0, -2, -2, -2, -2, -2, -2, -2},
                {-2,  0,  0,  0, -2, -2, -2, -2, -2, -2},
                {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
        };
        Point start = new Point(3, 5);
        Point end = new Point(6, 5);
        lee.searchWay(labyrinth, start, end);
    }

    @Test
    public void test4() {
        int [][] labyrinth = {
                {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
                {-2,  0,  0,  0,  0,  0,  0,  0,  0, -2},
                {-2, -2,  0, -2, -2,  0, -2,  0, -2, -2},
                {-2, -2,  0, -2, -2,  0, -2,  0, -2, -2},
                {-2, -2,  0, -2, -2, -2, -2,  0, -2, -2},
                {-2, -2,  0,  0,  0, -2, -2,  0, -2, -2},
                {-2, -2,  0, -2,  0,  0,  0,  0, -2, -2},
                {-2,  0,  0, -2, -2, -2, -2, -2, -2, -2},
                {-2,  0,  0,  0, -2, -2, -2, -2, -2, -2},
                {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
        };
        Point start = new Point(3, 5);
        Point end = new Point(3, 5);
        lee.searchWay(labyrinth, start, end);
        Assert.assertEquals(lee.getPosition(), 0);
    }

}
