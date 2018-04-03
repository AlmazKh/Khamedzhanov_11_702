package ru.itis;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Analyzer analyzer = new Analyzer();
		//String str = "X1:=128;Y2:=56;Z1:=X1+Y2;";
	    String str = "X1:=128;Y2:=56;Z1:=X1+Y2;";
	    analyzer.process(str);
	    List list = analyzer.process(str);
    }
}
