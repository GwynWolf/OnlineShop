package com.onlineshop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    private Category parent;

    @ToString.Exclude
    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private List<Category> children = new ArrayList<>();

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(nullable = false)
    private String name = "";

    @Column(name = "name_h1", nullable = false)
    private String nameH1 = "";

    @Column(name = "meta_title", nullable = false)
    private String metaTitle = "";

    @Column(name = "meta_keywords", nullable = false)
    private String metaKeywords = "";

    @Column(name = "meta_description", nullable = false)
    private String metaDescription = "";

    @Column(columnDefinition = "mediumtext")
    private String annotation = "";

    @Column(columnDefinition = "mediumtext")
    private String description = "";

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String image = "";

    @Column(nullable = false)
    private Integer position = 0;

    @Column(nullable = false)
    private Boolean visible = false;

    @Column(name = "show_table_content", nullable = false)
    private Boolean showTableContent = false;

    @Column(name = "external_id", nullable = false)
    private String externalId = "";

    @Column(name = "level_depth", nullable = false)
    private Integer levelDepth = 0;

    @Column(name = "auto_meta_title", nullable = false)
    private String autoMetaTitle = "";

    @Column(name = "auto_meta_keywords", nullable = false)
    private String autoMetaKeywords = "";

    @Column(name = "auto_meta_desc", nullable = false)
    private String autoMetaDesc = "";

    @Column(name = "auto_description", columnDefinition = "mediumtext")
    private String autoDescription = "";

    @Column(name = "auto_annotation", columnDefinition = "mediumtext")
    private String autoAnnotation = "";

    @Column(name = "last_modify", insertable = false, updatable = false)
    private Timestamp lastModify;

    private Timestamp created;

    @Column(name = "auto_h1")
    private String autoH1 = "";
}
