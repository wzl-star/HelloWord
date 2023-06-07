package com.second;

public class Homework007 {
    public static void main(String[] args) {
        Car car1 = new Car(50);
        car1.getAir().flow();
        Car.Air air1 = car1.new Air();
        air1.flow();


    }
}

class Car {
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    class Air {
        public void flow() {
            if (temperature > 40) {
                System.out.println("吹冷风");
            } else if (temperature < 0) {
                System.out.println("吹热风");
            } else {
                System.out.println("关掉空调");
            }
        }
    }

    public Air getAir() {
        return new Air();
    }
}
