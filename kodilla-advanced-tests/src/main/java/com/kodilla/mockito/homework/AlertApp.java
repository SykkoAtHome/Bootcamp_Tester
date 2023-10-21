package com.kodilla.mockito.homework;

public class AlertApp {
    public static void main(String[] args) {
        AlertService alertService = new AlertService();
        alertService.unsubscribeFromLocation(null, null);
    }
}
