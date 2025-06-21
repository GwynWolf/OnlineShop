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

    private String url;

    @Column(name = "brand_id")
    private Integer brandId;

    private String name;

    @Column(columnDefinition = "mediumtext")
    private String annotation;

    @Column(columnDefinition = "mediumtext")
    private String description;

    private Boolean visible;

    private Integer position;

    @Column(name = "meta_title")
    private String metaTitle;

    @Column(name = "meta_keywords")
    private String metaKeywords;

    @Column(name = "meta_description")
    private String metaDescription;

    private Timestamp created;

    private Boolean featured;

    @Column(name = "external_id")
    private String externalId;

    private Float rating;

    private Integer votes;

    private String special;

    @Column(name = "last_modify", columnDefinition = "timestamp")
    private Timestamp lastModify;

    @Column(name = "main_category_id")
    private Integer mainCategoryId;

    @Column(name = "main_image_id")
    private Integer mainImageId;
}
