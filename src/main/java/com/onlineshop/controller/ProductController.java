package com.onlineshop.controller;

import com.onlineshop.entity.*;
import com.onlineshop.service.category.CategoryService;
import com.onlineshop.service.filter.FilterService;
import com.onlineshop.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/products")
  public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private FilterService filterService;

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
        List<FilterOption> filterOptions = filterService.getFilterOptionsByCategoryId(product.getCategoryId());
        List<ProductFilterValues> productFilterValues = filterService.getProductFilterValuesByProductId(Integer
                .parseInt(id));
        List<Integer> selectedValueIds = productFilterValues.stream()
                .map(ProductFilterValues::getValue_id)
                .toList();
        Map <String, List<FilterValue>> tableOptions = createTableOptions(filterOptions, productFilterValues);
        //todo передать список фильтров товара
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        model.addAttribute("tableOptions", tableOptions);
        model.addAttribute("productFilterValues", productFilterValues);
        model.addAttribute("selectedValueIds", selectedValueIds);
        return "product-detail";
    }

    private Map <String, List<FilterValue>> createTableOptions(List<FilterOption> filterOptions, List<ProductFilterValues> productFilterValues) {
        Map <String, List<FilterValue>> tableOptions = new HashMap<>();
        for (FilterOption filterOption : filterOptions) {
            tableOptions.put(filterOption.getName(), filterService.getFilterValueByIdFilterOption(filterOption.getId()));
        }
        return tableOptions;
    }


    @PostMapping("{id}/filters/save")
    public String saveFilters(@ModelAttribute("productFilterValues") List<ProductFilterValues> productFilterValues,
                              @ModelAttribute("selectedValueIds") List<Integer> selectedValueIds,
                              @PathVariable("id") int id)
    {

        List<ProductFilterValues> result = new ArrayList<>();
        for(int i = 0; i < productFilterValues.size(); i++) {
            productFilterValues.get(i).setOption_id(selectedValueIds.get(i));
            filterService.saveProductFilterValues(productFilterValues.get(i));
        }
        return "redirect:/admin/products/"+ id;
    }

    @PostMapping
    public String saveOrUpdate(@ModelAttribute("products") Products product) {
        productService.save(product);
        return "redirect:/admin/products/"+ product.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable ("id") String id) {
        productService.delete(Integer.parseInt(id));
        return "redirect:/admin/products";
    }

 }
