package com.kodilla.exception.homework;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTestSuite {
    @Test
    public void testGetOrder_withException() {
        // given
        Warehouse warehouse = new Warehouse();
        warehouse.addOrder(new Order("1000"));
        // when

        // then
        assertThrows(OrderDoesntExistException.class, () -> warehouse.getOrder("666"));
    }

}