package com.onlineshop.dao.variants;

import com.onlineshop.entity.Variants;
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
    public List<Variants> getVariantByProductID(int productID) {
        Session session = sessionFactory.getCurrentSession();
        Query<Variants> query = session.createQuery("from Variants where productId = :id", Variants.class);
        return query.getResultList();
    }

}
