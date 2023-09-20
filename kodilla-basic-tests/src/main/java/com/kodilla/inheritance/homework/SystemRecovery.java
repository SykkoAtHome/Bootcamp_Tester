package com.kodilla.inheritance.homework;

public class SystemRecovery extends OperatingSystem {
    public SystemRecovery(){

    }
    @Override
    public void turnOn() {
        System.out.println("Failed to start Operating System...");

    }

    @Override
    public void turnOff() {
        System.out.println("Starting System Recovery");
        System.out.println("Recovery Complete. Shuting down...");
    }
}
