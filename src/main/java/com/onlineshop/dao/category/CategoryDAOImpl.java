package com.onlineshop.dao.category;

import com.onlineshop.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
    public Category getCategory(long id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public void deleteCategory(long id) {
        Category category = getCategory(id);
        if (category != null) {
            category.setVisible(false);
            entityManager.merge(category);
        }
    }

    @Override
    public boolean slugExists(String slug) {
        Long count = entityManager.createQuery("SELECT COUNT(c) FROM Category c WHERE c.slug = :slug", Long.class)
                .setParameter("slug", slug)
                .getSingleResult();
        return count > 0;
    }

    public List<Category> findCategories(Boolean visible, Long parentId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Category> query = cb.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);
        List<Predicate> predicates = new ArrayList<>();

        if (visible != null) {
            predicates.add(cb.equal(root.get("visible"), visible));
        }
        if (parentId != null) {
            predicates.add(cb.equal(root.get("parentId"), parentId));
        }

        query.select(root).where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}
