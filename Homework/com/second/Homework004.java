package com.second;

public class Homework004 {
    public static void main(String[] args) {
        Manager tim = new Manager("tim", 500, 25, 1.2);
        tim.setBonus(1000);
        tim.salary();
        Employees jack = new Employees("jack", 300, 25, 1.0);
        jack.salary();
    }
}
