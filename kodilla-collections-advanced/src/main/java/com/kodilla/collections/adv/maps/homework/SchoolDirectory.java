package com.kodilla.collections.adv.maps.homework;

import java.util.HashMap;
import java.util.Map;

public class SchoolDirectory {
    public static void main(String[] args) {
        Map<Principal, School> schoolsPrincipals = new HashMap<>();

        Principal kowalski = new Principal("Jan", "Kowalski");
        Principal malina = new Principal("Krystyna", "Malina");
        Principal nowak = new Principal("Adam", "Nowak");

        School sp333 = new School("SP-333");
        School lo20 = new School("LO-20");
        School tech12 = new School("Tech-12");

        schoolsPrincipals.put(kowalski, sp333);
        schoolsPrincipals.put(malina, lo20);
        schoolsPrincipals.put(nowak, tech12);

        sp333.createClass("1A", 33);
        sp333.createClass("4B", 23);
        sp333.createClass("2A", 31);
        sp333.createClass("7C", 17);
        sp333.createClass("6D", 19);

        lo20.createClass("1A", 22);
        lo20.createClass("1B", 27);
        lo20.createClass("2C", 31);
        lo20.createClass("3A", 19);
        lo20.createClass("4D", 18);

        tech12.createClass("1A", 32);
        tech12.createClass("1B", 12);
        tech12.createClass("1C", 13);
        tech12.createClass("3B", 24);
        tech12.createClass("2A", 30);

        for (Map.Entry<Principal, School> entry : schoolsPrincipals.entrySet()) {

            Principal principal = entry.getKey();
            School school = entry.getValue();

            System.out.println("School: " + school.getSchoolName());
            System.out.println("Principal: " + principal.getFirstName() + " " + principal.getLastname());
            System.out.println("Total Students: " + school.getTotalStudents());
            System.out.println("----------");
        }
    }
}
