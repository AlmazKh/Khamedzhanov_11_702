package ru.itis;

 class Car {
    private String model;
    private int number;
    private int power;
    private String color;
    private double s;

     Car(String model,int power) {
       setPower(power);
       setModel(model);
    }
    public Car() {

    }
    public Car(String model, int number, int power, String color) {
       setModel(model);
       setNumber(number);
       setPower(power);
       setColor(color);
    }
    public void setS(double s) {

    }
    public double getS() {
        return s;
    }
    public void setPower(int power) {
        if(power >= 0) {
            this.power = power;
        } else {
            this.power = 0;
            System.out.println("Ошибка");
        }
    }
    public void setModel( String model) {
        if(model.equals("")) {
            this.model = "";
            System.out.println("Ошибка");
        } else {
            this.model = model;
        }
    }
    public void setNumber(int number) {
        if(number >= 0) {
            this.number = number;
        } else {
            this.number = 0;
            System.out.println("Ошибка");
        }
    }
    public void setColor(String color) {
        if(color.equals("")) {
            this.color = "";
            System.out.println("Ошибка");
        } else {
            this.color = color;
        }
    }
    public String getColor() {
        return color;
    }
    public void go(double n) {
        s = s + n;
        System.out.println("Пробег = " + s + " " );
    }
}
