package com.example.java_spring_mvc_laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.java_spring_mvc_laptopshop.domain.Product;

@Controller
public class ProductController {

    @GetMapping("/admin/product")
    public String getProductPage() {
        return "/admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String createProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "/admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String postCreateProduct(Model model, @ModelAttribute("product") Product newProduct) {

        return "redirect:/admin/product";
    }

}
