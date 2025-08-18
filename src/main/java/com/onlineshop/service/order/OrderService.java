package com.onlineshop.service.order;

import com.onlineshop.dto.order.OrderCreateDto;
import com.onlineshop.dto.order.OrderDto;
import com.onlineshop.dto.order.OrderFilterDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAll();
    OrderDto getById(Long id);
    OrderDto create(OrderCreateDto dto);
    OrderDto update(Long id, OrderCreateDto dto);
    void delete(Long id);
    List<OrderDto> getFilteredOrders(OrderFilterDto filter);
}
