package com.example.myfirstproductservice.services;

import com.example.myfirstproductservice.dtos.FakeStoreProductDto;
import com.example.myfirstproductservice.models.Category;
import com.example.myfirstproductservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    @Autowired
    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
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
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        List<Product> products  = new ArrayList<>();
        for(FakeStoreProductDto dto : fakeStoreProductDtos){
            products.add(convertProductDtoToProduct(dto));
        }
        return products;
    }

    @Override
    public Product getASingleProduct(Long id) {
        FakeStoreProductDto productDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        return convertProductDtoToProduct(productDto);
    }

    @Override
    public Product AddAProduct(Product product) {
        FakeStoreProductDto dto = new FakeStoreProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setImage(product.getImage());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory().getName());
        FakeStoreProductDto fakeStoreProductDto = restTemplate.postForObject("https://fakestoreapi.com/products" ,dto,
                FakeStoreProductDto.class);
        return convertProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public void deleteAProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/"+id);
    }

    @Override
    public Product replaceAProduct(Product product, Long id) {
        FakeStoreProductDto dto = new FakeStoreProductDto();
        if(product.getId()!=null) dto.setId(product.getId());
        if(product.getTitle()!=null) dto.setTitle(product.getTitle());
        if(product.getPrice()!=null)dto.setPrice(product.getPrice());
        if(product.getImage()!=null)dto.setImage(product.getImage());
        if(product.getDescription()!=null)dto.setDescription(product.getDescription());
        if(product.getCategory().getName()!=null)dto.setCategory(product.getCategory().getName());
        FakeStoreProductDto fakeStoreProductDto = restTemplate.patchForObject("https://fakestoreapi.com/products/"+id,dto,FakeStoreProductDto.class);
        return convertProductDtoToProduct(fakeStoreProductDto);
    }

}
