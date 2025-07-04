package com.onlineshop.service.order;

import com.onlineshop.dao.order.OrderDAO;
import com.onlineshop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public List<Order> getAll() {
        return orderDAO.findAll();
    }

    @Override
    public Order get(Long id) {
        return orderDAO.findById(id);
    }

    @Override
    public void create(Order order) {
        order.setCreatedAt(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
        order.setUpdatedAt(order.getCreatedAt());
        orderDAO.save(order);
    }

    @Override
    public void update(Order order) {
        order.setUpdatedAt(new Timestamp(System.currentTimeMillis()).toLocalDateTime());
        orderDAO.update(order);
    }

    @Override
    public void delete(Long id) {
        orderDAO.delete(id);
    }
}
