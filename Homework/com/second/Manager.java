package com.second;

public class Manager extends Staff {
    private double bonus;

    public Manager(String name, double daySalary, int workDay, double garde) {
        super(name, daySalary, workDay, garde);
    }
    @Override
    public void salary() {
        System.out.println("经理 " + getName() + " 工资为 " + (getDaySalary()*getWorkDay()*getGarde()+bonus));
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
