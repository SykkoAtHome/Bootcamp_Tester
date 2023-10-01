package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Opel;
import com.kodilla.collections.interfaces.homework.Dodge;
import com.kodilla.collections.interfaces.homework.Ford;

import java.util.Random;

public class CarsApplication {
    private static final Random RANDOM = new Random();

    public static Car drawCar() {
        int drawCarKind = RANDOM.nextInt(3);
        int velocity = getRandomVelocity();
        if (drawCarKind == 0)
            return new Dodge(velocity);
        else if (drawCarKind == 1)
            return new Ford(velocity);
        else
            return new Opel(velocity);
    }

    public static void main(String[] args) {
        Car[] cars = new Car[RANDOM.nextInt(15) + 1];
        for (int n = 0; n < cars.length; n++)
            cars[n] = drawCar();
        for (Car car : cars)
            CarUtils.describeCar(car);
    }
    private static int getRandomVelocity() {
        return RANDOM.nextInt(50)+1;
    }
}
