package ru.itis;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Figure {
    private String type;
    private String leftX;
    private String leftY;
    private String rightX;
    private String rightY;
    private String color;

    public Figure(String type, String leftX, String leftY, String rightX, String rightY, String color) {
        this.type = type;
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;
        this.rightY = rightY;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLeftX() {
        return leftX;
    }

    public void setLeftX(String leftX) {
        this.leftX = leftX;
    }

    public String getLeftY() {
        return leftY;
    }

    public void setLeftY(String leftY) {
        this.leftY = leftY;
    }

    public String getRightX() {
        return rightX;
    }

    public void setRightX(String rightX) {
        this.rightX = rightX;
    }

    public String getRightY() {
        return rightY;
    }

    public void setRightY(String rightY) {
        this.rightY = rightY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /*public Figure(int type, double leftX, double leftY, double rightX, double rightY, int color) {
        this.type = type;
        this.leftX = leftX;
        this.leftY = leftY;
        this.rightX = rightX;
        this.rightY = rightY;
        this.color = color;
    }*/

    /*public void GraphicPic(String filename) {
        List<Figure> list = new LinkedList<>();
        try {
            FileInputStream listOfFigures = new FileInputStream("ListOfFigures.txt");
            Scanner scanner = new Scanner(listOfFigures);
            while (scanner.hasNext()) {
                type =
            }
        } catch (Exception e) {

        }
    }*/
}
