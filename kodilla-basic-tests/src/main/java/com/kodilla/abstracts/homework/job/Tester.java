package com.kodilla.abstracts.homework.job;

public class Tester extends Job {
    public Tester(double salary, String responsibilities) {
        super(salary, responsibilities);
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Tester's Responsibilities: " + getResponsibilities());
    }
}