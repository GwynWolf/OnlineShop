package com.onlineshop.dao;

import com.onlineshop.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        Session session = sessionFactory.getCurrentSession();
        Query<Category> query = session.createQuery("from Category", Category.class);
        return query.getResultList();
    }
}
