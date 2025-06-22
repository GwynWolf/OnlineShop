package com.onlineshop.dao.images;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.onlineshop.entity.Images;

import java.util.List;

@Repository
public class ImagesDAOImpl implements ImagesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Images> getAllImages() {
        Session session = sessionFactory.getCurrentSession();
        Query<Images> query = session.createQuery("from Images", Images.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Images> getImagesByProductID(int productID) {
        Session session = sessionFactory.getCurrentSession();
        Query<Images> query = session.createQuery("from Images where productId = :productID", Images.class);
        query.setParameter("productID", productID);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Images image) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(image);
    }
}
