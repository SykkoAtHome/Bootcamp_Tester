package com.kodilla.collections.arrays.homework;

import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Opel;
import com.kodilla.collections.interfaces.homework.Dodge;
import com.kodilla.collections.interfaces.homework.Ford;

public class CarUtils {
    public static void describeCar(Car car) {
        System.out.println("-----------------------------");
        System.out.println("Car name: " + getCarName(car));
        System.out.println("Car speed: " + car.getSpeed());
    }
    private static String getCarName(Car car) {
        if (car instanceof Opel)
            return "Opel";
        else if (car instanceof Dodge)
            return "Dodge";
        else if (car instanceof Ford)
            return "Ford";
        else
            return "Unknown car Name";
    }
}
