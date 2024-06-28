package com.example.projectserviceaprbatch.controllers;

import com.example.projectserviceaprbatch.exceptions.ProductLimitReachedException;
import com.example.projectserviceaprbatch.models.Product;
import com.example.projectserviceaprbatch.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(@Qualifier("selfservice") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id)throws ProductLimitReachedException
    {
        if(id>=100)
        {
            throw new ProductLimitReachedException("There is a limit of 100");
        }
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }
    @GetMapping
    public List<Product> getProducts()
    {
        return productService.getAllProducts();
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product )
    {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductLimitReachedException {
        if(id>100)
        {
            throw new ProductLimitReachedException("There can be max of 100 items");
        } 
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product)
    {
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public Product deleteUpdate(@PathVariable("id") Long id)
    {
        return new Product();
    }

}
