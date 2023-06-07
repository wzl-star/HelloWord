package com.second;

public class Homework0002 {
    public static void main(String[] args) {
        animal cat = new cat();
        cat.shout();
        animal dog = new dog();
        dog.shout();
    }
}
abstract class animal{
    public  abstract void shout();
}
class cat extends animal{
    @Override
    public void shout() {
        System.out.println("猫会汪汪叫");
    }
}
class dog extends animal{
    @Override
    public void shout() {
        System.out.println("狗会旺旺叫");
    }
}