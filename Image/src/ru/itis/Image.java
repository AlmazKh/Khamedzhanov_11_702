package ru.itis;

import java.util.Random;

public class Image {
    private Pixel pixels[][];
    //private  Pixel pixelsR[][];

    public Image(Pixel[][] pixels) {
        this.pixels = pixels;
    }

    public Pixel[][] getPixels() {
        return pixels;
    }

    public void setPixels(Pixel[][] pixels) {
        Random random = new Random();
        for(int i = 0; i < 16; i++) {
            for (int j = i; j < 16; j++) {
                pixels[i][j] = new Pixel(random.nextInt(256)+1, random.nextInt(256)+1, random.nextInt(256)+1);
            }
        }
        this.pixels = pixels;
    }

    public Image getRComponent() {
        for(int i = 0; i < 16; i++) {
            for (int j = i; j < 16; j++) {
                pixels[i][j].setG(0);
                pixels[i][j].setB(0);
            }
        }

        return this;
    }
}
