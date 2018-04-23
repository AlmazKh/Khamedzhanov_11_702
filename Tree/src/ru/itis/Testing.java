package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class Testing {
    private int[] array;
    private TreeBstImpl<Integer> tree;

    @Before
    public void setUp(){
        array = new int[]{5, 4, 8, 2, 9, 6, 10, 1, 3, 6, 7, 4};
        tree = new TreeBstImpl<>();

        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
    }

    @Test
    public void insertTest(){
        int[] array = new int[]{5, 4, 8, 2, 9, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();

        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        tree.insert(6);
        Assert.assertTrue(this.tree.equals(tree));
    }

    @Test
    public void containsTest(){
        Assert.assertTrue(tree.contains(1));
    }

    @Test
    public void equalsTest(){
        int array[] = {5, 4, 8, 2, 9, 6, 10, 1, 3, 6, 7, 4};
        TreeBstImpl<Integer> tree = new TreeBstImpl<>();

        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        Assert.assertTrue(tree.equals(this.tree));
    }

    @Test
    public void isBstTest(){
        Assert.assertTrue(this.tree.isBst());
    }

    @Test
    public void removeTest(){
        int[] array = new int[]{4, 8, 2, 5, 6, 10, 1, 3, 6, 7, 4, 5};
        /*TreeBstImpl<Integer> tree = new TreeBstImpl<>();
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }

        this.tree.remove(1);
        this.tree.print();
        //System.out.println();
        tree.remove(1);
        //tree.print();

        Assert.assertFalse(tree.equals(this.tree));*/
        tree.remove(1);
        Assert.assertFalse(tree.contains(1));
    }

    @Test
    public void removeTest2(){
        tree.remove(4);
        tree.remove(4);
        Assert.assertFalse(tree.contains(4));
    }

    @Test
    public void removeTest3(){
        tree.remove(4);
        Assert.assertTrue(tree.contains(4));
    }

    @Test
    public void removeTest4(){
        tree.remove(5);
        Assert.assertFalse(tree.contains(5));
    }

}
