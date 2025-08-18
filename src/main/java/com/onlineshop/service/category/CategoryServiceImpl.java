package com.onlineshop.service.category;

import com.onlineshop.dao.category.CategoryDAO;
import com.onlineshop.dto.category.CategoryCreateDto;
import com.onlineshop.dto.category.CategoryDto;
import com.onlineshop.entity.CategoryNode;
import com.onlineshop.entity.Category;
import com.onlineshop.mapper.CategoryMapper;
import com.onlineshop.util.CategoryTreeBuilder;
import com.onlineshop.util.SlugUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryReadService, CategoryWriteService {

    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private CategoryTreeBuilder categoryTreeBuilder;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryDAO.getAllCategories();
        return categories.stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDto> getAllIncludingHidden() {
        return categoryDAO.getAllCategoriesIncludingHidden()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(CategoryCreateDto dto) {
        Category category = categoryMapper.toEntity(dto);
        try {
            if (category.getSlug() == null || category.getSlug().isBlank()) {
                String baseSlug = SlugUtil.toSlug(category.getName());
                String uniqueSlug = baseSlug;
                long suffix = 1;
                while (categoryDAO.slugExists(uniqueSlug)) {
                    uniqueSlug = baseSlug + "-" + suffix++;
                }
                category.setSlug(uniqueSlug);
            }
            if (category.getParentId() != null && category.getParentId() != 0L) {
                Category parent = categoryDAO.getCategory(dto.getParentId().intValue());
                if (parent == null) {
                    throw new IllegalArgumentException("Parent category with ID " + dto.getParentId() + " does no exist.");
                }
            }
            categoryDAO.saveCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    @Transactional
    public void update(long id, CategoryCreateDto dto) {
        Category existing = findEntityByIdOrThrow(id);

        existing.setName(dto.getName());
        existing.setParentId(dto.getParentId());
        existing.setVisible(dto.getVisible());
        existing.setUrl(dto.getUrl());

        String baseSlug = SlugUtil.toSlug(existing.getName());
        String uniqueSlug = baseSlug;
        long suffix = 1;
        while (categoryDAO.slugExists(uniqueSlug)) {
            uniqueSlug = baseSlug + "-" + suffix++;
        }
        existing.setSlug(uniqueSlug);
        categoryDAO.saveCategory(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDto get(long id) {

        return findByIdOrThrow(id);
    }

    @Override
    @Transactional
    public void delete(long id) {
        categoryDAO.deleteCategory(id);
    }

    @Override
    @Transactional
    public List<CategoryDto> find(Boolean visible, Long parentId) {
        return categoryDAO.findCategories(visible, parentId)
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryNode> getCategoryTree(Boolean visible, Long parentId) {
        List<CategoryDto> categoryDtos = find(visible, null);

        List<Category> categories = categoryDtos.stream()
                .map(categoryMapper::toEntity)
                .collect(Collectors.toList());

        List<CategoryNode> fullTree = categoryTreeBuilder.buildCategoryTree(categories);

        if (parentId != null) {
            CategoryNode subtree = categoryTreeBuilder.findSubtreeNode(fullTree, parentId);
            return subtree != null ? List.of(subtree) : List.of();
        }
        return fullTree;
    }

    private CategoryDto findByIdOrThrow(long id) {
        Category category = categoryDAO.getCategory(id);
        if (category == null) {
            throw new RuntimeException("Category not found");
        }
        return categoryMapper.toDto(category);
    }

    private Category findEntityByIdOrThrow(long id) {
        Category category = categoryDAO.getCategory(id);
        if (category == null) {
            throw new RuntimeException("Category not found");
        }
        return category;
    }
}
