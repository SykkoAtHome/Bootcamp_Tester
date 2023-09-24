package com.kodilla.basic_assertion;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 8;
        int sumResult = calculator.sum(a, b);
        int subResult = calculator.sub(a, b);
        int squareResult = calculator.square(a);
        boolean correct = ResultChecker.assertEquals(13, sumResult);
        if (correct) {
            System.out.println("Metoda sum działa poprawnie dla liczb " + a + " i " + b);
        } else {
            System.out.println("Metoda sum nie działa poprawnie dla liczb " + a + " i " + b);
        }

        correct = ResultChecker.assertEquals(-3, subResult);

        if (correct) {
            System.out.println("Metoda sub działa poprawnie dla liczb " + a + " i " + b);
        } else {
            System.out.println("Metoda sub nie działa poprawnie dla liczb " + a + " i " + b);
        }

        correct = ResultChecker.assertEquals(25, squareResult);

        if (correct) {
            System.out.println("Metoda square działa poprawnie dla liczb " + a);
        } else {
            System.out.println("Metoda square nie działa poprawnie dla liczb " + a);
        }
    }
}