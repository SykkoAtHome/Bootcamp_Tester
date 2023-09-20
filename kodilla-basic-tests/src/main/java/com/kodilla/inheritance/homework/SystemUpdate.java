package com.kodilla.inheritance.homework;

public class SystemUpdate extends OperatingSystem {
    public SystemUpdate(){

    }
    @Override
    public void turnOn() {
        System.out.println("Starting Operating System...");
        System.out.println("Checking for updates");
    }

    @Override
    public void turnOff() {
        System.out.println("Updating Operating System...");
        System.out.println("Update Complete. Shuting down...");
    }
}
