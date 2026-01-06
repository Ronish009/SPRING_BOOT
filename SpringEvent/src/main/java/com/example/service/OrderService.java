package com.example.service;

import com.example.event.OrderCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ApplicationEventPublisher publisher;

    public OrderService(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

public void createOrder(String OrderId, int amount){
    System.out.println("Order Created : "+OrderId);
    publisher.publishEvent(new OrderCreatedEvent(OrderId, amount));
}
}