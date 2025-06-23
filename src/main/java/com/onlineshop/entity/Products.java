package com.onlineshop.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "products")
@Data
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String url = "";

    @Column(name = "brand_id")
    private Integer brandId = 0;

    @Column(nullable = false, length = 512)
    private String name = "";

    @Column(columnDefinition = "mediumtext")
    private String annotation;

    @Column(columnDefinition = "mediumtext")
    private String description;

    @Column(nullable = false)
    private Boolean visible = true;

    @Column(nullable = false)
    private Integer position = 0;

    @Column(name = "meta_title", nullable = false, length = 512)
    private String metaTitle = "";

    @Column(name = "meta_keywords", nullable = false, length = 512)
    private String metaKeywords = "";

    @Column(name = "meta_description", nullable = false, length = 512)
    private String metaDescription = "";

    @Column
    private Timestamp created;

    @Column
    private Boolean featured = false;

    @Column(name = "external_id", nullable = false, length = 36)
    private String externalId = "";

    @Column
    private Float rating = 0.0f;

    @Column
    private Integer votes = 0;

    @Column
    private String special = "";

    @Column(name = "last_modify", nullable = false, insertable = false, updatable = false)
    private Timestamp lastModify;

    @Column(name = "main_category_id")
    private Integer mainCategoryId;

    @Column(name = "main_image_id")
    private Integer mainImageId;
}
