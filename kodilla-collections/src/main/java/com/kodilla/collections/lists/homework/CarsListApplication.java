package com.kodilla.collections.lists.homework;

import com.kodilla.collections.arrays.homework.CarUtils;
import com.kodilla.collections.interfaces.homework.Car;
import com.kodilla.collections.interfaces.homework.Dodge;
import com.kodilla.collections.interfaces.homework.Ford;
import com.kodilla.collections.interfaces.homework.Opel;

import java.util.ArrayList;
import java.util.List;

public class CarsListApplication {
    public static void main(String[] args) {
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Ford(50));
        carsList.add(new Opel(60));
        carsList.add(new Dodge(90));

        Car tempCar = new Opel(100);
        carsList.add(tempCar);

        for (Car car : carsList) {
            CarUtils.describeCar(car);
        }

        System.out.println("************************");

        carsList.remove(0);
        carsList.remove(tempCar);

        for (Car car : carsList) {
            CarUtils.describeCar(car);
        }
    }
}
