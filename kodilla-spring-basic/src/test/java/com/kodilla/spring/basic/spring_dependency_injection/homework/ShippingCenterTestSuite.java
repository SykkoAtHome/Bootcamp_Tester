package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShippingCenterTestSuite {
    @Autowired
    private ShippingCenter shippingCenter;

    @Test
    public void testSendingPackageSuccessfulDelivery() {
        String address = "Ulica Testowa 10";
        double weight = 10.0;
        String result = shippingCenter.sendPackage(address, weight);
        Assertions.assertTrue(result.contains("Package delivered"));
    }

    @Test
    public void testSendingPackageFailedDelivery() {
        String address = "Ulica Testowa 20";
        double weight = 35.0;
        String result = shippingCenter.sendPackage(address, weight);
        Assertions.assertTrue(result.contains("Package not delivered"));
    }

    @Test
    public void testSendingPackageNullAddress() {
        double weight = 5.0;
        String result = shippingCenter.sendPackage(null, weight);
        Assertions.assertTrue(result.contains("Package not delivered"));
    }

    @Test
    public void testSendingPackageZeroWeight() {
        String address = "Ulica Testowa 11";
        double weight = 0.0;
        String result = shippingCenter.sendPackage(address, weight);
        Assertions.assertTrue(result.contains("Package not delivered"));
    }

    @Test
    public void testSendingPackageNegativeWeight() {
        String address = "Ulica Testowa 11";
        double weight = -10.4;
        String result = shippingCenter.sendPackage(address, weight);
        Assertions.assertTrue(result.contains("Package not delivered"));
    }
    @Test
    public void testSendingPackageNullWeight() {
        String address = "Ulica Testowa 11";
        String result = shippingCenter.sendPackage(address, null);
        Assertions.assertTrue(result.contains("Package not delivered"));
    }
}