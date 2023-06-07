package com.second;

public class Scientist extends Employees02 {
    private double bonus;

    public Scientist(double baseSalary, String name) {
        super(baseSalary, name);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void print() {
        System.out.println(getName() + " 全年工资为 " + (getBaseSalary()*12 + bonus));
    }
}
