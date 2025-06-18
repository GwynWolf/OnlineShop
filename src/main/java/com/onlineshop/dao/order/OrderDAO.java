package com.onlineshop.dao.order;

import com.onlineshop.entity.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAllOrders();
}
