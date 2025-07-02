package com.onlineshop.dao.product;

import com.onlineshop.entity.Category;
import com.onlineshop.entity.Products;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductsDAOImpl implements ProductsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Products> getAllProducts() {
       return entityManager.createQuery("from Products", Products.class).getResultList();
    }

    @Override
    @Transactional
    public Products getProductById(int id) {
        return entityManager.find(Products.class, id);

    }

    @Override
    @Transactional
    public void save(Products product) {
        if (product.getId() == null) {
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
    }

    @Override
    @Transactional
    public void delete(Products product) {
            entityManager.remove(product);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Products.class, id));
    }
}
