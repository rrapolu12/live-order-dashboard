package org.ramrapolu.orders;

public class SellOrder extends Order {

    public SellOrder(String userId, double quantity, double price) {
        super(userId, quantity, price);
    }

    @Override
    public OrderType orderType() {
        return OrderType.SELL;
    }

}
