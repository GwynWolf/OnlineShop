package com.onlineshop.service.order;

import com.onlineshop.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    Order get(Long id);
    void create(Order order);
    void update(Order order);
    void delete(Long id);
}
