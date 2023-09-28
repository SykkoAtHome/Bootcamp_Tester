package com.kodilla.collections.interfaces.homework;

public class Ford implements Car{
    private int speed;
    public Ford(int speed) {
        this.speed = speed;
    }
    @Override
    public int getSpeed() {
        return this.speed;
    }
    @Override
    public void increaseSpeed() {
        this.speed += 12;
    }
    @Override
    public void decreaseSpeed() {
        this.speed -= 8;
    }
}
