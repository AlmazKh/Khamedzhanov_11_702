package ru.itis;
//прямоугольник
public class Rectangle extends SpaceFigures {
    protected double a;
    protected double b;

    Rectangle( double x, double y, double a, double b) {
        super(x, y);
        this.a = a;
        this.b = b;
    }

    @Override
    protected double square() {
        return a * b;
    }

    @Override
    protected double perimetr() {
        return (a + b) * 2;
    }
}
