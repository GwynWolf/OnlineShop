package com.onlineshop.controller;

import com.onlineshop.dao.CategoryDAO;
import com.onlineshop.dao.OrderDAO;
import com.onlineshop.dao.ProductsDAO;
import com.onlineshop.entity.Category;
import com.onlineshop.entity.Order;
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
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private OrderDAO orderDAO;


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

    @GetMapping("/categories")
    public String showAllCategories(Model model) {
        List<Category> categories = categoryDAO.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/orders")
    public String showAllOrders(Model model){
        List<Order> orders = orderDAO.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

}
