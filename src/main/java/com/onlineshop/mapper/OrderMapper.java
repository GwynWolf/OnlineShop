package com.onlineshop.mapper;

import com.onlineshop.dto.order.OrderCreateDto;
import com.onlineshop.dto.order.OrderDto;
import com.onlineshop.entity.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderMapper {
    public OrderDto toDto(Order order) {
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setStatus(order.getStatus());
        dto.setPaymentMethod(order.getPaymentMethod());
        dto.setPaymentStatus(order.getPaymentStatus());
        dto.setDeliveryAddress(order.getDeliveryAddress());
        dto.setDeliveryType(order.getDeliveryType());
        dto.setDeliveryPrice(order.getDeliveryPrice());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setUpdatedAt(order.getUpdatedAt());
        return dto;
    }

    public Order toEntity(OrderCreateDto dto) {
        Order order = new Order();
        order.setUserId(dto.getUserId());
        order.setStatus(dto.getStatus());
        order.setPaymentMethod(dto.getPaymentMethod());
        order.setPaymentStatus(dto.getPaymentStatus());
        order.setDeliveryAddress(dto.getDeliveryAddress());
        order.setDeliveryType(dto.getDeliveryType());
        order.setDeliveryPrice(dto.getDeliveryPrice());
        order.setTotalPrice(dto.getTotalPrice());
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());
        return order;
    }

    public void updateOrderFromDto(OrderCreateDto dto, Order order){
        order.setStatus(dto.getStatus());
        order.setPaymentMethod(dto.getPaymentMethod());
        order.setPaymentStatus(dto.getPaymentStatus());
        order.setDeliveryAddress(dto.getDeliveryAddress());
        order.setDeliveryType(dto.getDeliveryType());
        order.setDeliveryPrice(dto.getDeliveryPrice());
        order.setTotalPrice(dto.getTotalPrice());
    }
}
