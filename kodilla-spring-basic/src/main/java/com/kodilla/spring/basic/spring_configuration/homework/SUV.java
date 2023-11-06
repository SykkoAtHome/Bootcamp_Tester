package com.kodilla.spring.basic.spring_configuration.homework;


import java.time.LocalDateTime;
import java.time.LocalTime;

public class SUV implements Car {
    @Override
    public boolean hasHeadlightsTurnedOn(LocalDateTime dateTime) {
        int hour = dateTime.getHour();
        return hour < 6 || hour >= 20;
    }

    @Override
    public String getCarType() {
        return "SUV";
    }
}