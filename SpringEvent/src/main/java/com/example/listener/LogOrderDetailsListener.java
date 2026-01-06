package com.example.listener;

import com.example.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LogOrderDetailsListener {

    @EventListener
    //@Order(value = 1)
    @Async
    public void logOrderCreated(OrderCreatedEvent event) throws InterruptedException {
        System.out.println("Order Placed For Order Id: " + event.getOrderId());
        Thread.sleep(1000);
        System.out.println("logOrderCreated"+event.getOrderId());
    }
}
