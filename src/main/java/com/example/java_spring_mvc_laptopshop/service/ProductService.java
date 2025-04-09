package com.example.java_spring_mvc_laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.java_spring_mvc_laptopshop.domain.Product;
import com.example.java_spring_mvc_laptopshop.domain.User;
import com.example.java_spring_mvc_laptopshop.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product handleSaveProduct(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product getProductById(long id) {
        return this.productRepository.findById(id);
    }

    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }
}
