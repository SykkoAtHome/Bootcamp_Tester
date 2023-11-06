package com.kodilla.spring.basic.spring_configuration.homework;


import java.time.LocalDateTime;
import java.time.LocalTime;


public interface Car {
    boolean hasHeadlightsTurnedOn(LocalDateTime currentDateTime);
    String getCarType();
}