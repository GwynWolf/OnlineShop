package com.onlineshop.controller;

import com.onlineshop.entity.Order;
import com.onlineshop.service.order.OrderService;
import com.onlineshop.service.order.OrderServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(
    ) {
        List<Order> orders = orderService.getAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long id) {
        Order order = orderService.get(id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
        orderService.create(order);
        return ResponseEntity.ok(order);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long id,
                                             @Valid @RequestBody Order updatedOrder) {
        Order existing = orderService.get(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        updatedOrder.setId(id);
        orderService.update(updatedOrder);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") long id) {
        Order order = orderService.get(id);
        if (order == null) {
            throw new RuntimeException("Order not found");
        }
        orderService.delete(id);
    }
}
