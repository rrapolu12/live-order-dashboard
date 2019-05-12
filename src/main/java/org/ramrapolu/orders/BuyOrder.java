package org.ramrapolu.orders;

public class BuyOrder extends Order {

    public BuyOrder(String userId, double quantity, double price) {
        super(userId, quantity, price);
    }

    @Override
    public OrderType orderType() {
        return OrderType.BUY;
    }

}
