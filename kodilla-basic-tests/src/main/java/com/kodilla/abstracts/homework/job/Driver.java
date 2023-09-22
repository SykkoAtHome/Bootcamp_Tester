package com.kodilla.abstracts.homework.job;

public class Driver extends Job {
    public Driver(double salary, String responsibilities) {
        super(salary, responsibilities);
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Driver's Responsibilities: " + getResponsibilities());
    }
}