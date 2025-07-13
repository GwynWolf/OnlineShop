package com.onlineshop.service.order;

import com.onlineshop.dao.order.OrderDAO;
import com.onlineshop.dto.order.OrderCreateDto;
import com.onlineshop.dto.order.OrderDto;
import com.onlineshop.dto.order.OrderFilterDto;
import com.onlineshop.entity.Order;
import com.onlineshop.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    OrderMapper orderMapper;

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        return orderDAO.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public OrderDto getById(Long id) {
        Order order = orderDAO.findById(id);
        if (order == null) {
            throw new RuntimeException("Order not found");
        }
        return orderMapper.toDto(order);
    }

    @Override
    @Transactional
    public OrderDto create(OrderCreateDto dto) {
        Order order = orderMapper.toEntity(dto);
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        orderDAO.save(order);
        return orderMapper.toDto(order);
    }

    @Override
    @Transactional
    public OrderDto update(Long id, OrderCreateDto dto) {
        Order existing = orderDAO.findById(id);
        if (existing == null) {
            throw new RuntimeException("Order not found");
        }

        orderMapper.updateOrderFromDto(dto, existing);
        existing.setUpdatedAt(LocalDateTime.now());
        orderDAO.update(existing);
        return orderMapper.toDto(existing);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Order order = orderDAO.findById(id);
        if (order == null) {
            throw new RuntimeException("Order not found");
        }
        orderDAO.delete(order);
    }

    @Override
    @Transactional
    public List<OrderDto> getFilteredOrders(OrderFilterDto filter) {
        List<Order> orders = orderDAO.findFiltered(filter);
        return orders.stream()
                .map(orderMapper::toDto)
                .toList();
    }
}
