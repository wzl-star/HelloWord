package com.second;

public class Homework0003 {
    public static void main(String[] args) {
        Person_ person_1 = new Person_("唐僧",new Horse());
        person_1.passCommon();
        person_1.passRiver();

    }
}
interface Vehicles {
    public void work();
}
class Horse implements Vehicles{

    @Override
    public void work() {
        System.out.println("一般情况下的工具");
    }
}
class Boat implements Vehicles{

    @Override
    public void work() {
        System.out.println("遇到大河时的交通工具");
    }
}
class plane implements Vehicles{

    @Override
    public void work() {
        System.out.println("遇到火山时的交通工具");
    }
}
class Vehiclefactories {
    private static Horse horse = new Horse();

    public static Horse common() {
        return horse;
    }

    public static Boat river() {
        return new Boat();
    }

    public static plane getPlane() {
        return new plane();
    }
}
class Person_ {
    private String name;
    private Vehicles vehicles;

    public Person_(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = Vehiclefactories.river();
        }
        vehicles.work();
    }

    public void passCommon() {
        if (!(vehicles instanceof Horse)) {
            vehicles = Vehiclefactories.common();
        }
        vehicles.work();
    }

    public void passVolcano() {
        if (!(vehicles instanceof plane)) {
            vehicles = Vehiclefactories.getPlane();
        }
        vehicles.work();
    }
}

