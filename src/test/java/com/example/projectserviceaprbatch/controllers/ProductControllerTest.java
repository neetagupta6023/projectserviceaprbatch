package com.example.projectserviceaprbatch.controllers;

import com.example.projectserviceaprbatch.exceptions.ProductLimitReachedException;
import com.example.projectserviceaprbatch.models.Product;
import com.example.projectserviceaprbatch.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;
    @MockBean
    ProductService productService;
    @Test
     void Test_WhenGetProductByIDCalled_ReturnProduct() throws ProductLimitReachedException {

         Product product = new Product();
         product.setId(2l);
         product.setTitle("Test Product");
         when(productService.getProductById(any(Long.class))).thenReturn(product);
         ResponseEntity<Product> responseEntity=productController.getProductById(2l);
         assertNotNull(responseEntity);
         assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
         assertEquals(2l,responseEntity.getBody().getId());
     }
}