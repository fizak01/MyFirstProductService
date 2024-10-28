package com.example.myfirstproductservice.repositories;

import com.example.myfirstproductservice.models.Product;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    List<Product> findAll();

    @Override
    Optional<Product> findById(Long id);

    Product save(Product product);
}
