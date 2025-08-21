package com.onlineshop.dao.filter;

import com.onlineshop.entity.Category;
import com.onlineshop.entity.FilterOption;
import com.onlineshop.entity.FilterValue;
import com.onlineshop.entity.ProductFilterValues;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<FilterOption> getFilterOptionsByCategoryId(int categoryId) {
        List<FilterOption> result = entityManager.createQuery("from FilterOption where categoryId = :categoryId", FilterOption.class).setParameter("categoryId", categoryId).getResultList();
        /*int mainCategoryID = entityManager.createQuery("from Category where id = :categoryId", Category.class).setParameter("categoryId", categoryId).getSingleResult().getParentId();
        if(mainCategoryID>0) {
            List<FilterOption> result2 = entityManager.createQuery("from FilterOption where categoryId = :categoryId", FilterOption.class).setParameter("categoryId", mainCategoryID).getResultList();
            result.addAll(result2);
        }*/
        return result;
    }

    @Override
    public List<ProductFilterValues> getProductFilterValuesByProductId(int productId) {
        List<ProductFilterValues> productFilterValues = entityManager.createQuery("from ProductFilterValues where product_id =:productId", ProductFilterValues.class)
                .setParameter("productId", productId)
                .getResultList();
        for (ProductFilterValues productFilterValue : productFilterValues) {
            productFilterValue.setFilterValue(entityManager.find(FilterValue.class, productFilterValue.getValue_id()));
            productFilterValue.setFilterOption(entityManager.find(FilterOption.class, productFilterValue.getOption_id()));
        }
        return productFilterValues;
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
    public void saveProductFilterValues(ProductFilterValues productFilterValues) {
        entityManager.createQuery("delete from ProductFilterValues where product_id =:productId", ProductFilterValues.class)
                .setParameter("productId", productFilterValues.getProduct_id());
        entityManager.persist(productFilterValues);
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
