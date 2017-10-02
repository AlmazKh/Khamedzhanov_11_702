package ru.itis;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ArrayList list = new ArrayList();

            int f=0, vvod=0, n=0, index=0, numb=0;
            int a[] = new int[100];

            while(f!=6) {

                list.Menu();

                f=scanner.nextInt();

                switch(f) {
                    case 1:
                        n = scanner.nextInt();
                        break;
                    case 2:
                        vvod = scanner.nextInt();
                        list.DobavK(a, n, vvod);
                        break;
                    case 3:
                        index = scanner.nextInt();
                        list.Delite(index, a, n);
                        break;
                    case 4:
                        numb = scanner.nextInt();
                        index = scanner.nextInt();
                        list.VstavK(index, a, numb, n);
                        break;
                    case 5:
                        list.Vivod(a, n);
                        break;
                    //case 6:
                    //	System.exit(0);

                }

            }

        }
    }
