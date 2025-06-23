package com.onlineshop.dao.variants;

import com.onlineshop.entity.Variants;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VariantsDAOImpl implements VariantsDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Variants> getByProductID(int productID) {
        return entityManager.createQuery(
                        "from Variants where productId = :productID", Variants.class)
                .setParameter("productID", productID)
                .getResultList();
    }

    @Override
    @Transactional
    public Variants getById(int variantID) {
        return entityManager.find(Variants.class, variantID);
    }

    @Override
    @Transactional
    public void save(Variants variant) {
       entityManager.persist(variant);
    }

    @Override
    @Transactional
    public void delete(Variants variant) {
        entityManager.remove(variant);
    }

}
