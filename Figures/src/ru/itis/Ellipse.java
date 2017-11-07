package ru.itis;

public class Ellipse extends SpaceFigures {

    protected double r1;
    protected double r2;
    private double perimetr;
    private double square;


    public Ellipse(double x, double y, double r1, double r2) {
        super(x, y);
        this.r1 = r1;
        this.r2 = r2;
        this.perimetr = 6.28 * Math.sqrt((r1 * r1 + r2 * r2)/2);
        this.square = 3.14 * r1 * r2;
    }

    protected double perimetr() {
        return perimetr;
    }

    public double square() {
        return square;
    }

}
