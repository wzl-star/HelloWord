package com.second;

public class Staff {
    private String name;
    private double daySalary;
    private int workDay;
    private double garde;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySalary() {
        return daySalary;
    }

    public void setDaySalary(double daySalary) {
        this.daySalary = daySalary;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public double getGarde() {
        return garde;
    }

    public void setGarde(double garde) {
        this.garde = garde;
    }

    public Staff(String name, double daySalary, int workDay, double garde) {
        this.name = name;
        this.daySalary = daySalary;
        this.workDay = workDay;
        this.garde = garde;
    }

    public void salary(){
    System.out.println( name + " 工资为 " + daySalary*workDay*garde);
}

}
