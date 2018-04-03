package ru.itis;

public class Main {

    public static void main(String[] args) throws Exception {
        Point point = new Point();
        Line line = new Line();

	    try {
            point.setAmountOfPoints();
            point.readCoordinates();
        } catch (Exception e) {}

        //point.sortPoints();
        line.setLines(point.getAmountOfPoints());
        line.createLines(point.sortPoints());

        //point.print(point.sortPoints());
    }
}
