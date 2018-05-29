package ru.itis;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    @Parameter(names = "-classFolder")
    private String classFolder;

    public static void main(String[] args) {
        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        try {
            main.run();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void run() throws Exception {
        // надо передавать, например
        // -classFolder "C:\Users\admin.WIN-IPM3OA3VQNQ\Desktop\Java\Classes"
        URL url = new URL(new File(this.classFolder).toURI().toString());
        URLClassLoader loader = URLClassLoader.newInstance(new URL[]{url}, getClass().getClassLoader());
        Files
                .list(Paths.get(this.classFolder))
                .forEach(file -> {
                    try {
                        String className = file.getFileName().toString().split("\\.")[0];
                        Class aClass = loader.loadClass(className);
                        System.out.println("Класс: " + className);
                        System.out.println();

                        Field[] fields = aClass.getDeclaredFields();
                        Constructor[] constructors = aClass.getConstructors();
                        Method[] methods = aClass.getMethods();

                        System.out.println("Конструкторы:");
                        for (Constructor constructor: constructors)
                            System.out.println(constructor);
                        System.out.println();

                        System.out.println("Поля:");
                        for (Field field : fields)
                            System.out.println(field);
                        System.out.println();

                        System.out.println("Методы: ");
                        for(Method method: methods)
                            System.out.println(method);
                        System.out.println();

                        System.out.println("____________________________________");

                        System.out.println();
                    } catch (Exception e) {
                        throw new IllegalArgumentException(e);
                    }
                });
    }
}