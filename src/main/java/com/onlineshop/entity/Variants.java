package com.onlineshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "variants")
@Data
public class Variants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(nullable = false)
    private String sku;

    @Column(nullable = false)
    private String name;

    private BigDecimal weight;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "compare_price")
    private BigDecimal comparePrice;

    private Integer stock;

    private Integer position;

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @Column(name = "currency_id", nullable = false)
    private Integer currencyId;

    @Column(nullable = false)
    private String units;

    private BigDecimal volume;
}
