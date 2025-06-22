package com.onlineshop.dao.variants;

import com.onlineshop.entity.Variants;

import java.util.List;

public interface VariantsDAO {
    public List<Variants> getByProductID(int productID);
    public Variants getById(int variantID);

    public void save(Variants variant);

    void delete(Variants variant);
}
