package com.onlineshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Название (обязательное)
    @Column(nullable = false, length = 255)
    private String name;

    // Слаг, уникальный (автогенерация на уровне приложения)
    @Column(nullable = false, unique = true, length = 255)
    private String slug;

    // Описание (опционально)
    @Column(columnDefinition = "TEXT")
    private String description;

    // Цена (>= 0), обязательная
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    // ID категории (обязательное)
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    // Активен ли товар (по умолчанию true)
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    // Дата создания
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Дата последнего обновления
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Примечание:
    // Связанные изображения предполагается хранить в отдельной таблице (например, ProductImage),
    // см. ниже.
}
