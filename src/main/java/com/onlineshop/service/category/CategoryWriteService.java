package com.onlineshop.service.category;

import com.onlineshop.dto.category.CategoryCreateDto;

public interface CategoryWriteService {
    void save(CategoryCreateDto dto);
    void update(long id, CategoryCreateDto dto);
    void delete(long id);
}
