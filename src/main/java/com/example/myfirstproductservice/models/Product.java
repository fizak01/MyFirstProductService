package com.example.myfirstproductservice.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private Long id;
    private String title;
    private Double price;
    private Category category;
    private String description;
    private String image;
}
