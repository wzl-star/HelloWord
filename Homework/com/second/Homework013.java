package com.second;

public class Homework013 {
    public static void main(String[] args) {
        AB ab = new AB();
        Thread thread01 = new Thread(ab);
        Thread thread02 = new Thread(ab);
        thread01.start();
        thread02.start();
    }
}
class AB implements Runnable{
    private double cash = 10000;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                if (cash < 1000) {
                    System.out.println("余额不足");
                    break;
                }
                cash -= 1000;
                System.out.println("账户余额为" + cash);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
