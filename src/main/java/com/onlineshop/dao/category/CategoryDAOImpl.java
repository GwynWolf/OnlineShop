package com.onlineshop.dao.category;

import com.onlineshop.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> getAllCategories() {
        return entityManager.createQuery("FROM Category c WHERE c.visible = true", Category.class).getResultList();
    }

    @Override
    public List<Category> getAllCategoriesIncludingHidden() {
        return entityManager.createQuery("FROM Category", Category.class).getResultList();
    }

    @Override
    public void saveCategory(Category category) {
        if (category.getId() == null) {
            entityManager.persist(category);
        } else {
            entityManager.merge(category);
        }
    }

    @Override
    public Category getCategory(int id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public void deleteCategory(int id) {
        Category category = getCategory(id);
        if (category != null) {
            category.setVisible(false);
            entityManager.merge(category);
        }
    }

    public boolean slugExists(String slug) {
        Long count = entityManager.createQuery("SELECT COUNT(c) FROM Category c WHERE c.slug = :slug", Long.class)
                .setParameter("slug", slug)
                .getSingleResult();
        return count > 0;
    }
}
