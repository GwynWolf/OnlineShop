package com.onlineshop.service.filter;

import com.onlineshop.entity.FilterOption;
import com.onlineshop.entity.FilterValue;

import java.util.List;

public interface FilterService {
    List<FilterOption> getAllFilterOptions();
    FilterOption getFilterOptionById(int id);
    List<FilterValue> getFilterValueByIdFilterOption(int id);
    FilterValue getFilterValueById(int id);
    List<FilterOption> getFilterOptionsByCategoryId(int categoryId);
    void saveFilterOption(FilterOption filterOption);
    void deleteFilterOption(int id);
    void saveFilterValue(FilterValue filterValue);
    void deleteFilterValue(int id);
}
