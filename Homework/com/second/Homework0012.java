package com.second;

import java.util.Scanner;

public class Homework0012 {
    public static void main(String[] args) {
        A a = new A();
        a.setName("A线程");
        B b = new B(a);
        b.setName("b线程");
        a.start();
        b.start();

    }
}
class A extends Thread{
    private boolean loop = true;
    @Override
    public void run() {
        while (loop){
            System.out.println((int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
class B extends Thread{
  private A a;
   private Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
       while (true) {
           System.out.println("请输入你的指令");
           char key = scanner.next().toUpperCase().charAt(0);
           if (key == 'Q') {
               a.setLoop(false);
               break;
           }
       }
    }
}
