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
        return entityManager.createQuery("from Category", Category.class).getResultList();
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
            entityManager.remove(category);
        }
    }
}
