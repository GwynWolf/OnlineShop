package com.onlineshop.service.category;

import com.onlineshop.entity.CategoryNode;
import com.onlineshop.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    void save(Category category);

    Category get(int id);

    void delete(int id);

    List<CategoryNode> buildCategoryTree(List<Category> categories);


}
