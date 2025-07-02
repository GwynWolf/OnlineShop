package com.onlineshop.service.category;

import com.onlineshop.dao.category.CategoryDAO;
import com.onlineshop.entity.CategoryNode;
import com.onlineshop.entity.Category;
import com.onlineshop.util.SlugUtil;
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
    public List<Category> getAllIncludingHidden() {
        return categoryDAO.getAllCategoriesIncludingHidden();
    }

    @Override
    @Transactional
    public void save(Category category) {
        try {
            if (category.getSlug() == null || category.getSlug().isBlank()) {
                String baseSlug = SlugUtil.toSlug(category.getName());
                String uniqueSlug = baseSlug;
                long suffix = 1;
                while (categoryDAO.slugExists(uniqueSlug)) {
                    uniqueSlug = baseSlug + "-" + suffix++;
                }
                category.setSlug(uniqueSlug);
            }
            if (category.getParentId() != null && category.getParentId() != 0L) {
                Category parent = categoryDAO.getCategory(category.getParentId().intValue());
                if (parent == null) {
                    throw new IllegalArgumentException("Parent category with ID " + category.getParentId() + " does no exist.");
                }
            }
            categoryDAO.saveCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public Category get(long id) {
        return categoryDAO.getCategory(id);
    }

    @Override
    @Transactional
    public void delete(long id) {
        categoryDAO.deleteCategory(id);
    }

    @Override
    @Transactional
    public List<CategoryNode> buildCategoryTree(List<Category> categories) {
        Map<Long, CategoryNode> map = new HashMap<>();
        List<CategoryNode> roots = new ArrayList<>();

        for (Category c : categories) {
            map.put(c.getId(), new CategoryNode(c));
        }

        for (Category c : categories) {
            CategoryNode node = map.get(c.getId());
            if (c.getParentId() == null || c.getParentId() == 0) {
                roots.add(node);
            } else {
                CategoryNode parentNode = map.get(c.getParentId());
                if (parentNode != null) {
                    parentNode.getChildren().add(node);
                    node.setParentId(parentNode.getId());
                } else {
                    roots.add(node);
                }
            }
        }
        return roots;
    }

    @Override
    @Transactional
    public List<Category> find(Boolean visible, Long parentId) {
        return categoryDAO.findCategories(visible, parentId);
    }

    @Override
    public List<CategoryNode> getCategoryTree(Boolean visible, Long parentId) {
        List<Category> categories = find(visible, null);
        List<CategoryNode> fullTree = buildCategoryTree(categories);

        if (parentId != null) {
            CategoryNode subtree = findSubtreeNode(fullTree, parentId);
            return subtree != null ? List.of(subtree) : List.of();
        }

        return fullTree;
    }

    private CategoryNode findSubtreeNode(List<CategoryNode> nodes, Long parentId) {
        for (CategoryNode node : nodes) {
            if (node.getId().equals(parentId)) {
                return node;
            }
            CategoryNode found = findSubtreeNode(node.getChildren(), parentId);
            if (found != null) {
                return found;
            }
        }
        return null;
    }
}
