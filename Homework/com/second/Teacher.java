package com.second;

public class Teacher extends Employees02 {
    private int workDay;
    private double daySalary;

    public Teacher(double daySalary, String name) {
        super(daySalary, name);
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public double getDaySalary() {
        return daySalary;
    }

    public void setDaySalary(double daySalary) {
        this.daySalary = daySalary;
    }

    @Override
    public void print() {
        System.out.println(getName() + " 全年工资为 " + ((getBaseSalary() *12) + workDay * daySalary));
    }
}
