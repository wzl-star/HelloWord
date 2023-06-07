package com.second;

public class Homework005 {
    public static void main(String[] args) {
        Worker worker = new Worker(1000,"tom");
        worker.print();
        Teacher teacher = new Teacher(3000,"小李");
        teacher.setDaySalary(30);
        teacher.setWorkDay(25);
        teacher.print();
        Scientist scientist = new Scientist(5000,"小徐");
        scientist.setBonus(10000);
        scientist.print();
    }
}
