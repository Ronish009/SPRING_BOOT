package com.example.controller;

import com.example.service.OrderService;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/{Id}/{amount}")
    public String createOrder(@PathVariable String Id, @PathVariable int amount) {
        orderService.createOrder(Id,amount);
        return "Order placed Successfully"+Id + "of amount : "+amount;
    }
}
