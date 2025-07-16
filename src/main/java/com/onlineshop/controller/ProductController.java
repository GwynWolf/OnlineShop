package com.onlineshop.controller;

import com.onlineshop.dao.images.ImagesDAO;
import com.onlineshop.dao.product.ProductsDAO;
import com.onlineshop.dao.variants.VariantsDAO;
import com.onlineshop.entity.Category;
import com.onlineshop.entity.Images;
import com.onlineshop.entity.Products;
import com.onlineshop.entity.Variants;
import com.onlineshop.service.category.CategoryService;
import com.onlineshop.service.product.ProductService;
import com.onlineshop.service.variants.VariantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public String saveOrUpdate(@ModelAttribute("products") Products product) {
        productService.save(product);
        return "redirect:/admin/products/" + product.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable ("id") String id) {
        productService.delete(Integer.parseInt(id));
        return "redirect:/admin/products";
    }

 }
