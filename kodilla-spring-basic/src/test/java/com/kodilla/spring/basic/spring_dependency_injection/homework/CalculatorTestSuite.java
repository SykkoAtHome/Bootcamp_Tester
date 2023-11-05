package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CalculatorTestSuite {
    private Calculator calculator;
    @BeforeEach
    public void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic.spring_dependency_injection.homework");
        calculator = context.getBean(Calculator.class);
    }
    @Test
    public void testAdd() {
        assertEquals(8.0, calculator.add(5.0, 3.0), 0.01);
    }
    @Test
    public void testSubtract() {
        assertEquals(2.0, calculator.subtract(5.0, 3.0), 0.01);
    }
    @Test
    public void testMultiply() {
        assertEquals(15.0, calculator.multiply(5.0, 3.0), 0.01);
    }
    @Test
    public void testDivide() {
        assertEquals(5.0, calculator.divide(15.0, 3.0), 0.01);
    }
    @Test
    public void testAddWithNull() {
        Double resultA = calculator.add(5.0, null);
        Double resultB = calculator.add(null, 10.2);
        assertNull(resultA);
        assertNull(resultB);
    }
    @Test
    public void testSubtractWithNull() {
        Double resultA = calculator.subtract(5.0, null);
        Double resultB = calculator.subtract(null, 10.2);
        assertNull(resultA);
        assertNull(resultB);
    }
    @Test
    public void testMultiplyWithNull() {
        Double resultA = calculator.multiply(5.0, null);
        Double resultB = calculator.multiply(null, 10.2);
        assertNull(resultA);
        assertNull(resultB);
    }
    @Test
    public void testDivideWithNull() {
        Double resultA = calculator.divide(5.0, null);
        Double resultB = calculator.divide(null, 10.2);
        assertNull(resultA);
        assertNull(resultB);
    }
}