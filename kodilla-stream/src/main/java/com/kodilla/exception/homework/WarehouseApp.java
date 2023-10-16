package com.kodilla.exception.homework;

public class WarehouseApp {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        warehouse.addOrder(new Order("1004"));
        warehouse.addOrder(new Order("1005"));
        warehouse.addOrder(new Order("1006"));
        warehouse.addOrder(new Order("1007"));

        try {
            Order order = warehouse.getOrder("1003");
            System.out.println(order);
        } catch (OrderDoesntExistException e) {
            System.out.println(e.getMessage());
        }
    }
}
