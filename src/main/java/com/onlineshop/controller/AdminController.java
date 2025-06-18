package com.onlineshop.controller;

import com.onlineshop.dao.ImagesDAO;
import com.onlineshop.dao.ProductsDAO;
import com.onlineshop.dao.VariantsDAO;
import com.onlineshop.entity.Images;
import com.onlineshop.entity.Products;
import com.onlineshop.entity.Variants;
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


    @GetMapping
    public String adminPanel() {
        return "admin"; // → /view/admin.jsp
    }


    @GetMapping("/products")
    public String showAllProducts(Model model) {
        List<Products> productsList = productsDAO.getAllProducts();
        model.addAttribute("products", productsList);
        return "products"; // → /view/products.jsp
    }


    @GetMapping("/products/{id}")
    public String showProductDetails(@PathVariable("id") int id, Model model) {
        Products product = productsDAO.getProductById(id);
        List<Variants> variantsList = variantsDAO.getVariantByProductID(id);
        List<Images> imagesList = imagesDAO.getImagesByProductID(id);
        model.addAttribute("product", product);
        model.addAttribute("variants", variantsList);
        model.addAttribute("images", imagesList);
        return "product-detail"; // → /view/product-detail.jsp
    }
}
