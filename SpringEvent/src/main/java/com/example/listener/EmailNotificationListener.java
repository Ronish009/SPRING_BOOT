package com.example.listener;

import com.example.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component

public class EmailNotificationListener {

    @EventListener
    //@Order(value = 2)
    @Async
    public void handleOrderCreatedAndSendEmail(OrderCreatedEvent event) throws InterruptedException {
        System.out.println("Sending email for Order: "+event.getOrderId());
        Thread.sleep(3000);
        System.out.println("Email Sent for Order: "+event.getOrderId());

    }
}
