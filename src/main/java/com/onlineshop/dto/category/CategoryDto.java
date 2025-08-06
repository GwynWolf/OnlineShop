package com.onlineshop.dto.category;

import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    private String name;
    private Long parentId;
    private String slug;
    private String url;
    private Boolean visible;
}
