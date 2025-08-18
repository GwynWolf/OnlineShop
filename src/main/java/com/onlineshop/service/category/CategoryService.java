package com.onlineshop.service.category;

import com.onlineshop.entity.CategoryNode;
import com.onlineshop.entity.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    List<Category> getAllIncludingHidden();

    void save(Category category);

    Category get(long id);

    void delete(long id);

    List<CategoryNode> buildCategoryTree(List<Category> categories);

    List<Category> find(Boolean visible, Long parentId);

    List<CategoryNode> getCategoryTree(Boolean visible, Long parentId);

}
