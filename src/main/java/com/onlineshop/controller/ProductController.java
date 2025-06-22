package com.onlineshop.controller;

import com.onlineshop.dao.images.ImagesDAO;
import com.onlineshop.dao.product.ProductsDAO;
import com.onlineshop.dao.variants.VariantsDAO;
import com.onlineshop.entity.Category;
import com.onlineshop.entity.Images;
import com.onlineshop.entity.Products;
import com.onlineshop.entity.Variants;
import com.onlineshop.service.product.ProductService;
import com.onlineshop.service.variants.VariantService;
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
    private VariantService variantService;


    @GetMapping("")
    public String showAllProducts(Model model) {
        List<Products> productsList = productService.getAll();
        model.addAttribute("products", productsList);
        return "products";
    }

    @GetMapping("/{id}")
    public String showProductDetails(@PathVariable("id") int id, Model model) {
        System.out.println(id);
        Products product = productService.getById(id);
        List<Variants> variantsList = variantService.getByProductID(id);
        model.addAttribute("product", product);
        model.addAttribute("variants", variantsList);
        return "product-detail";
    }
    @PostMapping("/save")
    public String saveProducts(@ModelAttribute("product") Products product) {
        productService.save(product);
        return "redirect:/admin/products";
    }


}
