package com.kodilla.abstracts.homework.shape;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double calcSurfaceArea() {
        return Math.PI * radius * radius;

    }
    @Override
    public double calcPeremiter() {
        return 2 * Math.PI * radius;
    }
}
