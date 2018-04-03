package ru.itis;

public class Main {

    public static void main(String[] args) {
        Pixel pixels[][] = new Pixel[16][16];
       // Pixel pixelsR[][] = new Pixel[16][16];
	    Image image = new Image(pixels);
        //image.setPixelsR(pixelsR);
	    image.setPixels(pixels);
	    image.getRComponent();
    }
}
