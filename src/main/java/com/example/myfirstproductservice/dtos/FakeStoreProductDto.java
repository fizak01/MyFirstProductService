package com.example.myfirstproductservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private Double price;
    private String Category;
    private String description;
    private String image;
}
