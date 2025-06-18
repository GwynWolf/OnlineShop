package com.onlineshop.dao.order;

import com.onlineshop.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery("from Order", Order.class);
        return query.getResultList();
    }
}
