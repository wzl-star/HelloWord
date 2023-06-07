package com.TankGameApp.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

public class MyPanel1 extends JPanel implements KeyListener, Runnable {
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Notes> notes = new Vector<>();
    Vector<Bombs> bombs = new Vector<>();
    int sizeNum = 3;
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel1(String Key) {
        File file = new File(Record.getRecordFath());
        if (file.exists()) {
            notes = Record.loadRecord();
        }else {
            System.out.println("文件不存在，只能开启新游戏");
            Key = "1";
        }
      switch (Key){
          case "1":
              hero = new Hero(100, 100);
              hero.setSpeed(2);
              for (int i = 0; i < sizeNum; i++) {
                  EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
                  enemyTank.setDirect(2);
                  new Thread(enemyTank).start();
                  Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                  enemyTank.shots.add(shot);
                  new Thread(shot).start();
                  enemyTanks.add(enemyTank);
                  enemyTank.setEnemyTanks(enemyTanks);
                  Record.setEnemyTank(enemyTanks);
              }
              break;
          case "2":
              hero = new Hero(100, 100);
              hero.setSpeed(2);
              for (int i = 0; i < notes.size(); i++) {
                  Notes notes = this.notes.get(i);
                  EnemyTank enemyTank = new EnemyTank(notes.getX(),notes.getY());
                  enemyTank.setDirect(notes.getDirect());
                  new Thread(enemyTank).start();
                  Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                  enemyTank.shots.add(shot);
                  new Thread(shot).start();
                  enemyTanks.add(enemyTank);
                  enemyTank.setEnemyTanks(enemyTanks);
                  Record.setEnemyTank(enemyTanks);
              }
              break;
      }
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel1.class.getResource("/1.png"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel1.class.getResource("/2.png"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel1.class.getResource("/3.png"));
    }

    public void hitEnemyTank(Shot shot, Tank tank) {
        switch (tank.getDirect()) {
            case 0:
            case 2:
                if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 40
                        && shot.getY() > tank.getY() && shot.getY() < tank.getY() + 60) {
                    shot.setLive(false);
                    tank.isLive = false;
                    enemyTanks.remove(tank);
                    if (tank instanceof EnemyTank){
                        Record.costing();
                    }
                    Bombs bombs1 = new Bombs(tank.getX(), tank.getY());
                    bombs.add(bombs1);

                }
                break;
            case 1:
            case 3:
                if (shot.getX() > tank.getX() && shot.getX() < tank.getX() + 60
                        && shot.getY() > tank.getY() && shot.getY() < tank.getY() + 40) {
                    shot.setLive(false);
                    tank.isLive = false;
                    enemyTanks.remove(tank);
                    if (tank instanceof EnemyTank){
                        Record.costing();
                    }
                    Bombs bombs1 = new Bombs(tank.getX(), tank.getY());
                    bombs.add(bombs1);
                }
                break;
        }
    }

    public void hitHero() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            {
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.isLive() && hero.isLive) {
                        hitEnemyTank(shot, hero);
                    }
                }
            }

        }
    }

    public void hitEnemy() {
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive()) {     // 判断null的一定要放在前面
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitEnemyTank(hero.shot, enemyTank);
                }
            }
            if (!shot.isLive()) {
                hero.shots.remove(shot);
            }
        }
    }

    public void recordDraw(Graphics g) {
        g.setColor(Color.black);
        Font font = new Font("宋体", Font.BOLD, 20);
        g.setFont(font);
        g.drawString("记录我方击中的坦克总数", 1000, 30);
        drawTank(1020,60,g,0,0);
        g.setColor(Color.black);
        g.drawString(Record.getCost1()+"",1080,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        recordDraw(g);
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        }
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive()) {
                g.fill3DRect(shot.getX(), shot.getY(), 2, 2, false);
            } else {
                hero.shots.remove(shot);
            }
        }


        if (hero.shot != null && hero.shot.isLive()) {
            g.fill3DRect(hero.shot.getX(), hero.shot.getY(), 2, 2, false);
        }
        for (int i = 0; i < bombs.size(); i++) {
            Bombs bombs3 = this.bombs.get(i);
            if (bombs3.life > 6) {
                g.drawImage(image1, bombs3.x, bombs3.y, 60, 60, this);
            } else if (bombs3.life > 3) {
                g.drawImage(image2, bombs3.x, bombs3.y, 60, 60, this);
            } else {
                g.drawImage(image3, bombs3.x, bombs3.y, 60, 60, this);
            }
            bombs3.lifeDown();
            if (bombs3.life == 0) {
                bombs.remove(bombs3);
            }
        }

        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.isLive()) {
                        g.fill3DRect(shot.getX(), shot.getY(), 2, 2, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
    }

    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            if (hero.getY() > 0) {
                hero.moveUP();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            if (hero.getY() + 60 < 750)
                hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.shotEnemyTank();
            this.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitEnemy();
            hitHero();
            this.repaint();
        }
    }
}
