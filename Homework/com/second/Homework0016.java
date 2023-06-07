package com.second;

import java.io.*;
import java.util.Properties;

public class Homework0016 {
    public static void main(String[] args) throws IOException {
        String c2Path = "src\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(c2Path));
        properties.list(System.out);
        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");
        Ludou s1 = new Ludou(name, age, color);
        System.out.println(s1);
        String srcPath = "e:\\dog.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(srcPath));
        objectOutputStream.writeObject(s1);
        objectOutputStream.close();


    }
}

class Ludou implements Serializable {
    private String name;
    private int age;
    private String color;

    public Ludou(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ludou{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}

