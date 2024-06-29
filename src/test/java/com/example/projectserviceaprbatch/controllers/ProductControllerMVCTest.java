package com.example.projectserviceaprbatch.controllers;

import com.example.projectserviceaprbatch.models.Product;
import com.example.projectserviceaprbatch.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

//@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProductController.class)
public class ProductControllerMVCTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    public void testGetProductById() throws Exception {
        // Mock data
        //Long productId = 1L;
        Product mockProduct = new Product();
        mockProduct.setPrice(100.0);
        mockProduct.setId(1l);
        mockProduct.setTitle("Test Product");

        // Stubbing the productService.getProductById(id) method
        when(productService.getProductById(1)).thenReturn(mockProduct);

        // Perform GET request
        mockMvc.perform(get("/products/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Test Product"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(100.0));
    }
}
