package ru.itis;

public class ArrayList {
    int a[];
    void Menu() {
        System.out.println("1) Создать массив");
        System.out.println("2) Добавить число в конец массива");
        System.out.println("3) Удалить число из массива");
        System.out.println("4) Вставить число в массив");
        System.out.println("5) Вывести массив");
        System.out.println("6) Выход");
    }
    void createMas(int n) {
        a = new int[n];
    }
    void Mas(int a[]) {
        int anew[] = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            anew[i] = a[i];
        }
        a = new int[anew.length*2];
        for(int i = 0; i < anew.length; i++) {
            a[i] = anew[i];
        }
    }
    void addToEnd(int n, int vvod) {
        n = a.length;
        for(int i=0; i<n; i++) {
            if(a[i]==0) {
                a[i]=vvod;
                break;
            } else {
                Mas(a);
            }
        }
    }
    void Delete(int index, int n) {
        for(int i=index; i<n; i++) {
            a[i]=a[i + 1];
        }
    }
    void addTo(int index, int numb, int n) {
        for(int i=n; i>index; i--) {
            a[i]=a[i-1];
        }
        a[index]=numb;
    }
    void outPutMas(int n) {
        n = a.length;
        for(int i=0; i<n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
