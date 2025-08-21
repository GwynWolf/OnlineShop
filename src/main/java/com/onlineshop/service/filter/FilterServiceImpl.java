package com.onlineshop.service.filter;

import com.onlineshop.dao.filter.FilterDAO;
import com.onlineshop.entity.FilterOption;
import com.onlineshop.entity.FilterValue;
import com.onlineshop.entity.ProductFilterValues;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FilterServiceImpl implements FilterService {

    @Autowired
    private FilterDAO filterDAO;


    @Override
    @Transactional
    public List<FilterOption> getAllFilterOptions() {
        return filterDAO.getAllFilterOptions();
    }

    @Override
    @Transactional
    public FilterOption getFilterOptionById(int id) {
        return filterDAO.getFilterOptionById(id);
    }

    @Override
    @Transactional
    public List<FilterValue> getFilterValueByIdFilterOption(int id) {
        return filterDAO.getFilterValueByIdFilterOption(id);
    }

    @Override
    public FilterValue getFilterValueById(int id) {
        return filterDAO.getFilterValueById(id);
    }

    @Override
    public List<FilterOption> getFilterOptionsByCategoryId(int categoryId) {
        return filterDAO.getFilterOptionsByCategoryId(categoryId);
    }

    @Override
    public List<ProductFilterValues> getProductFilterValuesByProductId(int productId) {
        return filterDAO.getProductFilterValuesByProductId(productId);
    }

    @Override
    public void saveProductFilterValues(ProductFilterValues productFilterValues) {
        filterDAO.saveProductFilterValues(productFilterValues);
    }

    @Override
    @Transactional
    public void saveFilterOption(FilterOption filterOption) {
        filterDAO.saveFilterOption(filterOption);
    }

    @Override
    @Transactional
    public void deleteFilterOption(int id) {
        filterDAO.deleteFilterOption(id);
    }

    @Override
    @Transactional
    public void saveFilterValue(FilterValue filterValue) {
        filterDAO.saveFilterValue(filterValue);
    }

    @Override
    @Transactional
    public void deleteFilterValue(int id) {
        filterDAO.deleteFilterValue(id);
    }
}
