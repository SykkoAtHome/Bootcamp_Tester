package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.springframework.stereotype.Component;

@Component
public class DeliveryService {

    public boolean deliverPackage(String address, Double weight) {
        if (weight == null || weight > 30 || address == null || weight <= 0) {
            return false;
        }
        return true;
    }
}