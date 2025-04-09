package com.example.java_spring_mvc_laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.java_spring_mvc_laptopshop.domain.Product;
import com.example.java_spring_mvc_laptopshop.service.ProductService;
import com.example.java_spring_mvc_laptopshop.service.UploadService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getProductPage(Model model) {
        List<Product> products = this.productService.getAllProducts();
        model.addAttribute("products", products);
        return "/admin/product/show";
    }

    @GetMapping("/admin/product/{id}")
    public String detailProductPage(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "/admin/product/detail";
    }

    @GetMapping("/admin/product/create")
    public String createProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "/admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String postCreateProduct(Model model,
            @ModelAttribute("product") @Valid Product newProduct, BindingResult productBindingResult,
            @RequestParam("hoidanitFile") MultipartFile file) {

        List<FieldError> errors = productBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>>> " + error.getField() + " - " + error.getDefaultMessage());
        }

        // Validate
        if (productBindingResult.hasErrors()) {
            return "/admin/product/create";
        }

        String image = this.uploadService.handleSaveUploadFile(file, "product");

        newProduct.setImage(image);
        this.productService.handleSaveProduct(newProduct);

        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateProductPage(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "/admin/product/update";
    }

    @PostMapping("/admin/product/update")
    public String postUpdateProduct(Model model,
            @ModelAttribute("product") @Valid Product updateProduct,
            BindingResult productBindingResult,
            @RequestParam("hoidanitFile") MultipartFile file) {

        List<FieldError> errors = productBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(">>>> " + error.getField() + " - " + error.getDefaultMessage());
        }

        // Validate
        if (productBindingResult.hasErrors()) {
            return "/admin/product/update";
        }

        Product product = this.productService.getProductById(updateProduct.getId());

        if (product != null) {

            if (!file.isEmpty()) {
                String image = this.uploadService.handleSaveUploadFile(file, "product");
                product.setImage(image);
            }

            product.setName(updateProduct.getName());
            product.setPrice(updateProduct.getPrice());
            product.setDetailDesc(updateProduct.getDetailDesc());
            product.setShortDesc(updateProduct.getShortDesc());
            product.setQuantity(updateProduct.getQuantity());
            product.setFactory(updateProduct.getFactory());
            product.setTarget(updateProduct.getTarget());

            this.productService.handleSaveProduct(product);
        }

        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProductPage(Model model, @PathVariable long id) {

        Product product = new Product();
        product.setId(id);

        model.addAttribute("id", id);
        model.addAttribute("product", product);

        return "/admin/product/delete";
    }

    @PostMapping("/admin/product/delete")
    public String postDeleteProduct(Model model, @ModelAttribute("product") Product deleteProduct) {
        this.productService.deleteProductById(deleteProduct.getId());
        return "redirect:/admin/product";
    }

}
