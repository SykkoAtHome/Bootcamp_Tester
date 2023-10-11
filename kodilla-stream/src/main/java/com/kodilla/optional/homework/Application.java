package com.kodilla.optional.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Application {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        Teacher nowak = new Teacher("Nowak");
        Teacher kowalski = new Teacher("Kowalski");

        studentList.add(new Student("Henio", nowak));
        studentList.add(new Student("Marysia", nowak));
        studentList.add(new Student("Jasio", null));
        studentList.add(new Student("Reksio", null));
        studentList.add(new Student("Pysio", kowalski));
        studentList.add(new Student("Zbysio", kowalski));

        for (Student student : studentList) {
            Optional<Teacher> optionalTeacher = Optional.ofNullable(student.getTeacher());

            String teacherName = optionalTeacher
                    .map(Teacher::getName)
                    .orElse("<undefined>");

            System.out.println("Student: " +student.getName() + " Teacher: " +teacherName);
        }
    }
}