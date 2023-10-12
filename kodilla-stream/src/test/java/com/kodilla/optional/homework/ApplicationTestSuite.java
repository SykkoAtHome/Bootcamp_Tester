package com.kodilla.optional.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.optional.homework.Application.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplicationTestSuite {
    @Test
    public void testGetStudentName() {
        Teacher nowak = new Teacher("Nowak");
        Student student = new Student("Jasio", nowak);

        assertEquals("Jasio", student.getName());
    }
    @Test
    public void testGetTeacherName() {
        Teacher nowak = new Teacher("Nowak");

        assertEquals("Nowak", nowak.getName());
    }
    @Test
    public void testReturnNullWhenTeacherNull() {
        Student student = new Student("Jasio", null);
        Teacher teacher = student.getTeacher();
        assertEquals(null, teacher);
    }

    @Test
    public void testListOfStudents() {
        List<Student> studentList = new ArrayList<>();

        Teacher nowak = new Teacher("Nowak");
        Teacher kowalski = new Teacher("Kowalski");

        studentList.add(new Student("Henio", nowak));
        studentList.add(new Student("Marysia", nowak));
        studentList.add(new Student("Jasio", null));
        studentList.add(new Student("Reksio", null));
        studentList.add(new Student("Pysio", kowalski));
        studentList.add(new Student("Zbysio", kowalski));

        assertEquals(6, studentList.size());
    }

    @Test
    public void testReturnAlternativeNameWhenNull() {
        Student testStudent = new Student("test", null);
        String teacherName = getTeacherNameOrAlternative(testStudent);

        assertEquals("<undefined>", teacherName);
    }
    @Test
    public void testReturnTeacherName() {
        Teacher testTeacher = new Teacher("Teacher");
        Student testStudent = new Student("test", testTeacher);
        String teacherName = getTeacherNameOrAlternative(testStudent);

        assertEquals("Teacher", teacherName);
    }
}
