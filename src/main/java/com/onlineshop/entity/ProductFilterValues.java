package com.onlineshop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_filter_values")
@Data
public class ProductFilterValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int product_id;
    @Column
    private int option_id;
    @Column
    private int value_id;
    @Transient
    private FilterValue filterValue;
    @Transient
    private FilterOption filterOption;
}
