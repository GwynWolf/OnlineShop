package com.onlineshop.controller;

import com.onlineshop.entity.Products;
import com.onlineshop.entity.Variants;
import com.onlineshop.service.variants.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/variant")
public class VariantController {

    @Autowired
    private VariantService variantService;

    @PostMapping
    private String add(Model model)
    {
        Variants variant = new Variants();
        model.addAttribute("variant", variant);
        return "variant-detail";
    }

    @PutMapping
    public String update(@ModelAttribute("variant") Variants variant, @PathVariable int id) {
        variantService.update(variant);
        return "redirect:/admin/products";
    }

    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("id") int id) {
        int productID = variantService.getById(id).getProductId();
        variantService.delete(id);
        return "redirect:/admin/products" + productID;
    }
}
