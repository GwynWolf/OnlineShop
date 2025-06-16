package com.onlineshop.controller;

import com.onlineshop.dao.ProductsDAO;
import com.onlineshop.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductsDAO productsDAO;


    @GetMapping
    public String adminPanel() {
        return "admin";
    }


    @GetMapping("/products")
    public String showAllProducts(Model model) {
        List<Products> productsList = productsDAO.getAllProducts();
        model.addAttribute("products", productsList);
        return "products";
    }
}
