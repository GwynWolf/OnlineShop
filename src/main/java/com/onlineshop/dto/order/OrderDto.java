package com.onlineshop.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDto {
    @NotNull
    private Long id;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
