package ru.itis;

public class ArrayList {
    void Menu() {
        System.out.println("1) Создать массив");
        System.out.println("2) Добавить число в конец массива");
        System.out.println("3) Удалить число из массива");
        System.out.println("4) Вставить число в массив");
        System.out.println("5) Вывести массив");
        System.out.println("6) Выход");
    }
    void DobavK(int a[], int n, int vvod) {
        for(int i=0; i<n; i++) {
            if(a[i]==0) {
                a[i]=vvod;
                break;
            }
        }
    }
    void Delite(int index, int a[], int n) {
        for(int i=index; i<n; i++) {
            a[i]=a[i + 1];
        }
    }
    void VstavK(int index, int a[], int numb, int n) {
        for(int i=n; i>index; i--) {
            a[i]=a[i-1];
        }
        a[index]=numb;
    }
    void Vivod(int a[], int n) {
        for(int i=0; i<n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
