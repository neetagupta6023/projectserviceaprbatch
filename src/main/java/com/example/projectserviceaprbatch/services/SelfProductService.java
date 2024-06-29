package com.example.projectserviceaprbatch.services;

import com.example.projectserviceaprbatch.models.Category;
import com.example.projectserviceaprbatch.models.Product;
import com.example.projectserviceaprbatch.repos.CategoryRepos;
import com.example.projectserviceaprbatch.repos.ProductRepos;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Primary
@Service("selfservice")
public class SelfProductService implements ProductService{
    private final ProductRepos productRepos;
    private CategoryRepos categoryRepos;
    public SelfProductService(ProductRepos productRepos, CategoryRepos categoryRepos) {
        this.productRepos=productRepos;
        this.categoryRepos=categoryRepos;
    }
    @Override
    public Product getProductById(long id) {
        Optional<Product> product=productRepos.findById(id);
        if(product.isEmpty())
        {
            throw new EntityNotFoundException("Product not found");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
       /* Category category=product.getCategory();
        if(category.getId()==null)
        {
            Category savedCategory=categoryRepos.save(category);
            product.setCategory(savedCategory);
        } */
        return productRepos.save(product);
    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    @Override
    public Product deleteProduct() {
        return null;
    }
}
