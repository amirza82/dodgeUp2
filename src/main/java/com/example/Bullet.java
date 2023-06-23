package com.example;

public class Bullet {
    private int r;
    private int bulletColorR;
    private int bulletColorG;
    private int bulletColorB;
    
    public Bullet(int r, int bulletColorR, int bulletColorG, int bulletColorB) {
        this.r = r;
        this.bulletColorR = bulletColorR;
        this.bulletColorG = bulletColorG;
        this.bulletColorB = bulletColorB;
    }

    public int getR() {
        return r;
    }
    public void setR(int r) {
        this.r = r;
    }
    public int getBulletColorR() {
        return bulletColorR;
    }
    public void setBulletColorR(int bulletColorR) {
        this.bulletColorR = bulletColorR;
    }
    public int getBulletColorG() {
        return bulletColorG;
    }
    public void setBulletColorG(int bulletColorG) {
        this.bulletColorG = bulletColorG;
    }
    public int getBulletColorB() {
        return bulletColorB;
    }
    public void setBulletColorB(int bulletColorB) {
        this.bulletColorB = bulletColorB;
    }

    
}
