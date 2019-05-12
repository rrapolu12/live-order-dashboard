package org.ramrapolu.orders.dashboard;

import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ramrapolu.orders.Order;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class LiveOrderDashBoardTest {

    private static final double DECIMAL_POINT_ACCURACY = 1.0/Math.pow(10, 5);

    private LiveOrderDashBoard board;

    private String USERNAME = "testuser";
    private double quantity = 3.5;
    private double price = 303.0;

    private Order order = new Order(USERNAME,quantity,price);

    @Before
    public void before(){
        board = new LiveOrderDashBoard();
    }

    @Test
    public void test_register_order_on_dashboard(){
        board.register(order);
        boolean registered = board.hasRegistered(order);
        Assert.assertTrue(registered);
    }

}
