package com.onlineshop.mapper;

import com.onlineshop.dto.category.CategoryCreateDto;
import com.onlineshop.dto.category.CategoryDto;
import com.onlineshop.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDto toDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setParentId(category.getParentId());
        dto.setSlug(category.getSlug());
        dto.setUrl(category.getUrl());
        dto.setVisible(category.getVisible());
        return dto;
    }

    public Category toEntity(CategoryCreateDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setParentId(dto.getParentId());
        category.setVisible(dto.getVisible());
        category.setUrl(dto.getUrl());
        return category;
    }

    public Category toEntity(CategoryDto dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        category.setParentId(dto.getParentId());
        category.setVisible(dto.getVisible());
        category.setUrl(dto.getUrl());
        category.setSlug(dto.getSlug());
        return category;
    }
}
