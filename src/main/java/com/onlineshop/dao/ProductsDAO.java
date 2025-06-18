package com.onlineshop.dao;

import com.onlineshop.entity.Products;

import java.util.List;

public interface ProductsDAO {
    public List<Products> getAllProducts();
    public Products getProductById(int id);
}
