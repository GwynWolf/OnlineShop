package com.onlineshop.dao;

import com.onlineshop.entity.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductsDAOImpl implements ProductsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Products> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query<Products> query = session.createQuery("from Products", Products.class);
        List<Products> products = query.getResultList();
        return products;
    }
}
