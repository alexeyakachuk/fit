package com.fit.fit.dto;

import com.fit.fit.model.Product;
import lombok.Data;

@Data

public class ProductDto {
    private String productType;
    private String productName;
    private Double calories;
    private Double protein;
    private Double fat;
    private Double carbohydrate;

    public ProductDto(Product product) {
        this.productType = product.getProductType();
        this.productName = product.getProductName();
        this.calories = product.getCalories();
        this.protein = product.getProtein();
        this.fat = product.getFat();
        this.carbohydrate = product.getCarbohydrate();
    }
}
