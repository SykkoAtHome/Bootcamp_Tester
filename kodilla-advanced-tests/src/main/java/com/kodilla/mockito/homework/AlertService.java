package com.kodilla.mockito.homework;


import java.util.*;

public class AlertService {
    private Map<Location, Set<User>> subscriptions = new HashMap<>();
    private Set<User> allUsers = new HashSet<>();

    public void subscribeToLocation(User user, Location location) {
        if (user == null || location == null) {
            throw new IllegalArgumentException("Error: User or/and Location is null");
        }
        subscriptions.putIfAbsent(location, new HashSet<>());
        subscriptions.get(location).add(user);
        addUser(user);
    }

    public void sendAlert(Location location, String alert) {
        Set<User> users = subscriptions.get(location);
        if (users != null) {
            for (User user : users) {
                user.receive(new Alert(alert));
            }
        }
    }

    public void unsubscribeFromLocation(User user, Location location) {
        if (user == null || location == null) {
            throw new IllegalArgumentException("User and Location cannot be null");
        }
        if (!subscriptions.containsKey(location)) {
            throw new IllegalArgumentException("Location not found");
        }
        Set<User> users = subscriptions.get(location);
        if (users == null) {
            return;
        }
        if (!users.contains(user)) {
            return;
        }
        users.remove(user);
        subscriptions.put(location, users);
    }

    public void unsubscribeFromAllLocations(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        for (Location location : subscriptions.keySet()) {
            unsubscribeFromLocation(user, location);
        }
    }

    public void sendAlertToAll(String alert) {
        Set<User> uniqueSubscribers = new HashSet<>(allUsers);
        for (Location location : subscriptions.keySet()) {
            uniqueSubscribers.addAll(subscriptions.get(location));
        }
        for (User user : uniqueSubscribers) {
            user.receive(new Alert(alert));
        }
    }

    public void deleteLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }
        subscriptions.remove(location);
    }

    public void addUser(User user) {
        if (!allUsers.contains(user)) {
            allUsers.add(user);
        }
    }
    public void clearAllData() {
        subscriptions.clear();
    }
}


