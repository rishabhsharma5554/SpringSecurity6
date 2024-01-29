package com.rishabh.springcloud.controllers;

import com.rishabh.springcloud.entity.Product;
import com.rishabh.springcloud.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productapi")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product)
    {
        return productRepo.save(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct()
    {
        return productRepo.findAll();
    }
}
