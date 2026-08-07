package com.fit.fit.service;

import com.fit.fit.controller.product.CreateProductRequest;
import com.fit.fit.dto.ProductDto;
import com.fit.fit.exception.NotFoundException;
import com.fit.fit.model.Product;
import com.fit.fit.model.User;
import com.fit.fit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    //Создание продукта
    public ProductDto create(CreateProductRequest newProduct) {
        Product product = Product.builder()
                .productType(newProduct.getProductType())
                .productName(newProduct.getProductName())
                .calories(newProduct.getCalories())
                .protein(newProduct.getProtein())
                .fat(newProduct.getFat())
                .carbohydrate(newProduct.getCarbohydrate())
                .build();
        Product save = repository.save(product);
        return new ProductDto(save);
    }

    //Возвращение продукта по id
    public ProductDto findProduct(Integer id) {
        Product product = repository.findById(id).orElseThrow(() ->
                new NotFoundException("Продукт с id " + id + " не найден"));
        return new ProductDto(product);
    }

    //Возвращение все продуктов по категории
//    public List<ProductDto> findAllProductType(String productType) {
//        List<Product> products = repository.findByProductType(productType);
//        return products.stream().map(ProductDto::new).toList();
//    }

    //Возвращение все продуктов по категории вариант с query
    public List<ProductDto> findAllProductType(String productType) {
        List<Product> products = repository.findAllProductType(productType);
        return products.stream().map(ProductDto::new).toList();
    }

    //Удоление продукта по id
    public void deleteProduct(Integer id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Продукт с id " + id + " не найден");
        }
        repository.deleteById(id);
    }

    // приватный метод для ghjlernf user по id
    protected Product findProduct1(Integer id) {
        Product product = repository.findById(id).orElseThrow(() -> new NotFoundException("Продукт с id " + id + " не найден"));
        return product;
    }
}
