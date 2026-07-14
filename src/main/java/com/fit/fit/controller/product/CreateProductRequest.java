package com.fit.fit.controller.product;


import lombok.NonNull;

import java.util.Objects;

public class CreateProductRequest {
    @NonNull
    private String productType;
    @NonNull
    private String productName;
    @NonNull
    private Double calories;
    @NonNull
    private Double protein;
    @NonNull
    private Double fat;
    @NonNull
    private Double carbohydrate;

    public CreateProductRequest(String productType, String productName, Double calories, Double protein, Double fat, Double carbohydrate) {
        this.productType = productType;
        this.productName = productName;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrate = carbohydrate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CreateProductRequest that = (CreateProductRequest) o;
        return Objects.equals(getProductType(), that.getProductType()) && Objects.equals(getProductName(), that.getProductName()) && Objects.equals(getCalories(), that.getCalories()) && Objects.equals(getProtein(), that.getProtein()) && Objects.equals(getFat(), that.getFat()) && Objects.equals(getCarbohydrate(), that.getCarbohydrate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductType(), getProductName(), getCalories(), getProtein(), getFat(), getCarbohydrate());
    }

    @Override
    public String toString() {
        return "CreateProductRequest{" +
                "productType='" + productType + '\'' +
                ", productName='" + productName + '\'' +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}
