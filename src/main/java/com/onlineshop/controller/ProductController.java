package com.onlineshop.controller;

import com.onlineshop.entity.Category;
import com.onlineshop.entity.Products;
import com.onlineshop.service.category.CategoryService;
import com.onlineshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public String showAll(Model model) {
        System.out.println("showAll");
        List<Products> productsList = productService.getAll();
        model.addAttribute("products", productsList);
        return "products";
    }

    @GetMapping("/new")
    public String create(Model model)
    {
        Products product = new Products();
        List<Category> categories = categoryService.getAll();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "product-detail";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") String id, Model model) {
        Products product = productService.getById(Integer.parseInt(id));
        List<Category> categories = categoryService.getAll();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        return "product-detail";
    }

    @PostMapping
    public void saveOrUpdate(@ModelAttribute("products") Products product) {
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable ("id") String id) {
        productService.delete(Integer.parseInt(id));
        return "redirect:/admin/products";
    }

 }
