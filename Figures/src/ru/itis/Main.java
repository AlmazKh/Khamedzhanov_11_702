package ru.itis;

public class Main {

    public static void main(String[] args) {
	    SpaceFigures ellipse = new Ellipse(1,2, 1, 2);
	    SpaceFigures restangle = new Rectangle(2, 4, 1, 3);
	    SpaceFigures circle = new Circle(1, 2, 5);
	    SpaceFigures square = new Square(1, 2, 4);

        SpaceFigures figures[] = {ellipse, restangle, circle, square};

        for(SpaceFigures figures1 : figures) {
            System.out.println(figures1.perimetr());
            System.out.println(figures1.square());
        }

    }
}
