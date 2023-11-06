package com.kodilla.spring.basic.spring_configuration.homework;


import java.time.LocalDateTime;
import java.time.LocalTime;

public class SUV implements Car {
    @Override
    public boolean hasHeadlightsTurnedOn(LocalDateTime dateTime) {
        LocalTime sunsetTime = LocalTime.of(20, 0);
        LocalTime sunriseTime = LocalTime.of(6, 0);
        LocalTime currentTime = dateTime.toLocalTime();
        return (currentTime.isAfter(sunsetTime) || currentTime.equals(sunsetTime))
                && (currentTime.isBefore(sunriseTime) || currentTime.equals(sunriseTime));
    }

    @Override
    public String getCarType() {
        return "SUV";
    }
}