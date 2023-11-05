package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
    @Autowired
    private Display display;

    public Double add(Double a, Double b) {
        if (a == null || b == null) {
            return null;
        }
        double result = a+b;
        display.display(result);
        return result;
    }
    public Double subtract(Double a, Double b) {
        if (a == null || b == null) {
            return null;
        }
        double result = a-b;
        display.display(a-b);
        return result;
    }
    public Double multiply(Double a, Double b) {
        if (a == null || b == null) {
            return null;
        }
        double result = a*b;
        display.display(result);
        return result;
    }
    public Double divide(Double a, Double b) {
        if (a == null || b == null) {
            return null;
        }
        double result = a/b;
        display.display(result);
        return result;
    }
}
