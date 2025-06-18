package com.onlineshop.controller;

import com.onlineshop.dao.category.CategoryDAO;
import com.onlineshop.dao.images.ImagesDAO;
import com.onlineshop.dao.order.OrderDAO;
import com.onlineshop.dao.product.ProductsDAO;
import com.onlineshop.dao.variants.VariantsDAO;
import com.onlineshop.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductsDAO productsDAO;

    @Autowired
    private VariantsDAO variantsDAO;

    @Autowired
    private ImagesDAO imagesDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CategoryDAO categoryDAO;


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

    @GetMapping("/orders")
    public String showAllOrders(Model model) {
        List<Order> orderList = orderDAO.getAllOrders();
        model.addAttribute("orders", orderList);
        return "orders";
    }

    @GetMapping("/categories")
    public String showAllCategories(Model model) {
        List<Category> categoryList = categoryDAO.getAllCategories();
        model.addAttribute("categories", categoryList);
        return "categories";
    }


    @GetMapping("/products/{id}")
    public String showProductDetails(@PathVariable("id") int id, Model model) {
        System.out.println(id);
        Products product = productsDAO.getProductById(id);
        List<Variants> variantsList = variantsDAO.getVariantByProductID(id);
        List<Images> imagesList = imagesDAO.getImagesByProductID(id);
        model.addAttribute("product", product);
        model.addAttribute("variants", variantsList);
        model.addAttribute("images", imagesList);
        return "product-detail";
    }
}
