package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Testing {
    private Analyzer analyzer;
    @Before
    public void setUp() {
        analyzer = new Analyzer();
    }
    @Test (expected = SyntaxException.class)
    public void test1(){
        String result = "X1=128";
        analyzer.analyze(result);
    }
    @Test (expected = SyntaxException.class)
    public void test2(){
        String result = "X1:=;";
        analyzer.analyze(result);
    }
    @Test (expected = SyntaxException.class)
    public void test3(){
        String result = "1:=128";
        analyzer.analyze(result);
    }
    @Test (expected = SyntaxException.class)
    public void test4(){
        String result = "X1:=128;Y2:23;";
        analyzer.analyze(result);
    }
    @Test (expected = SyntaxException.class)
    public void test5(){
        String result = "X1:=";
        analyzer.analyze(result);
    }
    @Test (expected = SyntaxException.class)
    public void test6(){
        String result = "X:=";
        analyzer.analyze(result);
    }
    @Test(expected = SyntaxException.class)
    public void test8(){
        String result = "X1:=128;Y:=56;Z1:=X1+Y2;";
        analyzer.analyze(result);
    }
    @Test
    public void test7(){
        String result = "X1:=128;Y2:=56;Z1:=X1+Y2;";
        analyzer.analyze(result);
        Assert.assertTrue(analyzer.finish);
    }

}
