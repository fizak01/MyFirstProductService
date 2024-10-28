package com.example.myfirstproductservice.controllers;

import com.example.myfirstproductservice.models.Category;
import com.example.myfirstproductservice.models.Product;
import com.example.myfirstproductservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping("/categories")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{category}")
    public List<Product> getAllProductUsingCategory(@PathVariable("category") String category){
        return categoryService.getProductByCategory(category);
    }
}
