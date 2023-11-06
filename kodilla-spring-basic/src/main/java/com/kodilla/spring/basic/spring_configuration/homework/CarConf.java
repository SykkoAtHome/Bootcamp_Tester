package com.kodilla.spring.basic.spring_configuration.homework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
public class CarConf {

    @Bean
    @Scope("prototype")
    public Car carToUse(LocalDateTime dateTime) {
        Car car;
        int month = dateTime.getMonthValue();
        if (month >= 3 && month <= 5) {
            return car = new Sedan();
        } else if (month >= 6 && month <= 8) {
            return car = new Cabrio();
        } else if (month >= 9 && month <= 11) {
            return car = new Sedan();
        } else {
            return car = new SUV();
        }
    }
}
