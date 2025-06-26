package com.onlineshop.dao.product;

import com.onlineshop.entity.Products;

import java.util.List;

public interface ProductsDAO {
    public List<Products> getAllProducts();
    public Products getProductById(int id);

    public void save(Products product);
    public void delete(Products product);
    public void delete(int id);
}
