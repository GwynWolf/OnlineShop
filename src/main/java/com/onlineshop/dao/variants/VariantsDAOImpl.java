package com.onlineshop.dao.variants;

import com.onlineshop.entity.Variants;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VariantsDAOImpl implements VariantsDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Variants> getByProductID(int productID) {
        Session session = sessionFactory.getCurrentSession();
        Query<Variants> query = session.createQuery("from Variants where productId = :id", Variants.class);
        query.setParameter("id", productID);
        return query.getResultList();
    }

    @Override
    public Variants getById(int variantID) {
        return null;
    }

    @Override
    @Transactional
    public void save(Variants variant) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(variant);
    }

    @Override
    @Transactional
    public void delete(Variants variant) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(variant);
    }

}
