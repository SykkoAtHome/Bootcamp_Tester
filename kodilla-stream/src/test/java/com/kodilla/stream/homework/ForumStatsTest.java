package com.kodilla.stream.homework;
import com.kodilla.stream.User;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.stream.homework.ForumStats.*;
import static org.junit.jupiter.api.Assertions.*;

public class ForumStatsTest {
    @Test
    public void testGetAveragePostsOver40() {
        List<User> testUsers = new ArrayList<>();
        testUsers.add(new User("Walter White", 50, 10, "Chemists"));
        testUsers.add(new User("Jessie Pinkman", 25, 10, "Sales"));
        testUsers.add(new User("Tuco Salamanca", 34, 20, "Manager"));
        testUsers.add(new User("Gus Firing", 49, 25, "Board"));
        testUsers.add(new User("Gale Boetticher", 44, 13, "Chemists"));
        testUsers.add(new User("Mike Ehrmantraut", 57, 11, "Security"));

        double result = getAveragePostsOver40(testUsers);
        assertEquals(14.75, result);
    }
    @Test
    public void testGetAveragePostsBelow40() {
        List<User> testUsers = new ArrayList<>();
        testUsers.add(new User("Walter White", 50, 10, "Chemists"));
        testUsers.add(new User("Jessie Pinkman", 25, 10, "Sales"));
        testUsers.add(new User("Tuco Salamanca", 34, 20, "Manager"));
        testUsers.add(new User("Gus Firing", 49, 25, "Board"));
        testUsers.add(new User("Gale Boetticher", 44, 13, "Chemists"));
        testUsers.add(new User("Mike Ehrmantraut", 57, 11, "Security"));

        double result = getAveragePostsBelow40(testUsers);
        assertEquals(15.00, result);
    }

    @Test
    public void testGetAveragePostsOver40WhenEmpty() {
        List<User> emptyList = new ArrayList<>();
        Double result = getAveragePostsOver40(emptyList);
        assertNull(result);
    }
    @Test
    public void testGetAveragePostsBelow40WhenEmpty() {
        List<User> emptyList = new ArrayList<>();
        Double result = getAveragePostsBelow40(emptyList);
        assertNull(result);
    }
    @Test
    public void testGetAveragePostsOver40WhenNoUsersMeetCriteria() {
        List<User> testList = new ArrayList<>();
        testList.add(new User("Test", 30, 10, "test"));
        testList.add(new User("Test", 37, 10, "test"));
        testList.add(new User("Test", 19, 10, "test"));
        double result = getAveragePostsOver40(testList);
        assertEquals(0.0, result);
    }

    @Test
    public void testGetAveragePostsBelow40WhenNoUsersMeetCriteria() {
        List<User> testList = new ArrayList<>();
        testList.add(new User("Test", 45, 10, "test"));
        double result = getAveragePostsBelow40(testList);
        assertEquals(0.0, result);
    }
    @Test
    public void testGetAveragePostsOver40ForSingleUser() {
        List<User> singleUserList = new ArrayList<>();
        singleUserList.add(new User("Test", 45, 5, "Test"));
        double result = getAveragePostsOver40(singleUserList);
        assertEquals(5.0, result);
    }

    @Test
    public void testGetAveragePostsBelow40ForSingleUser() {
        List<User> singleUserList = new ArrayList<>();
        singleUserList.add(new User("Test", 35, 7, "Test"));
        double result = getAveragePostsBelow40(singleUserList);
        assertEquals(7.0, result);
    }
}
