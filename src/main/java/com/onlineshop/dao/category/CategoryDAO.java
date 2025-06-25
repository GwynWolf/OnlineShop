package com.onlineshop.dao.category;

import com.onlineshop.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategories();

    List<Category> getAllCategoriesIncludingHidden();

    void saveCategory(Category category);

    Category getCategory(long id);

    void deleteCategory(long id);

    boolean slugExists(String slug);

    List<Category> findCategories(Boolean visible, Long parentId);

}
