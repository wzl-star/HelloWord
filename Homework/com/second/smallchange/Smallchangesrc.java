package com.second.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Smallchangesrc {
    public static void main(String[] args) {
        boolean loop = true;
        double balance = 0;
        double income = 0;
        double pay = 0;
        String detail = "---------零钱通明细----------";
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Scanner scanner = new Scanner(System.in);
        String key = "";
        String payName = "";
        do {
            System.out.println("---------零钱通项目----------");
            System.out.println("1 零钱通明细");
            System.out.println("2 收益入账");
            System.out.println("3 消费");
            System.out.println("4 退    出");
            System.out.println("请选择(1-4)");
            key = scanner.next();
            switch (key) {
                case "1":
                    System.out.println(detail);
                    break;
                case "2":
                    System.out.println("请输入收益入账金额");
                    balance = scanner.nextInt();
                    income += balance;
                    date = new Date();
                    detail = "\n收益入账\t+" + balance + "\t" + sdf.format(date) + "\t" + "余额\t" + income;
                    break;
                case "3":
                    System.out.println("请输入消费项目");
                    payName = scanner.next();
                    System.out.println("请输入消费金额");
                    pay = scanner.nextInt();
                    if (pay >= income) {
                        break;
                    }
                    date = new Date();
                    income -= pay;
                    detail = "\n" + payName + "\t-" + pay + "\t" + sdf.format(date) +
                            "\t" + "余额:\t" + income;
                    break;
                case "4":
                    String choice = "";
                    choice = scanner.next();
                    while (true) {
                        System.out.println("是否退出，请输入y/n");
                        if ("y".equals(choice) || "n".equals(choice)) {
                            break;
                        }
                    }
                    if (choice.equals("y")) {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("选择有误");
            }
        }
        while (loop);
    }
}