package org.ramrapolu.orders;

import org.junit.Before;
import org.junit.Test;
import org.ramrapolu.orders.Order;

import static org.junit.Assert.*;

public class OrderTest {

    private Order order;

    private String USERNAME = "testuser";
    private double quantity = 3.5;
    private double price = 303.0;

    @Before
    public void before(){
        order = new SellOrder(USERNAME,quantity,price);
    }

    @Test
    public void test_username(){
        assertEquals(USERNAME,order.getUserId());
    }

    @Test
    public void test_quantity(){
        assertEquals(quantity,order.getQuantity(),0.0);
    }

    @Test
    public void test_price(){
        assertEquals(price,order.getPrice(),0.0);
    }

}
