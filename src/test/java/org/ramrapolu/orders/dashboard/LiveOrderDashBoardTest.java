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
    private String USERNAME_1 = "testuser";
    private double quantity = 3.5;
    private double price = 303.0;



    @Before
    public void before(){
        board = new LiveOrderDashBoard();
    }

    @Test
    public void test_register_order_on_dashboard(){
        Order order = new Order(USERNAME,quantity,price);
        board.register(order);
        boolean registered = board.hasRegistered(order);
        Assert.assertTrue(registered);
    }

    @Test
    public void test_cancel_order(){
        Order order = new Order(USERNAME,quantity,price);
        Order order_to_ve_canceled = new Order(USERNAME_1,quantity,price);
        board.register(order);
        board.register(order_to_ve_canceled);
        boolean registered = board.hasRegistered(order);
        boolean registered1 = board.hasRegistered(order_to_ve_canceled);
        Assert.assertTrue(registered);
        Assert.assertTrue(registered1);
        board.cancel(order_to_ve_canceled);
        boolean registered_0 = board.hasRegistered(order);
        boolean canceled_order = board.hasRegistered(order_to_ve_canceled);
        Assert.assertTrue(registered_0);
        Assert.assertFalse(canceled_order);
    }

}
