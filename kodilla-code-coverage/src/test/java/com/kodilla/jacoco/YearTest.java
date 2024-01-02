package com.kodilla.jacoco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;


public class YearTest {

    @Test
    public void shouldBeLeapYearIfDivisibleBy400() {

        //given
        Year year = new Year(1600);

        //when
        boolean isLeapYear = year.isLeap();

        //then
        assertTrue(isLeapYear);
    }
}