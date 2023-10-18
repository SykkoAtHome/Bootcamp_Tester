package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

public class PersonTestSuiteSuite {

    private static Stream<Arguments> bmiValues() {
        return Stream.of(
                Arguments.of(1.70, 50, "Underweight"),
                Arguments.of(1.70, 54, "Normal (healthy weight)"),
                Arguments.of(1.70, 58, "Normal (healthy weight)"),
                Arguments.of(1.70, 68, "Normal (healthy weight)"),
                Arguments.of(1.70, 75, "Overweight"),
                Arguments.of(1.70, 85, "Overweight"),
                Arguments.of(1.70, 95, "Obese Class I (Moderately obese)"),
                Arguments.of(1.70, 105, "Obese Class II (Severely obese)"),
                Arguments.of(1.70, 115, "Obese Class II (Severely obese)"),
                Arguments.of(1.70, 130, "Obese Class III (Very severely obese)"),
                Arguments.of(1.70, 150, "Obese Class V (Super Obese)")
        );
    }
    @ParameterizedTest
    @MethodSource("bmiValues")
    public void shouldReturnCorrectBMIStatus(double height, double weight, String expectedStatus) {
        Person person = new Person(height, weight);
        String bmiStatus = person.getBMI();
        assertEquals(expectedStatus, bmiStatus);
    }
}