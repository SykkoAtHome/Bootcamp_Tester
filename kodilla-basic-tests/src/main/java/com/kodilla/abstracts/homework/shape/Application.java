package com.kodilla.abstracts.homework.shape;

public class Application {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);
        Triangle triangle = new Triangle(4, 3, 3, 3);


        System.out.println("Pole powierzchni okregu: " + circle.calcSurfaceArea());
        System.out.println("Pole powierzchni prostokata: " + rectangle.calcSurfaceArea());
        System.out.println("Pole powierzchni trojkata: " + triangle.calcSurfaceArea());
        System.out.println("------------------------");
        System.out.println("Obwod okregu: " + circle.calcPeremiter());
        System.out.println("Obwod prostokata: " + rectangle.calcPeremiter());
        System.out.println("Obwod trojkata: " + triangle.calcPeremiter());
    }
}