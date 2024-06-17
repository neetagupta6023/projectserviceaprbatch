package com.example.projectserviceaprbatch.controllers;

import com.example.projectserviceaprbatch.models.Product;
import com.example.projectserviceaprbatch.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id)
    {
        return productService.getProductById(id);
    }
    @GetMapping
    public List<Product> getProducts()
    {
        return new ArrayList<Product>();
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product )
    {
        return new Product();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product)
    {
        return new Product();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product)
    {
        return new Product();
    }

    @DeleteMapping("/{id}")
    public Product deleteUpdate(@PathVariable("id") Long id)
    {
        return new Product();
    }

}
