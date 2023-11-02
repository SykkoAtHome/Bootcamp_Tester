package com.kodilla.spring.basic.dependency_injection.homework;

public class Application {

    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryDHL();
        NotificationService notificationService = new Notification();
        ShippingCenter shippingCenter = new ShippingCenter(deliveryService, notificationService);
        shippingCenter.sendPackage("Hill Street 11, New York", 19);
        shippingCenter.sendPackage("Lotnisko, Radom", 40);
    }
}