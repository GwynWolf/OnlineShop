package com.onlineshop.controller;

import com.onlineshop.dao.images.ImagesDAO;
import com.onlineshop.dao.product.ProductsDAO;
import com.onlineshop.dao.variants.VariantsDAO;
import com.onlineshop.entity.Images;
import com.onlineshop.entity.Products;
import com.onlineshop.entity.Variants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    @Autowired
    private ProductsDAO productsDAO;

    @Autowired
    private VariantsDAO variantsDAO;

    @Autowired
    private ImagesDAO imagesDAO;

    @GetMapping("")
    public String showAllProducts(Model model) {
        List<Products> productsList = productsDAO.getAllProducts();
        model.addAttribute("products", productsList);
        return "products";
    }

    @GetMapping("/{id}")
    public String showProductDetails(@PathVariable("id") int id, Model model) {
        System.out.println(id);
        Products product = productsDAO.getProductById(id);
        List<Variants> variantsList = variantsDAO.getByProductID(id);
        List<Images> imagesList = imagesDAO.getImagesByProductID(id);
        model.addAttribute("product", product);
        model.addAttribute("variants", variantsList);
        model.addAttribute("images", imagesList);
        return "product-detail";
    }
}
