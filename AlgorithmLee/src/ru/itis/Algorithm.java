package ru.itis;

import java.util.Arrays;

public class Algorithm {
    private int[][] space;
    private final static int WALL = -2;
    private final static int FREE = 0;
    private Point start;
    private Point end;
    //private Point way;
    private int position = 0;

    public void searchWay(int [][] labyrinth, Point start, Point end) {
        this.space = new int[labyrinth.length][labyrinth[0].length];
        for (int i = 0; i < labyrinth.length; i++) {
            System.arraycopy(labyrinth[i], 0, this.space[i], 0, labyrinth[0].length);
        }
        this.start = start;
        this.end = end;

        if(checking(start, end)) {
            setMarks();
        } else {
            throw  new IllegalArgumentException();
        }


    }

    public boolean checking (Point start, Point end) {
        if(space[start.getX()][start.getY()] != WALL && space[end.getX()][end.getY()] != WALL) {
            return true;
        }
        else return false;
    }

    public void setMarks() {
        //this.way = this.start;
        space[start.getX()][start.getY()] = -5; //старт
        while (space[end.getX()][end.getY()] == FREE) {
            for (int i = 0; i < space.length; i++) {
                for (int j = 0; j <  space[0].length; j++) {
                    if(space[i][j] == position && position != 0) {
                        marking(i, j);
                    } else {
                        if(space[i][j] == -5 && position == 0) {
                            marking(i, j);
                        }
                    }

                }
            }
            position++;
            if(position > space.length * space[0].length) {
                throw new WayNotFoundException();
            }
        }
    }

    public void marking(int x, int y) {
        if(x + 1 < space.length && space[x + 1][y] == FREE) {
            space[x + 1][y] = position + 1;
        }
        if(x - 1 > 0 && space[x - 1][y] == FREE) {
            space[x - 1][y] = position + 1;
        }
        if(y + 1 < space[x].length && space[x][y + 1] == FREE) {
            space[x][y + 1] = position + 1;
        }
        if(y - 1 > 0 && space[x][y - 1] == FREE) {
            space[x][y - 1] = position + 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public void getSpace() {
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j <  space[0].length; j++) {
                System.out.print( field(space[i][j]));
            }
            System.out.println();
//            System.out.println(Arrays.toString(space[i]));
        }
    }

    private String field(int num) {
        int defaultGap = 3;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < defaultGap - String.valueOf(num).length(); i++ ) {
            s.append(" ");
        }
        s.append(String.valueOf(num));
        return new String(s);
    }

}
