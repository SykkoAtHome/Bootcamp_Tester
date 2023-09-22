package com.kodilla.abstracts.homework.job;

public class Person {
    private String firstName;
    private int age;
    private Job job;

    public Person(String firstName, int age, Job job) {
        this.firstName = firstName;
        this.age = age;
        this.job = job;
    }
    public void displayPersonDetails() {
        System.out.println("Name: " + firstName);
        System.out.println("Age: " + age);
        System.out.println("Job Details:");
        job.displayJobDetails();
    }
}
