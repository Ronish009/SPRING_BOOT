package com.example.event;

public class OrderCreatedEvent {
    private final String orderId;
    private final int amount;

    public OrderCreatedEvent(String orderId,int amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getAmount() {
        return amount;
    }
}