package com.kodilla.abstracts.homework.shape;

public class Rectangle extends Shape {
    private double a;
    private double b;
    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public double calcSurfaceArea() {
        return a*b;
    }

    @Override
    public double calcPeremiter() {
        return 2 * (a + b);
    }
}