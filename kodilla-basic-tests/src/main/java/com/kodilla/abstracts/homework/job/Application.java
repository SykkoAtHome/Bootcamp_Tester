package com.kodilla.abstracts.homework.job;

public class Application {
    public static void main(String[] args) {
        Job driver = new Driver(5000, "Driving a car");
        Job tester = new Tester(10000, "Bug hunter");
        Job salesman = new Salesman(5670, "Simply sales");

        Person adam = new Person("Adam", 25, driver);
        Person ewa = new Person("Ewa", 20, driver);
        Person kasia = new Person("Kasia", 34, tester);
        Person zosia = new Person("Zosia", 44, salesman);
        Person piotr = new Person("Piotr", 38, tester);

        System.out.println("-----------------");
        adam.displayPersonDetails();
        System.out.println("-----------------");
        ewa.displayPersonDetails();
        System.out.println("-----------------");
        kasia.displayPersonDetails();
        System.out.println("-----------------");
        zosia.displayPersonDetails();
        System.out.println("-----------------");
        piotr.displayPersonDetails();
        System.out.println("-----------------");
    }
}
