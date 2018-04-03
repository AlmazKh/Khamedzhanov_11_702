package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class TestingProcess {
    private Analyzer analyzer;
    @Before
    public void setUp() {
        analyzer = new Analyzer();
    }

    @Test (expected = SyntaxException.class)
    public void test1(){
        String result = "X1:=128; Z1:=X1+Y2;";
        analyzer.process(result);
    }

    @Test (expected = VariableNotFoundException.class)
    public void test2(){
        String result = "X1:=Z1*Y6;";
        analyzer.process(result);
    }

    @Test
    public void test3() {
        String result = "X1:=128;Y2:=1;Z3:=X1+Y2;";
        List list = analyzer.process(result);
        /*List trueList = new LinkedList();
        trueList.add("X1:=128");
        trueList.add("Y2:=1");
        trueList.add("Z3:=129");*/
        Assert.assertEquals(list.get(2), "Z3:=129.0");
    }
}
