package com.example.myfirstproductservice.controllers;

import com.example.myfirstproductservice.exceptions.ProductNotExistException;
import com.example.myfirstproductservice.models.Product;
import com.example.myfirstproductservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getASingleProduct(@PathVariable("id") Long id) throws ProductNotExistException {
        return productService.getASingleProduct(id);
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody Product product){
        return productService.AddAProduct(product);
    }

    @PutMapping("/{id}")
    public Product replaceAProduct(@RequestBody Product product,@PathVariable("id") Long id) throws ProductNotExistException {
        return productService.replaceAProduct(product,id);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) throws ProductNotExistException {
        productService.deleteAProduct(id);
    }
}
