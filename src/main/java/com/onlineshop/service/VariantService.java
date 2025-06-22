package com.onlineshop.service;

import com.onlineshop.entity.Products;
import com.onlineshop.entity.Variants;

import java.util.List;

public interface VariantService {
    public List<Variants> getByProductID(int productID);
    public Variants getById(int id);
    public void save(Variants variants);
    public void update(Variants variants);
    public void delete(Variants variants);
}
