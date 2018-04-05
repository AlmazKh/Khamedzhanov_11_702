package ru.itis;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    /*public Point[][] setPoints(int elements [][]) {

        for(int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[0].length; j++ ) {

            }
        }
    }*/
}
