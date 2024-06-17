package com.example.projectserviceaprbatch.services;

import com.example.projectserviceaprbatch.dtos.FakeStoreProductDto;
import com.example.projectserviceaprbatch.models.Category;
import com.example.projectserviceaprbatch.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class FakeProductService implements ProductService{

    RestTemplate restTemplate;
    public FakeProductService(RestTemplate template)
    {
        this.restTemplate=template;
    }
    @Override
    public Product getProductById(long id) {
        FakeStoreProductDto fakeProductDto=  restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
        return convertDtoToProduct(fakeProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    @Override
    public Product deleteProduct() {
        return null;
    }

    private   Product convertDtoToProduct(FakeStoreProductDto dto) {
        Product product = new Product();

        // Copy fields from FakeStoreProductDto to Product
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());

        // Create and set Category object
        Category category = new Category();
        category.setId(dto.getId());  // Assuming id in FakeStoreProductDto can be used for Category id
        category.setTitle(dto.getCategory());
        product.setCategory(category);

        return product;
    }
}
