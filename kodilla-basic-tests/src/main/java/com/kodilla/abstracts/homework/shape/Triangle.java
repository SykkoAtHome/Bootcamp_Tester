package com.kodilla.abstracts.homework.shape;

public class Triangle extends Shape {
    private double h;
    private double a;
    private double b;
    private double c;

    public Triangle(double h, double a, double b, double c) {
        this.h = h;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double calcSurfaceArea() {
        return 0.5 * a * h;
    }

    @Override
    public double calcPeremiter() {
        return a + b + c;
    }
}
