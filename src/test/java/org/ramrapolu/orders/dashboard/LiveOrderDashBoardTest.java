package org.ramrapolu.orders.dashboard;

import junitparams.JUnitParamsRunner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ramrapolu.orders.Order;
import org.ramrapolu.orders.SellOrder;
import org.ramrapolu.orders.summary.Summary;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class LiveOrderDashBoardTest {

    private static final double DECIMAL_POINT_ACCURACY = 1.0/Math.pow(10, 5);

    private LiveOrderDashBoard orderDashBoard;

    private String USERNAME_1 = "user1";
    private String USERNAME_2= "user2";
    private String USERNAME_3 = "user3";
    private String USERNAME_4 = "user4";
    private double quantity = 3.5;
    private double price = 303.0;

    private Order sellOrderUser1 = new SellOrder(USERNAME_1,3.5,306);
    private Order sellOrderUser2 = new SellOrder(USERNAME_2,1.2,310);
    private Order sellOrderUser3 = new SellOrder(USERNAME_3,1.5,307);
    private Order sellOrderUser4 = new SellOrder(USERNAME_4,2.0,306);

    private List<Order> orders;
    private List<Summary> summaries;

    @Before
    public void before(){
        orderDashBoard = new LiveOrderDashBoard();
        orderDashBoard.register(sellOrderUser1);
        orderDashBoard.register(sellOrderUser2);
        orderDashBoard.register(sellOrderUser3);
        orderDashBoard.register(sellOrderUser4);
        orders = Arrays.asList(sellOrderUser1,sellOrderUser2,sellOrderUser3,sellOrderUser4);
        summaries = orderDashBoard.orderSummaries(orders);
    }

    @Test
    public void test_hello_world(){
    	Assert.assertTrue(true);
    }
    @Test
    public void test_register_order_on_dashboard(){
        boolean registered = orderDashBoard.hasRegistered(sellOrderUser1);
        Assert.assertTrue(registered);
    }

    @Test
    public void test_cancel_order_removes_order_from_dashboard(){
        orderDashBoard.cancel(sellOrderUser1);
        Assert.assertFalse(orderDashBoard.hasRegistered(sellOrderUser1));
    }

    @Test
    public void test_sellorder_summaries_with_lowest_first(){

        Summary summary = summaries.get(0);
        assertEquals(306.0,summary.getPrice(),0.0);

    }

    @Test
    public void test_show_merge_same_price(){

        Summary summary = summaries.get(0);
        assertEquals(5.5,summary.getQuantity(),0.0);
        assertEquals(306.0,summary.getPrice(),0.0);
    }

}
