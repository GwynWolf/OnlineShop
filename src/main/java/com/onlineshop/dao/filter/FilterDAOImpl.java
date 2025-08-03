package com.onlineshop.dao.filter;

import com.onlineshop.entity.FilterOption;
import com.onlineshop.entity.FilterValue;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilterDAOImpl implements FilterDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FilterOption> getAllFilterOptions() {
        return entityManager.createQuery("from FilterOption", FilterOption.class).getResultList();
    }

    @Override
    public FilterOption getFilterOptionById(int id) {
        return entityManager.find(FilterOption.class, id);
    }

    @Override
    public List<FilterValue> getFilterValueByIdFilterOption(int id) {
        return entityManager.createQuery(
                        "from FilterValue where optionId = :id", FilterValue.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public FilterValue getFilterValueById(int id) {
        return entityManager.find(FilterValue.class, id);
    }

    @Override
    public void saveFilterOption(FilterOption filterOption) {
        if (filterOption.getId() == null) {
            entityManager.persist(filterOption);
        } else {
            entityManager.merge(filterOption);
        }
    }

    @Override
    public void deleteFilterOption(int id) {
        entityManager.remove(entityManager.find(FilterOption.class, id));
    }

    @Override
    public void saveFilterValue(FilterValue filterValue) {
        if (filterValue.getId() == null) {
            entityManager.persist(filterValue);
        } else {
            entityManager.merge(filterValue);
        }
    }

    @Override
    public void deleteFilterValue(int id) {
        entityManager.remove(entityManager.find(FilterValue.class, id));
    }
}
