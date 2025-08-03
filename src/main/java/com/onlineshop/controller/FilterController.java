package com.onlineshop.controller;

import com.onlineshop.entity.Category;
import com.onlineshop.entity.FilterOption;
import com.onlineshop.entity.FilterValue;
import com.onlineshop.entity.Products;
import com.onlineshop.service.category.CategoryService;
import com.onlineshop.service.filter.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/filters")
public class FilterController {
    @Autowired
    private FilterService filterService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public String showAll(Model model) {
        List<FilterOption> filterOptionList = filterService.getAllFilterOptions();
        model.addAttribute("filterOptionList", filterOptionList);
        return "filters";
    }

    @GetMapping("/new")
    public String createOption(Model model)
    {
        FilterOption filterOption = new FilterOption();
        List<FilterValue> filterValueList = new ArrayList<FilterValue>();
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("filterOption", filterOption);
        model.addAttribute("filterValueList", filterValueList);
        model.addAttribute("categoryList", categoryList);
        return "filters-detail";
    }

    @GetMapping("/value/new")
    public void createValue(Model model)
    {
        FilterValue filterValue = new FilterValue();
        model.addAttribute("filterValue", filterValue);

    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") String id, Model model) {
        FilterOption filterOption = filterService.getFilterOptionById(Integer.parseInt(id));
        List<FilterValue> filterValueList = filterService.getFilterValueByIdFilterOption(Integer.parseInt(id));
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("filterOption", filterOption);
        model.addAttribute("filterValueList", filterValueList);
        model.addAttribute("categoryList", categoryList);
        return "filters-detail";
    }

    @PostMapping
    public String saveOrUpdateOption(@ModelAttribute("filterOption") FilterOption filterOption) {
         filterService.saveFilterOption(filterOption);
        return "redirect:/admin/filters/" + filterOption.getId();
    }

    @PostMapping("/value")
    public String saveOrUpdateValue(@ModelAttribute("filterValue") FilterValue filterValue)
    {
        filterService.saveFilterValue(filterValue);
        return "redirect:/admin/filters/" + filterValue.getOptionId();
    }

    @DeleteMapping("/{id}")
    public String deleteOption(@PathVariable ("id") String id) {
        List<FilterValue> filterValueList = filterService.getFilterValueByIdFilterOption(Integer.parseInt(id));
        filterService.deleteFilterOption(Integer.parseInt(id));
        for (FilterValue filterValue : filterValueList) {
            filterService.deleteFilterValue(filterValue.getId());
        }
        return "redirect:/admin/filters/"+id;
    }

    @DeleteMapping("/value/{id}")
    public String deleteValue(@PathVariable ("id") String id) {
        int optionID = filterService.getFilterValueById(Integer.parseInt(id)).getOptionId();
        filterService.deleteFilterValue(Integer.parseInt(id));
        System.out.println("delete " + optionID);
        return "redirect:/admin/filters/"+optionID;
    }
}
