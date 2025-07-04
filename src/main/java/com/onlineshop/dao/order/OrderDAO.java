package com.onlineshop.dao.order;

import com.onlineshop.entity.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> findAll();

    Order findById(Long id);

    void save(Order order);

    void update(Order order);

    void delete(Long id);
}
