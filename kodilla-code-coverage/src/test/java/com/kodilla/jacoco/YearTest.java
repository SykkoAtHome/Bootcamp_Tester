package com.kodilla.jacoco;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class YearTest {

    @ParameterizedTest
    @CsvSource({
            "1600, true",   // divisible by 400
            "2023, false",  // not divisible by 4
            "2024, true",   // divisible by 4 but not by 100
            "1900, false",  // divisible by 100 but not by 400
            "2000, true"    // divisible by 400 and not by 100
    })
    void shouldBeLeapYear(int inputYear, boolean expected) {
        // given
        Year year = new Year(inputYear);

        // when
        boolean isLeapYear = year.isLeap();

        // then
        assertEquals(expected, isLeapYear);
    }
}
