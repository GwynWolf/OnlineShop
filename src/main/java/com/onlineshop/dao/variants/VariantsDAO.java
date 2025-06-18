package com.onlineshop.dao.variants;

import com.onlineshop.entity.Variants;

import java.util.List;

public interface VariantsDAO {
    public List<Variants> getVariantByProductID(int productID);

}
