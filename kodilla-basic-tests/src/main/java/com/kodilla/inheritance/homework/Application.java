package com.kodilla.inheritance.homework;

public class Application {
    public static void main(String[] args) {
        OperatingSystem windows = new OperatingSystem();
        windows.turnOn();
        System.out.println("Windows98 Millennium Edition");
        System.out.println("Fatal Error !!!");
        windows.turnOff();

        System.out.println("-------------------------");

        SystemUpdate windowsUpdate = new SystemUpdate();
        windowsUpdate.turnOn();
        System.out.println("Windows98 Millennium Edition");
        windowsUpdate.turnOff();

        System.out.println("-------------------------");

        SystemRecovery recovery = new SystemRecovery();
        recovery.turnOn();
        System.out.println("Windows98 Millennium Edition - Recovery Mode");
        recovery.turnOff();
    }


}
