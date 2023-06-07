package com.TankGameApp.tankgame;

public class Shot implements Runnable {
    private int x;
    private int y;
    private int direct;
    private boolean isLive = true;
    private int speed = 1;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;

            }
            System.out.println("x的坐标" + x + "y的坐标" + y);
            if (!(x > 0 && x < 1000 && y > 0 && y < 750 && isLive)) {
                isLive = false;
                break;
            }

        }
    }
}
