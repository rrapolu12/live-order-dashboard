package org.ramrapolu.orders;

import org.junit.Before;
import org.junit.Test;
import org.ramrapolu.orders.summary.Summary;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OrderSummaryTest {

    private String USERNAME_1 = "user1";
    private String USERNAME_2 = "user2";
    private String USERNAME_3 = "user3";
    private String USERNAME_4 = "user4";

    private OrderSummary orderSummary;

    @Before
    public void before() {
        orderSummary = new OrderSummary();
    }

    @Test
    public void test_sellorder_summary_with_lowest_price_at_the_top() {
        Order sellOrderUser1 = new SellOrder(USERNAME_1, 3.5, 306);
        Order sellOrderUser2 = new SellOrder(USERNAME_2, 1.2, 310);
        Order sellOrderUser3 = new SellOrder(USERNAME_3, 1.5, 307);
        Order sellOrderUser4 = new SellOrder(USERNAME_4, 2.0, 306);

        List<Order> orders = Arrays.asList(sellOrderUser1, sellOrderUser2, sellOrderUser3, sellOrderUser4);
        List<Summary> listOfSummaries = orderSummary.summariseOrders(orders);
        Summary summary = listOfSummaries.get(0);
        assertEquals(306, summary.getPrice(), 0.0);
    }

    @Test
    public void test_hello_world_01(){
      assertEquals(0,0);
    }

    @Test
    public void test_buyorder_summary_with_lowest_price_at_the_top() {
        Order buyOrderUser1 = new BuyOrder(USERNAME_1, 3.5, 306);
        Order buyOrderUser2 = new BuyOrder(USERNAME_1, 1.2, 310);
        Order buyOrderUser3 = new BuyOrder(USERNAME_1, 1.5, 307);
        Order buyOrderUser4 = new BuyOrder(USERNAME_1, 2.0, 306);

        List<Order> orders = Arrays.asList(buyOrderUser1, buyOrderUser2, buyOrderUser3, buyOrderUser4);
        List<Summary> listOfSummaries = orderSummary.summariseOrders(orders);
        Summary summary = listOfSummaries.get(0);
        assertEquals(310, summary.getPrice(), 0.0);

    }

}
