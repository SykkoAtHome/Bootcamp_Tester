package com.kodilla.stream;

import java.util.List;
import java.util.stream.Collectors;

public class UsersManager {
    public static void main(String[] args) {
        List<String> chemistGroupUsernames = filterChemistGroupUsernames();
        System.out.println(chemistGroupUsernames);
    }

    static List<String> filterChemistGroupUsernames() {
        List<String> usernames = UsersRepository.getUsersList()   // [1]
                .stream()
                .filter(user -> user.getGroup().equals("Chemists"))
                .map(User::getUsername)
                .collect(Collectors.toList());                      // [2]

        return usernames;
    }
    static List<User> filterUsersOlderThan(int age) {
        List<User> users = UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
        return users;
    }
    static List<User> filterUsersWithNumberOfPosts(int postCount) {
        List<User> users = UsersRepository.getUsersList()
                .stream()
                .filter(user -> user.getNumberOfPost() > postCount)
                .collect(Collectors.toList());
        return users;
    }
}