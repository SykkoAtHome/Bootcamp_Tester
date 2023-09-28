package com.kodilla.collections.interfaces.homework;

public class Dodge implements Car{
    private int speed;
    public Dodge(int speed) {
        this.speed = speed;
    }
    @Override
    public int getSpeed() {
        return this.speed;
    }
    @Override
    public void increaseSpeed() {
        this.speed += 19;
    }
    @Override
    public void decreaseSpeed() {
        this.speed -= 8;
    }
}