package com.TankGameApp.tankgame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class Tankgame01 extends JFrame {
    private MyPanel1 np = null;
    String key = "";

    public static void main(String[] args) {
        Tankgame01 tankgame01 = new Tankgame01();

    }

    public Tankgame01() {
        System.out.println("请选择：新游戏1，继续上局游戏2");
        Scanner scanner = new Scanner(System.in);
        key = scanner.next();
        np = new MyPanel1(key);
        new Thread(np).start();
        this.add(np);
        this.setSize(1300, 750);
        this.addKeyListener(np);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Record.keepRecord();
                System.exit(0);
            }
        });
    }
}
