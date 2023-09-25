package com.kodilla.basic_assertion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestSuite {
    @Test
    public void testSum() {
        Calculator calculator = new Calculator();
        double a = 5.9;
        double b = 4.1;
        double sumResult = calculator.sum(a, b);
        assertEquals(10, sumResult, .0001);
    }
    @Test
    public void testSub() {
        Calculator calculator = new Calculator();
        double a = 5.9;
        double b = 8.9;
        double sumResult = calculator.sub(a, b);
        assertEquals(-3, sumResult, .0001);
    }
    @Test
    public void testSquare() {
        Calculator calculator = new Calculator();
        double a = 5.4;
        double sumResult = calculator.square(a);
        assertEquals(29.16, sumResult, .0001);

        a = 0;
        sumResult = calculator.square(a);
        assertEquals(0, sumResult, .0001);

        a = -5;
        sumResult = calculator.square(a);
        assertEquals(25, sumResult, .0001);

    }
}