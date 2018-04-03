package ru.itis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ShopService {
    public void ordersEqualsMass(Order orders[]) {
        Scanner scanner = new Scanner(System.in);
        int mas = scanner.nextInt();
        System.out.println("Заказывают:");
        for(int i = 0; i < orders.length; i++) {
            if( Integer.parseInt(orders[i].getMassa()) == mas) {
                System.out.println(orders[i].getNameOfOrder());
            }
        }
    }

    public void peopleFromSameCity(Owner owners[]) {
        Scanner scanner = new Scanner(System.in);
        String nameOfCity = scanner.next();
        for(int i = 0; i < owners.length; i++) {
            if(owners[i].getLivingPlace().equals(nameOfCity)) {
                System.out.println(owners[i].getName());
            }
        }
    }

    public void theBestOwner(Owner owners[]) {
        int max = 0;
        int index = 0;
        for(int i = 0; i < owners.length; i++) {
            if(owners[i].getCountOfOrders() > max) {
                max = owners[i].getCountOfOrders();
                index = i;
            }
        }
        System.out.println(' ');
        System.out.println("Лучший покупатель:");
        System.out.println(owners[index].getName() + " " + max);
    }


}
