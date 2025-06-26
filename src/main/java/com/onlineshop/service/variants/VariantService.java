package com.onlineshop.service.variants;

import com.onlineshop.entity.Variants;

import java.util.List;

public interface VariantService {
    public List<Variants> getByProductID(int productID);
    public Variants getById(int id);
    public void save(Variants variants);
    public void update(Variants variants);
    public void delete(Variants variants);
    public void delete(int id);
}
