package com.onlineshop.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "images")
@Data
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(nullable = false)
    private String filename;

    @Column(nullable = false)
    private Integer position;
}
