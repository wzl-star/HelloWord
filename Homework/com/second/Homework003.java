package com.second;

public class Homework003 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("tom", 35, "高级", 10000, 1.1);
        teacher.introduce();
    }

    public static class Lecture extends Teacher{
        public Lecture(String name, int age, String post, double salary, double garde) {
            super(name, age, post, salary, garde);
        }

        @Override
        public void introduce() {
            super.introduce();
        }
    }

    public static class Teacher {
        private String name;
        private int age;
        private String post;
        private double salary;
        private double garde;

        public Teacher(String name, int age, String post, double salary, double garde) {
            this.name = name;
            this.age = age;
            this.post = post;
            this.salary = salary;
            this.garde = garde;
        }

        public void introduce() {
            System.out.println("姓名" + name + "年龄" + age + "职称" + post + "工资" + salary + "等级" + garde);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public double getGarde() {
            return garde;
        }

        public void setGarde(double garde) {
            this.garde = garde;
        }
    }
}
