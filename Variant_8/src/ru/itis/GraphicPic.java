package ru.itis;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GraphicPic {
    //TODO: нужен свой LinkedList
    //List<Figure> list = new LinkedList<>();

    private static class Node {
        Figure figure;
        Node next;

        Node(Figure figure) {
            this.figure = figure;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public GraphicPic() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Figure get(int index) {
        Node node = head;
        while(index > 0) {
            node = node.next;
            index--;
        }
        return node.figure;
    }

    public void add(Figure figure) { //добавление в конец списка
        Node newNode = new Node(figure);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;

    }

    public void add(int index,Figure figure) { //добавление по индексу (происходит замена i элемента на новый)
        Node newNode = new Node(figure);
        Node node = head;
        while(index > 0) {
            node = node.next;
            index--;
        }
        node.figure = figure;
        //this.size++;
    }
    public void remove(int index) {
        Node node = head;
        Node node2 = node.next;
        while(index - 1 > 0) {
            node = node.next;
            node2 = node2.next;
            index--;
        }
        node.next = node2.next;
        this.size--;
    }

    public void remove(Figure figure) {
        if (head.figure == figure) {
            head = head.next;
            return;
        }

        Node node = head;
        Node node2 = head;

       /* if (tail.value == element) {
            while (node2 != tail) {
                if (node2.value == element) {
                    node.next = null;
                    return;
                }
                node = node.next;
                node2 = node.next;
            }*/
        while (node2 != tail) {
            if (node2.figure == figure) {
                node.next = node2.next;
                return;
            }
            node = node.next;
            node2 = node.next;
        }
    }

    public int size() {
        int size = 1;
        Node node = head;
        while (node.next != null) {
            node = node.next;
            size++;
        }
        return size;
    }


    public void newGraphicPic(String filename) {
        String type;
        String leftX;
        String leftY;
        String rightX;
        String rightY;
        String color;
        try {
            FileInputStream listOfFigures = new FileInputStream(filename);
            Scanner scanner = new Scanner(listOfFigures);
            while (scanner.hasNext()) {
                type = scanner.next();
                leftX = scanner.next();
                leftY = scanner.next();
                rightX = scanner.next();
                rightY = scanner.next();
                color = scanner.next();
                Figure figure = new Figure(type, leftX, leftY, rightX, rightY, color);
                add(figure);

            }
        } catch (Exception e) {

        }
    }

    public void show() {
        for( int i = 0; i < size; i++) {
            System.out.println("Фигура №" + (i+1));
            if(get(i).getType().equals("1")) {
                System.out.println("    Прямоугольник");
            } else {
                if(get(i).getType().equals("2")) {
                    System.out.println("    Отрезок");
                } else {
                    System.out.println("    Круг");
                }
            }
            if(get(i).getType().equals("3")) {
                System.out.println("    (" + get(i).getLeftX() + ";" + get(i).getLeftY() + ")");
                System.out.println("    Радиус = " + get(i).getRightX());
                System.out.println("    Number of coolor: " + get(i).getColor());
            } else {
                System.out.println("    (" + get(i).getLeftX() + ";" + get(i).getLeftY() + ")");
                System.out.println("    (" + get(i).getRightX() + ";" + get(i).getRightY() + ")");
                System.out.println("    Number of color: " + get(i).getColor());
            }

        }
    }

    public void insert(Figure f) {
        int equals = 0;
        for(int  i = 0; i < size; i++) {
            if(f.getType().equals(get(i).getType())) {
                equals = i;
                break;
            }
        }
        if(equals != 0) {
            add(equals, f);
            //remove(equals + 1);
        } else {
            add(f);
        }
    }

    public void delete(int i) {
        for(int j = 0; j < size; j++) {
            if(get(j).getType().equals(String.valueOf(i))) {
                remove(j);
            }
        }
    }

    public GraphicPic commonWith(Figure r) {
    //TODO нужен ИЗЕВЫЙ спооб нахождения пересечения фигур!!
        GraphicPic g = new GraphicPic();
        for(int i = 0; i < size; i++) {
            if(get(i).getType().equals("2")) {
                double RightX = Double.parseDouble(get(i).getRightX());
                double LeftX = Double.parseDouble(get(i).getLeftX());
                double RightY = Double.parseDouble(get(i).getRightY());
                double LeftY = Double.parseDouble(get(i).getLeftY());
                if(LeftX >= Double.parseDouble(r.getLeftX()) && LeftX <= Double.parseDouble(r.getRightX())) {
                    if(RightX >= Double.parseDouble(r.getLeftX()) && RightX <= Double.parseDouble(r.getRightX())) {
                        if((LeftY >= Double.parseDouble(r.getLeftY())) &&
                                (RightY <= Double.parseDouble(r.getLeftY()) || RightY <= Double.parseDouble(r.getRightY()))) {
                            g.add(get(i)); //работает для одного случая
                        } else { //TODO: расшарить для случая, когда точка верхняя не фиксируется, а нижняя ниже сторон
                            if((RightY >= Double.parseDouble(r.getRightY())) &&
                                    (LeftY >= Double.parseDouble(r.getLeftY()) || RightY <= Double.parseDouble(r.getRightY()))) {

                            }
                        }
                    }
                }
                //TODO:внизу чисто копия надо доделать до конца( с третьей строчки)
                if(LeftY <= Double.parseDouble(r.getLeftY()) && LeftY >= Double.parseDouble(r.getRightY())) {
                    if(RightY <= Double.parseDouble(r.getLeftY()) && RightY >= Double.parseDouble(r.getRightY())) {
                        if((LeftX <= Double.parseDouble(r.getLeftX())) &&
                                (RightY <= Double.parseDouble(r.getLeftY()) || RightY <= Double.parseDouble(r.getRightY()))) {
                            g.add(get(i));
                        }
                    }
                }
            }
        }
        return g;
    }

    public GraphicPic hasSquareBiggerThanS(double s) {
        //List<Figure> listOfBiggerS = new LinkedList<>();
        GraphicPic g = new GraphicPic();
        for(int i = 0; i < size; i++) {
            if(get(i).getType().equals("3")) {
                double sOfCircle = Math.PI * Double.parseDouble(get(i).getRightX())*Double.parseDouble(get(i).getRightX());
                if(sOfCircle > s) {
                    g.add(get(i));
                }
            }
            if(get(i).getType().equals("1")) {
                double sOfRectangle = (Double.parseDouble(get(i).getLeftY()) - Double.parseDouble(get(i).getRightY())) *
                        (Double.parseDouble(get(i).getRightX()) - Double.parseDouble(get(i).getLeftX()));
                if(sOfRectangle > s) {
                    g.add(get(i));
                }
            }
        }

        return g;
    }


}
