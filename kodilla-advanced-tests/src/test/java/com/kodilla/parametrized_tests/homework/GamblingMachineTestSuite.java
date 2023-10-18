package com.kodilla.parametrized_tests.homework;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class GamblingMachineTestSuite {
    private final GamblingMachine gm = new GamblingMachine();
    static Stream<Set<Integer>> validUserNumbers() {
        return Stream.of(
                Set.of(5, 10, 15, 20, 25, 30),
                Set.of(1, 2, 3, 4, 5, 6)
        );
    }
    static Stream<Set<Integer>> invalidUserNumbers() {
        return Stream.of(
                Set.of(0, 10, 15, 20, 25, 26),
                Set.of(-10, 10, 15, 20, 25, 26),
                Set.of(1, 10, 15, 20, 25, 126),
                Set.of(-1, -2, -3, -4, -5, -6)
        );
    }
    static Stream<Set<Integer>> invalidSizeUserNumbers() {
        return Stream.of(
                Set.of(10, 15, 20, 25, 26),
                Set.of(10, 15, 20, 25, 26, 30, 40)
        );
    }
    @ParameterizedTest
    @MethodSource("validUserNumbers")
    public void shouldReturnCorrectNumberOfWins(Set<Integer> userNumbers) throws InvalidNumbersException {
        int wins = gm.howManyWins(userNumbers);
        assertTrue(wins >= 0 && wins <= 6);
    }
    @ParameterizedTest
    @MethodSource("invalidUserNumbers")
    public void shouldThrowExceptionForNumbersOutOfScope(Set<Integer> userNumbers) {
        assertThrows(InvalidNumbersException.class, () -> gm.howManyWins(userNumbers));
    }
    @ParameterizedTest
    @MethodSource("invalidSizeUserNumbers")
    public void shouldThrowExceptionForIncorrectSize(Set<Integer> userNumbers) {
        assertThrows(InvalidNumbersException.class, () -> gm.howManyWins(userNumbers));
    }
}
