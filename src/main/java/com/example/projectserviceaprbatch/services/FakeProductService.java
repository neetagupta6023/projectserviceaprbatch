package com.example.projectserviceaprbatch.services;

import com.example.projectserviceaprbatch.dtos.FakeStoreProductDto;
import com.example.projectserviceaprbatch.models.Category;
import com.example.projectserviceaprbatch.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
        FakeStoreProductDto[] fakeStoreProductDtoList= restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        List<Product> products=new ArrayList<Product>();
        for(FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtoList)
        {
            products.add(convertDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }

    @Override
    public Product updateProduct(Long id,Product product) {
        FakeStoreProductDto fakeStoreProductDto=convertProductToDto(product);
        fakeStoreProductDto=fakeStoreProductDto=restTemplate.patchForObject("https://fakestoreapi.com/products/" + id,fakeStoreProductDto,FakeStoreProductDto.class);
        return convertDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto=convertProductToDto(product);
        fakeStoreProductDto=restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDto,FakeStoreProductDto.class);
        return convertDtoToProduct(fakeStoreProductDto);
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

    private FakeStoreProductDto convertProductToDto(Product product)
    {
        if(product==null)
            return null;
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setPrice(product.getPrice());
        if(product.getCategory()!=null)
            fakeStoreProductDto.setCategory(product.getCategory().getTitle());
        else
            fakeStoreProductDto.setCategory(null);
        return fakeStoreProductDto;
    }
}
