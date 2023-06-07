package com.second;

public class Homework0004 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Ia() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        },10,8);
    }
}
interface Ia{
    public double work(double n1 , double n2);
}
class Cellphone {
    public void testWork(Ia ia , double n1, double n2){
      double result = ia.work(n1, n2);
        System.out.println(result);
    }
}