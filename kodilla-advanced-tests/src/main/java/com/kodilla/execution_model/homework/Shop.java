package com.kodilla.execution_model.homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Shop {

    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order getOrder(double value, String login, LocalDate orderDate) {
        return orders.stream()
                .filter(order -> order.getValue() == value && order.getLogin().equals(login) && order.getOrderDate().equals(orderDate))
                .findFirst()
                .orElse(null);
    }

    public int getOrdersCount() {
        return orders.size();
    }

    public double getTotalOrdersValue() {
        double totalValue = 0;
        for (Order order : orders) {
            totalValue += order.getValue();
        }
        return totalValue;
    }

    public Set<Order> getOrdersDateRange(LocalDate startDate, LocalDate endDate) {
        return orders.stream()
                .filter(order -> order.getOrderDate().isAfter(startDate) && order.getOrderDate().isBefore(endDate))
                .collect(Collectors.toSet());
    }


    public Set<Order> getOrdersValueRange(double starValue, double endValue) {
        return orders.stream()
                .filter(order -> order.getValue() > starValue && order.getValue() < endValue)
                .collect(Collectors.toSet());
    }

    public Set<Order> getOrdersByLogin(String login) {
        return orders.stream()
                .filter(order -> order.getLogin().equals(login))
                .collect(Collectors.toSet());
    }

    public void clearOrders() {
        orders.clear();
    }
}