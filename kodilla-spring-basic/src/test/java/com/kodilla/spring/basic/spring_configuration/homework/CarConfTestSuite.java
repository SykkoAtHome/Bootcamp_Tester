package com.kodilla.spring.basic.spring_configuration.homework;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarConfTestSuite {
    @Test
    public void shouldUseCorrectCarTypeForAllMonths() {
        // given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_configuration.homework");
        LocalDateTime dateTime = LocalDateTime.of(2023, 1, 15, 12, 0, 0);

        String[] expectedCarToUse = {
                "SUV",
                "SUV",
                "Sedan",
                "Sedan",
                "Sedan",
                "Cabrio",
                "Cabrio",
                "Cabrio",
                "Sedan",
                "Sedan",
                "Sedan",
                "SUV"
        };

        // when
        // then
        for (int i = 0; i < 12; i++) {
            Car car = (Car) context.getBean("carToUse", dateTime);
            assertEquals(expectedCarToUse[i], car.getCarType());
            dateTime = dateTime.plusMonths(1);
        }
    }
    @Test
    public void shouldTurnOnHeadlightsAtNight() {
        // given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_configuration.homework");
        LocalDateTime dateTime = LocalDateTime.of(2023, 7, 12, 0, 0, 0);  // Inicjalizujemy na północy

        boolean[] expectedResults = {
                true,  // 00:00
                true,  // 01:00
                true,  // 02:00
                true,  // 03:00
                true,  // 04:00
                true,  // 05:00
                false,  // 06:00
                false,  // 07:00
                false,  // 08:00
                false,  // 09:00
                false,  // 10:00
                false,  // 11:00
                false,  // 12:00
                false,  // 13:00
                false,  // 14:00
                false,  // 15:00
                false,  // 16:00
                false,  // 17:00
                false,  // 18:00
                false,  // 19:00
                true,  // 20:00
                true,  // 21:00
                true,  // 22:00
                true  // 23:00
        };

        // when
        // then
        for (int i = 0; i < 24; i++) {
            Car car = (Car) context.getBean("carToUse", dateTime);
            assertEquals(expectedResults[i], car.hasHeadlightsTurnedOn(dateTime));
            //System.out.println(i);
            dateTime = dateTime.plusHours(1);
        }
    }
}