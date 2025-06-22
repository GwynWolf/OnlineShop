package com.onlineshop.service.category;

import com.onlineshop.dao.category.CategoryDAO;
import com.onlineshop.entity.CategoryNode;
import com.onlineshop.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Category> getAll() {
        return categoryDAO.getAllCategories();
    }

    @Override
    @Transactional
    public void save(Category category) {
        categoryDAO.saveCategory(category);
    }

    @Override
    @Transactional
    public Category get(int id) {
        return categoryDAO.getCategory(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        categoryDAO.deleteCategory(id);
    }

    @Override
    public List<CategoryNode> buildCategoryTree(List<Category> categories) {
        Map<Integer, CategoryNode> map = new HashMap<>();
        List<CategoryNode> roots = new ArrayList<>();

        for (Category c : categories) {
            map.put(c.getId(), new CategoryNode(c));
        }

        for (Category c : categories) {
            CategoryNode node = map.get(c.getId());
            if (c.getParentId() == null || c.getParentId() == 0) {
                roots.add(node);
            } else {
                CategoryNode parent = map.get(c.getParentId());
                if (parent != null) {
                    parent.getChildren().add(node);
                }
            }
        }
        return roots;
    }
}
