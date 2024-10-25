package com.example.myfirstproductservice.services;

import com.example.myfirstproductservice.dtos.FakeStoreProductDto;
import com.example.myfirstproductservice.models.Category;
import com.example.myfirstproductservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService{
    private RestTemplate restTemplate;
    public FakeStoreCategoryService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    private Category convertStringToCategory(String cat){
        Category category = new Category();
        category.setName(cat);
        return category;
    }
    private Product convertProductDtoToProduct(FakeStoreProductDto dto){
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());
        Category category = new Category();
        category.setName(dto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public List<Category> getAllCategories() {
        String[] categories = restTemplate.getForObject("https://fakestoreapi.com/products/categories", String[].class);
        List<Category> category = new ArrayList<>();
        for(String cat:categories){
            category.add(convertStringToCategory(cat));
        }
        return category;
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        FakeStoreProductDto[] dto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/category/" + category, FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto:dto){
            products.add(convertProductDtoToProduct(fakeStoreProductDto));
        }
        return products;
    }
}
