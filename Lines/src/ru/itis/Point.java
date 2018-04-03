package ru.itis;

public class Point {

    private int x;
    private int y;
    private int points[][];
    private int amountOfPoints;
    private int count;

    public void setAmountOfPoints(int amountOfPoints) {
        this.amountOfPoints  = amountOfPoints;
        this.count = amountOfPoints;
    }

    public int getAmountOfPoints() {
        return amountOfPoints;
    }

    public void setPoints() {
        this.points = new int[getAmountOfPoints()][2];
    }

    public void setPoints(int x, int y) {
            this.points[count][0] = x;
            this.points[count][1] = y;
            this.count--;
    }

    public Point() { }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
