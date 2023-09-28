package com.kodilla.collections.interfaces.homework;

public class CarRace {
    public static void main(String[] args) {
        Ford ford = new Ford(70);
        doRace(ford);
        Opel opel  = new Opel(55);
        doRace(opel);
        Dodge dodge = new Dodge(90);
        doRace(dodge);
    }
    private static void doRace(Car car) {
        car.increaseSpeed();
        car.increaseSpeed();
        car.increaseSpeed();
        car.decreaseSpeed();
        car.decreaseSpeed();
    }
}
