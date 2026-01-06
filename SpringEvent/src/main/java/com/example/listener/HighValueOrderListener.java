package com.example.listener;

import com.example.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HighValueOrderListener {
    //conditinal listener
    @EventListener(condition = "#event.amount >1000")
    public void handleHighValueOrder(OrderCreatedEvent event) {
        System.out.println(" High value order detected! OrderId: "
                + event.getOrderId() + " Amount: " + event.getAmount());
        throw new RuntimeException("Exception");
    }

}
