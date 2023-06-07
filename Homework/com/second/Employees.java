package com.second;

public class Employees extends Staff{
    public Employees(String name, double daySalary, int workDay, double garde) {
        super(name, daySalary, workDay, garde);
    }

    @Override
    public void salary() {
        System.out.print("普通员工 ");
        super.salary();
    }
}
