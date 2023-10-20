package com.kodilla.execution_model.homework;

import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private double value;
    private String login;
    private LocalDate orderDate;

    public Order(double value, String login, LocalDate orderDate) {
        this.value = value;
        this.login = login;
        this.orderDate = orderDate;
    }

    public double getValue() {
        return value;
    }

    public String getLogin() {
        return login;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order value " + value + " ordered by " + login + " on " + orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(value, order.value) == 0 && Objects.equals(login, order.login) && Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, login, orderDate);
    }
}
