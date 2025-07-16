package com.onlineshop.controller;

import com.onlineshop.dto.CategoryCreateDto;
import com.onlineshop.entity.CategoryNode;
import com.onlineshop.entity.Category;
import jakarta.validation.Valid;
import com.onlineshop.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getAllCategories(
            @RequestParam(value = "visible", required = false) Boolean visible,
            @RequestParam(value = "parentId", required = false) Long parentId) {
        return categoryService.find(visible, parentId);
    }

    @GetMapping(value = "/tree", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryNode> getCategoryTree(
            @RequestParam(value = "visible", required = false) Boolean visible,
            @RequestParam(value = "parentId", required = false) Long parentId
    ) {
        return categoryService.getCategoryTree(visible, parentId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id) {
        Category category = categoryService.get(id);
        if (category == null || Boolean.FALSE.equals(category.getVisible())) {
            throw new RuntimeException("Category not found or deactivated");
        }
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryCreateDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setParentId(dto.getParentId());
        category.setVisible(dto.getVisible());
        category.setUrl(dto.getUrl());

        categoryService.save(category);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") long id,
                                                   @Valid @RequestBody Category updatedCategory) {
        Category existing = categoryService.get(id);
        if (existing == null) {
            throw new RuntimeException("Category not found");
        }
        existing.setName(updatedCategory.getName());
        existing.setParentId(updatedCategory.getParentId());
        existing.setVisible(updatedCategory.getVisible());

        categoryService.save(existing);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") long id) {
        Category category = categoryService.get(id);
        if (category == null) {
            throw new RuntimeException("Category not found");
        }
        category.setVisible(false);
        categoryService.save(category);
    }
}
