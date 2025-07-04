package com.onlineshop.dao.order;

import com.onlineshop.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findAll() {
        return entityManager.createQuery("FROM Order", Order.class).getResultList();
    }

    @Override
    public Order findById(Long id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void update(Order order) {
        entityManager.merge(order);
    }

    @Override
    public void delete(Long id) {
        Order order = entityManager.find(Order.class, id);
        if (order != null) {
            entityManager.remove(order);
        }
    }
}
