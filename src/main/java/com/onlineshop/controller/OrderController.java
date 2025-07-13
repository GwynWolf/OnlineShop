package com.onlineshop.controller;

import com.onlineshop.dto.order.OrderCreateDto;
import com.onlineshop.dto.order.OrderDto;
import com.onlineshop.dto.order.OrderFilterDto;
import com.onlineshop.service.order.OrderService;
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
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") long id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderCreateDto dto) {
        return ResponseEntity.ok(orderService.create(dto));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("id") long id,
                                                @Valid @RequestBody OrderCreateDto dto) {
        return ResponseEntity.ok(orderService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<OrderDto>> getFilteredOrders(@ModelAttribute OrderFilterDto filter) {
        return ResponseEntity.ok(orderService.getFilteredOrders(filter));
    }
}
