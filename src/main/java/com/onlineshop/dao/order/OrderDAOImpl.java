package com.onlineshop.dao.order;

import com.onlineshop.dto.order.OrderFilterDto;
import com.onlineshop.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findAll() {
        return entityManager.createQuery("FROM Order o", Order.class).getResultList();
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
    public void delete(Order order) {
        entityManager.remove(order);
    }

    @Override
    public List<Order> findFiltered(OrderFilterDto filter) {
        StringBuilder sb = new StringBuilder("SELECT o FROM Order o WHERE 1=1");

        if (filter.getStatus() != null) {
            sb.append(" AND o.status = :status");
        }
        if (filter.getUserId() != null) {
            sb.append(" AND o.userId = :userId");
        }
        if (filter.getFrom() != null) {
            sb.append(" AND o.createdAt >= :from");
        }
        if (filter.getTo() != null) {
            sb.append(" AND o.createdAt <= :to");
        }

        TypedQuery<Order> query = entityManager.createQuery(sb.toString(), Order.class);

        if (filter.getStatus() != null) {
            query.setParameter("status", filter.getStatus());
        }
        if (filter.getUserId() != null) {
            query.setParameter("userId", filter.getUserId());
        }
        if (filter.getFrom() != null) {
            query.setParameter("from", filter.getFrom().atStartOfDay());
        }
        if (filter.getTo() != null) {
            query.setParameter("to", filter.getTo().atTime(LocalTime.MAX));
        }
        return query.getResultList();
    }
}
