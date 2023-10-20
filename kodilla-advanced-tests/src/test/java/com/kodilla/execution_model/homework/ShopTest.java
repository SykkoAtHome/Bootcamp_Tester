package com.kodilla.execution_model.homework;

import java.time.LocalDate;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShopTest {
    Shop shop = new Shop();

    @Test
    public void testGetOrdersCount() {
        assertEquals(10, shop.getOrdersCount());
    }

    @Test
    public void shouldReturnZeroWhenEmptyList() {
        shop.clearOrders();
        assertEquals(0, shop.getOrdersCount());
    }

    @Test
    public void testAddOrder() {
        assertNotNull(shop.getOrder(67.45, "user2", LocalDate.of(2023, 8, 11)));
    }

    @Test
    public void testClearOrders() {
        shop.clearOrders();
        assertEquals(0, shop.getOrdersCount());
    }

    @Test
    public void shouldReturnNullWhenOrderNotFound() {
        assertNull(shop.getOrder(7.45, "user2", LocalDate.of(2023, 8, 11)));
    }

    @Test
    public void testGetOrdersDateRange() {
        LocalDate startDate = LocalDate.of(2023, 8, 1);
        LocalDate endDate = LocalDate.of(2023, 8, 31);
        assertEquals(5, shop.getOrdersDateRange(startDate, endDate).size());
    }

    @Test
    public void shouldReturnEmptyWhenDatesOutOfRange() {
        LocalDate startDate = LocalDate.of(2023, 2, 1);
        LocalDate endDate = LocalDate.of(2023, 2, 21);
        assertTrue(shop.getOrdersDateRange(startDate, endDate).isEmpty());
    }

    @Test
    public void testGetOrdersValueRange() {
        assertEquals(3, shop.getOrdersValueRange(50, 100).size());
    }

    @Test
    public void shouldReturnEmptyWhenValuesOutOfRange() {
        assertTrue(shop.getOrdersValueRange(2300, 3000).isEmpty());
    }

    @Test
    public void testGetTotalOrdersValue() {
        assertEquals(691.62, shop.getTotalOrdersValue(), 0.001);
    }

    // Bonus
    @Test
    public void testGetOrdersByLogin() {
        assertEquals(4, shop.getOrdersByLogin("user2").size());
    }

    @Test
    public void shouldReturnEmptyWhenUserNotFound() {
        assertTrue(shop.getOrdersByLogin("test").isEmpty());
    }


    @BeforeEach
    public void initializeShop() {
        shop.addOrder(new Order(100.0, "user1", LocalDate.of(2023, 9, 4)));
        shop.addOrder(new Order(150.0, "user2", LocalDate.of(2023, 9, 4)));
        shop.addOrder(new Order(40.50, "user3", LocalDate.of(2023, 9, 11)));
        shop.addOrder(new Order(128.12, "user2", LocalDate.of(2023, 9, 23)));
        shop.addOrder(new Order(39.10, "user3", LocalDate.of(2023, 9, 19)));
        shop.addOrder(new Order(67.45, "user2", LocalDate.of(2023, 8, 11)));
        shop.addOrder(new Order(99.99, "user1", LocalDate.of(2023, 8, 27)));
        shop.addOrder(new Order(8.60, "user1", LocalDate.of(2023, 8, 3)));
        shop.addOrder(new Order(1.56, "user2", LocalDate.of(2023, 8, 8)));
        shop.addOrder(new Order(56.30, "user3", LocalDate.of(2023, 8, 7)));
    }

    @AfterEach
    public void cleanUp() {
        shop.clearOrders();
    }
}