package com.example.projectserviceaprbatch.services;

import com.example.projectserviceaprbatch.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(long id);
    public List<Product> getAllProducts();
    public Product updateProduct(Long id,Product product);
    public Product createProduct(Product product);
    public Product replaceProduct();
    public Product deleteProduct();

}
