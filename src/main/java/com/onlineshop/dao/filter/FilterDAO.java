package com.onlineshop.dao.filter;

import com.onlineshop.entity.FilterOption;
import com.onlineshop.entity.FilterValue;

import java.util.List;

public interface FilterDAO {

    List<FilterOption> getAllFilterOptions();
    FilterOption getFilterOptionById(int id);
    List<FilterValue> getFilterValueByIdFilterOption(int id);
    void saveFilterOption(FilterOption filterOption);
    void deleteFilterOption(int id);
    void saveFilterValue(FilterValue filterValue);
    void deleteFilterValue(int id);
}
