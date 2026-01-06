package com.example.schedulers;

import com.example.entity.Order;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderScheduler {

    @Autowired
    OrderRepository orderRepository;

    //@Scheduled(fixedRate = 5000)
    //@Scheduled(initialDelay = 10000, fixedDelay = 5000)
    //@Scheduled(cron = "* * * * * *")
    public void processPendingOrders() {
        System.out.println("Processing Orders");
        List<Order> orders = orderRepository.findByStatus("PENDING");
        orders.forEach(order -> {
            order.setStatus("COMPLETED");
            System.out.println(order.getCustomerEmail());
            orderRepository.save(order);
        });
        System.out.println("Processed pending orders"+ orders.size());
    }
}
