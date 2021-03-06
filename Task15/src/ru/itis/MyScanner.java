
package ru.itis;

import java.io.FileInputStream;

public class MyScanner {
    private FileInputStream input;
    byte bytes[];

    public MyScanner(String name){
        try {
            input = new FileInputStream(name);
            bytes = new byte[input.available()];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String nextLine() throws Exception{
        String line = "";
        input.read(bytes);
        for (int i = 0; i < bytes.length; i++){
            line += (char) bytes[i];
        }
        return line;
    }

    public int nextInt() throws Exception{
        input.read(bytes);
        int number = 0;
        int pow = 1;
        boolean check = false;
        for (int i = bytes.length - 1; i >= 0; i--){
            if ((char) bytes[i] - '0' >= 0 && (char) bytes[i] - '0' <=9) {
                number += ((char) bytes[i] - '0') * pow;
                pow *= 10;
            } else{
                check = (bytes[i] != 0 && (char) bytes[i] != '-') ? true : check;
            }
        }
        number = ((char) bytes[0] == '-') ? (number == 0) ? number : -number : number;
        if (check){
            System.err.println("Error");
            System.exit(-1);
        }
        return number;
    }
}