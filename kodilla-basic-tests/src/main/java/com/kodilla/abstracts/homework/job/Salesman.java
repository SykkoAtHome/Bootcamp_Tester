package com.kodilla.abstracts.homework.job;

public class Salesman extends Job {
    public Salesman(double salary, String responsibilities) {
        super(salary, responsibilities);
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Salesman's Responsibilities: " + getResponsibilities());
    }
}