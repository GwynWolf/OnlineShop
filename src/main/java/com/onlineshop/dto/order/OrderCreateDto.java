package com.onlineshop.dto.order;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderCreateDto {
    @NotNull(message = "User ID is required")
    private Long userId;
    @NotBlank(message = "Status is required")
    private String status;
    @NotBlank(message = "Payment method is required")
    private String paymentMethod;
    @NotBlank(message = "Payment status is required")
    private String paymentStatus;
    @NotBlank(message = "Delivery address is required")
    private String deliveryAddress;
    @NotBlank(message = "Delivery type is required")
    private String deliveryType;
    @NotNull(message = "Delivery price is required")
    @DecimalMin(value = "0.0", message = "Delivery price must be positive")
    private BigDecimal deliveryPrice;
    @NotNull(message = "Total price is required")
    @DecimalMin(value = "0.0", message = "Total price must be positive")
    private BigDecimal totalPrice;
}
