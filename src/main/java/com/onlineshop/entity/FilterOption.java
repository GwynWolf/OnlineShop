package com.onlineshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "filter_options")
@Data
public class FilterOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Название фильтра (например, "Цвет")
    @Column(nullable = false, length = 255)
    private String name;

    // Категория, к которой относится фильтр
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    // Основной фильтр для категории?
    @Column(name = "is_main", nullable = false)
    private Boolean isMain = false;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @Transient
    private List<FilterValue> filterOptionList = new ArrayList<>();

     
}
