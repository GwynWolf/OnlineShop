package com.onlineshop.dao.category;

import com.onlineshop.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategories();

    void saveCategory(Category category);

    Category getCategory(int id);

    void deleteCategory(int id);
}
