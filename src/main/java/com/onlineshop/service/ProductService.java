package com.onlineshop.service;

import com.onlineshop.entity.Products;

import java.util.List;

public interface ProductService {
    public List<Products> getAll();
    public Products getById(int id);
    public void save(Products products);
    public void update(Products products);
    public void delete(Products products);

}
