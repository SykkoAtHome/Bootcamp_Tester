package com.kodilla.parametrized_tests.homework;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
public class GamblingMachineTestSuite {
    private final GamblingMachine gm = new GamblingMachine();
    @Test
    public void shouldReturnCorrectNumberOfWins() throws InvalidNumbersException {
        Set<Integer> userNumbers = new HashSet<>();
        userNumbers.add(1);
        userNumbers.add(2);
        userNumbers.add(3);
        userNumbers.add(4);
        userNumbers.add(5);
        userNumbers.add(6);
        int wins = gm.howManyWins(userNumbers);
        assertTrue(wins >= 0 && wins <= 6);
    }
    @Test
    public void shouldThrowExceptionForNumbersOutOfScope() {
        Set<Integer> userNumbers = new HashSet<>();
        userNumbers.add(0);
        userNumbers.add(2);
        userNumbers.add(3);
        userNumbers.add(4);
        userNumbers.add(5);
        userNumbers.add(100);
        assertThrows(InvalidNumbersException.class, () -> gm.howManyWins(userNumbers));
    }
    @Test
    public void shouldThrowExceptionForIncorrectSize() {
        Set<Integer> userNumbers = new HashSet<>();
        userNumbers.add(5);
        userNumbers.add(10);
        userNumbers.add(15);
        userNumbers.add(20);
        userNumbers.add(25);
        assertThrows(InvalidNumbersException.class, () -> gm.howManyWins(userNumbers));
    }
}
