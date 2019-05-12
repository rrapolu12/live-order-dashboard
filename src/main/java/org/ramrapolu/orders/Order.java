package org.ramrapolu.orders;

public abstract class Order {

    private String userId;
    private double quantity;
    private double price;

    public Order(String userId, double quantity, double price) {
        this.userId = userId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public abstract OrderType orderType();
}
