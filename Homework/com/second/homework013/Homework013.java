package com.second.homework013;

public class Homework013 {
    public static void main(String[] args) {
        Student student = new Student("小明", '男', 18, 254568);
        student.info1();
        Teacher teacher = new Teacher("小组", '女', 32, 8);
        teacher.info2();
        Person[] p1 = new Person[4];
        p1[0] = new Student("张学生", '男', 18, 654258);
        p1[1] = new Student("李学生", '女', 19, 352585);
        p1[2] = new Teacher("何老师", '女', 35, 10);
        p1[3] = new Teacher("王老师", '男', 40, 15);
        Homework013 homework013 = new Homework013();
        homework013.bad(p1);
        for (int i = 0; i < p1.length; i++) {
            System.out.println(p1[i]);
        }
    }

    public void bad(Person[] p1) {
        Person temp = null;
        for (int i = 0; i < p1.length - 1; i++) {
            for (int j = 0; j < p1.length - 1 - i; j++) {
                if (p1[j].getAge() < p1[j + 1].getAge()) {
                    temp = p1[j];
                    p1[j] = p1[j + 1];
                    p1[j + 1] = temp;
                }
            }
        }
    }
}
