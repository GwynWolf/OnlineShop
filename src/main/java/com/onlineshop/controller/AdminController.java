package com.onlineshop.controller;

import com.onlineshop.dao.images.ImagesDAO;
import com.onlineshop.dao.order.OrderDAO;
import com.onlineshop.dao.product.ProductsDAO;
import com.onlineshop.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String adminPanel() {
        return "admin";
    }


}
