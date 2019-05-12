package org.ramrapolu.orders.dashboard;

import org.ramrapolu.orders.Order;
import org.ramrapolu.orders.OrderSummary;
import org.ramrapolu.orders.summary.Summary;

import java.util.*;

public class LiveOrderDashBoard {


    private Set<Order> orders = new HashSet<>();

    private OrderSummary orderSummary = new OrderSummary();

    public void register(Order order) {
        orders.add(order);
    }

    public boolean hasRegistered(Order order){
        return orders.contains(order);
    }

    public void cancel(Order order) {
        orders.remove(order);
    }

    public List<Summary> orderSummaries(List<Order> orders) {
        return orderSummary.summariseOrders(orders);
    }
}
