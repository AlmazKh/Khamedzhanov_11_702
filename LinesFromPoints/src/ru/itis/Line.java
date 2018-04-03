package ru.itis;

public class Line {
    private int lines[][];
    private int count = 1;
    private int checker = 1 ;
    private int last;

    public void setLines(int amountOfPoints) {
        this.lines = new int[amountOfPoints][2];
    }

    public void createLines(int points[][]) {
        int j = 0;
        int start = 0;
        for(int i = 0; i < points.length; i++) {
            if(start == i) {
                if((points[i][0] == 0) && (points[i][1] == 0)) {
                    start++;
                }
            }
        }
        lines[0][0] = points[start][0];
        lines[0][1] = points[start][1];
        for(int i = start; i < points.length - 1; i++) {
            if((lines[j][1] <= points[i + 1][1]) ||(lines[j][0] == points[i + 1][0]) ) {
                lines[j+1][0] = points[i+1][0];
                lines[j+1][1] = points[i+1][1];//TODO: в lines будут ячейки равные нулю, Нужно исправить и прописать отдельный индекс
                points[j][0] = 0;              //TODO: разобраться с last и checker
                points[j][1] = 0;
                last = i + 1; //индекс последнего элемента
                count++;
                j++;
                checker++;//проверка -> все ли точки использованы
            }
        }
        if(lines[j][1] == points[last][1]) { //удаление последнего элемента
            points[last][0] = 0;
            points[last][1] = 0; //TODO: Не ту точку удаляяешь!!!!!!!!!!!!!!!!!!
            last = 0;
        }
        printLines(lines);
        if(checker < points.length) {
            if(checker + 1 == points.length) {
                checker++;
                createLines(points);
            }
        }
    }

    public void printLines(int lines[][]) {
        for(int i = 0; i < count; i++) {
            System.out.print("(" + lines[i][0] + ";" + lines[i][1] + ") ");
        }
        System.out.println("");
        count = 1;


    }
}
