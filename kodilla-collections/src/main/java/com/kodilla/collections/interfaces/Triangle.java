package com.kodilla.collections.interfaces;

import java.util.Objects;

public class Triangle implements Shape{
    private double width;
    private double height;
    private double hypotenuse;
    public Triangle(double width, double height, double hypotenuse) {
        this.height = height;
        this.width = width;
        this.hypotenuse = hypotenuse;
    }
    public double getArea() {
        return width * height / 2;
    }
    public double getPerimeter() {
        return width + height + hypotenuse;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "width=" + width +
                ", height=" + height +
                ", hypotenuse=" + hypotenuse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(width, triangle.width) == 0 && Double.compare(height, triangle.height) == 0 && Double.compare(hypotenuse, triangle.hypotenuse) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, hypotenuse);
    }
}
