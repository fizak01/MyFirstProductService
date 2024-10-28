package com.example.myfirstproductservice.services;

import com.example.myfirstproductservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
