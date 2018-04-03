package ru.itis;

public class Pixel {
    private int R;
    private int G;
    private int B;

    public Pixel(int r, int g, int b) {
        R = r;
        G = g;
        B = b;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public int getG() {
        return G;
    }

    public void setG(int g) {
        G = g;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }
}
