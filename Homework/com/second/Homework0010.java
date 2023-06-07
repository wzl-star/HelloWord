package com.second;

import java.util.ArrayList;
import java.util.Comparator;

public class Homework0010 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("tom",2400,new MyDate(1992,10,25)));
        employees.add(new Employee("jack",1800,new MyDate(1993,8,21)));
        employees.add(new Employee("smith",3200,new MyDate(1994,11,16)));
        for (Employee employees1 :employees) {
            System.out.println(employees1);
        }
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                if (!(emp1 instanceof Employee && emp2 instanceof Employee)){
                    return 0;
                }
                int e = emp1.getName().compareTo(emp2.getName());
                if (e != 0){
                    return e ;
            }
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });


    }
}
class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        int Y = year - o.getYear();
        if (Y != 0) {
            return Y;
        }
        int M = month - o.getMonth();
        if (M != 0) {
            return M;
        }
        return day - o.getDay();

    }
}

class Employee{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}