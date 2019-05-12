package org.ramrapolu.orders.dashboard;

import org.ramrapolu.orders.Order;

import java.util.*;

public class LiveOrderDashBoard {

    private Set<Order> orders = new HashSet<>();

    public void register(Order order) {
        orders.add(order);
    }

    public boolean hasRegistered(Order order){
        return orders.contains(order);
    }

    public void cancel(Order order) {
        orders.remove(order);
    }
}
