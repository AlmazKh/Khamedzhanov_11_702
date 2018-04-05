package ru.itis;

public class Main {

    public static void main(String[] args) {
        Algorithm lee = new Algorithm();
        Point start = new Point(1, 1);
        Point end = new Point(6, 5);

        int [][] labyrinth = {
                {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
                {-2, -1, -1, -1, -1, -1, -1, -1, -1, -2},
                {-2, -2, -1, -2, -2, -1, -2, -1, -2, -2},
                {-2, -2, -1, -2, -2, -1, -2, -1, -2, -2},
                {-2, -2, -1, -2, -2, -2, -2, -1, -2, -2},
                {-2, -2, -1, -1, -1, -2, -2, -1, -2, -2},
                {-2, -2, -1, -2, -1, -1, -1, -1, -2, -2},
                {-2, -1, -1, -2, -2, -2, -2, -2, -2, -2},
                {-2, -1, -1, -1, -2, -2, -2, -2, -2, -2},
                {-2, -2, -2, -2, -2, -2, -2, -2, -2, -2},
        };
        /*int [][] labyrinth = {
                {-2, -2, -2, -2, -2},
                {-2,  0,  0,  0, -2},
                {-2,  0, -2,  0, -2},
                {-2,  0, -2,  0, -2},
                {-2, -2, -2, -2, -2},

        };*/
        lee.searchWay(labyrinth, start, end);
        lee.getSpace();
        System.out.println(lee.getPosition());
    }
}
