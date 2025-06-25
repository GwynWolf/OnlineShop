package com.onlineshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    private Category parent;

    @JsonManagedReference
    @ToString.Exclude
    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
    private List<Category> children = new ArrayList<>();

    @Column(name = "parent_id")
    private Long parentId;

    @Column(nullable = false)
    @NotBlank(message = "name is required")
    private String name = "";

    @Column(nullable = false, unique = true)
    private String slug = "";

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
    @NotNull(message = "Status (visible) is required")
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDateTime lastModify;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "auto_h1")
    private String autoH1 = "";
}
