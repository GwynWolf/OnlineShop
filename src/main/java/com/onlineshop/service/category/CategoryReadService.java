package com.onlineshop.service.category;

import com.onlineshop.dto.category.CategoryDto;
import com.onlineshop.entity.CategoryNode;

import java.util.List;

public interface CategoryReadService {
    List<CategoryDto> getAll();
    List<CategoryDto> getAllIncludingHidden();
    CategoryDto get(long id);
    List<CategoryDto> find(Boolean visible, Long parentId);
    List<CategoryNode> getCategoryTree(Boolean visible, Long parentId);
}
