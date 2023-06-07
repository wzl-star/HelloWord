package com.second.homework013;

public class Student extends Person{
    private float stu_id;

    public Student(String name, char sex, int age, float stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public float getStu_id() {
        return stu_id;
    }

    public void setStu_id(float stu_id) {
        this.stu_id = stu_id;
    }
    public void study(){
        System.out.println("我承诺，我会好好学习。");
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }
    public void info1(){
        System.out.println("学生的信息：");
        System.out.println(super.basicInfo());
        System.out.println(stu_id);
        study();
        System.out.println(play());
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                '}'+ super.toString();
    }
}
