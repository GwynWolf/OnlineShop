package com.onlineshop.service.product;

import com.onlineshop.dao.product.ProductsDAO;
import com.onlineshop.entity.Products;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductsDAO productsDAO;

    @Override
    @Transactional
    public List<Products> getAll() {
        return productsDAO.getAllProducts();
    }

    @Override
    @Transactional
    public Products getById(int id) {
        return productsDAO.getProductById(id);
    }

    @Override
    @Transactional
    public void save(Products products) {
        productsDAO.save(products);
    }

    @Override
    public void update(Products products) {
        productsDAO.save(products);
    }

    @Override
    public void delete(Products products) {
        productsDAO.delete(products);
    }
}
