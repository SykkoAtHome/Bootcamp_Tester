package com.kodilla.stream.homework;

import com.kodilla.stream.User;
import com.kodilla.stream.UsersRepository;

import java.util.List;

public class ForumStats {

    public static void main(String[] args) {
        List<User> users = UsersRepository.getUsersList();
        System.out.println("Average posts in group over 40: " +getAveragePostsOver40(users));
        System.out.println("Average posts in group below 40: " +getAveragePostsBelow40(users));
    }

    public static Double getAveragePostsOver40(List<User> users) {
        if (users.isEmpty()) {
            return null;
        }
        double avgPosts = users
                .stream()
                .filter(user -> user.getAge() >= 40)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0.0);

        return avgPosts;
    }
    public static Double getAveragePostsBelow40(List<User> users) {
        if (users.isEmpty()) {
            return null;
        }
        double avgposts = users
                .stream()
                .filter(user -> user.getAge() < 40)
                .mapToInt(User::getNumberOfPost)
                .average()
                .orElse(0.0);
        return avgposts;
    }
}
