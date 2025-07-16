package com.onlineshop.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryNode {
    private Long id;
    private String name;
    private Long parentId;
    private List<CategoryNode> children = new ArrayList<>();

    public CategoryNode(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.parentId = category.getParentId();
    }
}
