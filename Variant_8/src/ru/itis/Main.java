package ru.itis;

public class Main {

    public static void main(String[] args) {
	    GraphicPic graphicPic = new GraphicPic();
	    graphicPic.newGraphicPic("ListOfFigures.txt");
	    graphicPic.size();
	    //graphicPic.show();
	    Figure figure = new Figure("2" , "8", "8", "2", "2", "8077");
	   	graphicPic.insert(figure);
	   	//graphicPic.show();
	    graphicPic.delete(2);
	    graphicPic.show();
	    //graphicPic.hasSquareBiggerThanS(100.0).show();
	    //Figure rectangle = new Figure("1" , "1", "4", "5", "1", "333");
	    //graphicPic.commonWith(rectangle).show();



    }
}

