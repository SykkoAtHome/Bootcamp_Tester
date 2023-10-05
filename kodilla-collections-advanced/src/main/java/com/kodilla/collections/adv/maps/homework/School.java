package com.kodilla.collections.adv.maps.homework;

import java.util.HashMap;
import java.util.Map;

public class School {
    private String schoolName;
    private Map<String, Integer> classes;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.classes = new HashMap<>();
    }

    public String getSchoolName() {
        return schoolName;
    }
    public void createClass(String className, int numberOfStudents) {
        this.classes.put(className, numberOfStudents);
    }

    public Map<String, Integer> getClasses() {
        return classes;
    }
    public int getTotalStudents() {
        int totalStudents = 0;
        for (Integer numberOfStudents : classes.values()) {
            totalStudents += numberOfStudents;
        }
        return totalStudents;
    }
    @Override
    public String toString() {
        return "School{" +
                "classes=" + classes +
                '}';
    }
}
