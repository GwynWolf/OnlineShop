package com.onlineshop.controller;

import com.onlineshop.entity.CategoryNode;
import com.onlineshop.entity.Category;
import com.onlineshop.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllCategories(Model model) {
        List<Category> all = categoryService.getAll();
        List<CategoryNode> tree = categoryService.buildCategoryTree(all);
        model.addAttribute("categoryTree", tree);
        return "categories/list";
    }

    @GetMapping("/new")
    public String newCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("allCategories", categoryService.getAll());
        return "categories/form";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/edit")
    public String editCategory(@RequestParam("id") int id, Model model) {
        model.addAttribute("category", categoryService.get(id));
        model.addAttribute("allCategories", categoryService.getAll());
        return "categories/form";
    }

    @GetMapping("/delete")
    public String deleteCategory(@RequestParam("id") int id) {
        categoryService.delete(id);
        return "redirect:/admin/categories";
    }
}
