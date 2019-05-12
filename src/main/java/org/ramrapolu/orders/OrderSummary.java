package org.ramrapolu.orders;

import org.ramrapolu.orders.summary.Summary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderSummary {

    private Function<List<Order>, Stream<Order>> buyOrder = orders -> {
        return orders.stream().filter(order -> order.orderType().equals(OrderType.BUY));
    };

    private Function<List<Order>, Stream<Order>> sellOrder = orders -> {
        return orders.stream().filter(order -> order.orderType().equals(OrderType.SELL));
    };

    public List<Summary> summariseOrders(List<Order> orders) {

        Comparator<Double> descendingPriceFunction = (price1, price2) -> (int) (price2 - price1);
        Comparator<Double> ascendingPriceFunction = (price1, price2) -> (int) (price1 - price2);

        List<Summary> orderSummaries = new ArrayList();
        orderSummaries.addAll(summaryBuyOrders(orders, descendingPriceFunction));
        orderSummaries.addAll(summarySellOrders(orders, ascendingPriceFunction));
        return orderSummaries;
    }

    private List<Summary> summaryBuyOrders(List<Order> orders, Comparator<Double> descendingPriceComparator) {
        return getSummaries(buyOrder.apply(orders), descendingPriceComparator);
    }

    private List<Summary> summarySellOrders(List<Order> orders, Comparator<Double> ascendingPriceComparator) {
        return getSummaries(sellOrder.apply(orders), ascendingPriceComparator);
    }

    private List<Summary> getSummaries(Stream<Order> orders, Comparator<Double> priceComparator) {
        Stream<Summary> summaries = groupSummariesByPrice(orders);
        Stream<Summary> sorted = summaries.sorted((summary1, summary2) -> priceComparator.compare(summary1.getPrice(), summary2.getPrice()));
        return sorted.collect(Collectors.toList());
    }

    private Stream<Summary> groupSummariesByPrice(Stream<Order> orders) {
        return orders.collect(Collectors.groupingBy(Order::getPrice)).values().stream().map(Summary::new);
    }
}
