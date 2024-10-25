package com.example.myfirstproductservice.services;

import com.example.myfirstproductservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> getAllProducts();
    public Product getASingleProduct(Long id);
    public Product AddAProduct(Product product);
    public void deleteAProduct(Long id);
    public Product replaceAProduct(Product product,Long id);
}
