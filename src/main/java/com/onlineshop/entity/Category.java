package com.onlineshop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
    private String name = "";

    @Column(nullable = false, unique = true)
    private String slug = "";

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Integer position = 0;

    @Column(nullable = false)
    private Boolean visible = false;

    @UpdateTimestamp
    @Column(name = "updatedAt")
    private LocalDateTime lastModify;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;
}
