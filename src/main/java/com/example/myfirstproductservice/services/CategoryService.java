package com.example.myfirstproductservice.services;


import com.example.myfirstproductservice.models.Category;
import com.example.myfirstproductservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public List<Category> getAllCategories();
    public List<Product> getProductByCategory(String category);
}
