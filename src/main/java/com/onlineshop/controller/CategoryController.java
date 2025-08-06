package com.onlineshop.controller;

import com.onlineshop.dto.category.CategoryCreateDto;
import com.onlineshop.dto.category.CategoryDto;
import com.onlineshop.entity.CategoryNode;
import com.onlineshop.service.category.CategoryReadService;
import com.onlineshop.service.category.CategoryWriteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/categories")
public class CategoryController {

    @Autowired
    private CategoryReadService categoryReadService;
    @Autowired
    private CategoryWriteService categoryWriteService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryDto> getAllCategories(
            @RequestParam(value = "visible", required = false) Boolean visible,
            @RequestParam(value = "parentId", required = false) Long parentId) {
        return categoryReadService.find(visible, parentId);
    }

    @GetMapping(value = "/tree", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryNode> getCategoryTree(
            @RequestParam(value = "visible", required = false) Boolean visible,
            @RequestParam(value = "parentId", required = false) Long parentId
    ) {
        return categoryReadService.getCategoryTree(visible, parentId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") long id) {
        CategoryDto dto = categoryReadService.get(id);
        if (dto == null || Boolean.FALSE.equals(dto.getVisible())) {
            throw new RuntimeException("Category not found or deactivated");
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Void> createCategory(@Valid @RequestBody CategoryCreateDto dto) {
        categoryWriteService.save(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCategory(@PathVariable("id") long id,
                                               @Valid @RequestBody CategoryCreateDto dto) {
        categoryWriteService.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") long id) {
        categoryWriteService.delete(id);
        return ResponseEntity.ok().build();
    }
}
