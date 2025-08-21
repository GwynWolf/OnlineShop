package com.onlineshop.dao.filter;

import com.onlineshop.entity.FilterOption;
import com.onlineshop.entity.FilterValue;
import com.onlineshop.entity.ProductFilterValues;

import java.util.List;
import java.util.Map;

public interface FilterDAO {

    List<FilterOption> getAllFilterOptions();
    FilterOption getFilterOptionById(int id);
    List<FilterValue> getFilterValueByIdFilterOption(int id);
    FilterValue getFilterValueById(int id);
    List<FilterOption> getFilterOptionsByCategoryId(int categoryId);
    List<ProductFilterValues> getProductFilterValuesByProductId(int productId);
    void saveFilterOption(FilterOption filterOption);
    void saveProductFilterValues(ProductFilterValues productFilterValues);
    void deleteFilterOption(int id);
    void saveFilterValue(FilterValue filterValue);
    void deleteFilterValue(int id);
}
