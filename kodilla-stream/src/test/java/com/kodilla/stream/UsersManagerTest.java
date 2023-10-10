package com.kodilla.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersManagerTest {
    @Test
    public void testFilterUsersOlderThan() {
        List<User> users = UsersManager.filterUsersOlderThan(40);
        assertEquals(4, users.size()); // niby test OK...ale nie wiemy co tam jest...

        // Uzycie petli sprawdzi kazdy dodany element. I tu pytanie czy to dobra praktyka umieszczac asercje w petli ?
        for (User user : users) {
            assertTrue(user.getAge() > 40);
        }
    }

    @Test
    public void filterUsersWithNumberOfPosts() {
        List<User> users = UsersManager.filterUsersWithNumberOfPosts(100);
        assertEquals(2, users.size());

        // sytuacja jak wyzej
        for (User user : users) {
            assertTrue(user.getNumberOfPost() > 100);
        }
    }

    @Test
    public void filterChemistGroupUsernames() {
        List<String> chemists = UsersManager.filterChemistGroupUsernames();
        assertEquals(2, chemists.size());

        // Ale wygooglowalem jak porownywac dwie listy, ale...kolejnosc elementow w checkList ma znaczenie
        List<String> checkList = Arrays.asList("Walter White", "Gale Boetticher");
        assertIterableEquals(checkList, chemists);
    }
}