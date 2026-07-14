package com.fit.fit.dto;

import com.fit.fit.model.Product;
import com.fit.fit.model.User;
import com.fit.fit.model.UserMeal;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

public class UserMealDto {
    private User user;
    private Product product;
    private Integer amountGrams;
    private String mealType;
    private LocalDate mealDate;

    public UserMealDto(UserMeal userMeal) {
        this.user = userMeal.getUser();
        this.product = userMeal.getProduct();
        this.amountGrams = userMeal.getAmountGrams();
        this.mealType = userMeal.getMealType();
        this.mealDate = userMeal.getMealDate();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmountGrams() {
        return amountGrams;
    }

    public void setAmountGrams(Integer amountGrams) {
        this.amountGrams = amountGrams;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public LocalDate getMealDate() {
        return mealDate;
    }

    public void setMealDate(LocalDate mealDate) {
        this.mealDate = mealDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserMealDto that = (UserMealDto) o;
        return Objects.equals(getUser(), that.getUser()) && Objects.equals(getProduct(), that.getProduct()) && Objects.equals(getAmountGrams(), that.getAmountGrams()) && Objects.equals(getMealType(), that.getMealType()) && Objects.equals(getMealDate(), that.getMealDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getProduct(), getAmountGrams(), getMealType(), getMealDate());
    }

    @Override
    public String toString() {
        return "UserMealDto{" +
                "user=" + user +
                ", product=" + product +
                ", amountGrams=" + amountGrams +
                ", mealType='" + mealType + '\'' +
                ", mealDate=" + mealDate +
                '}';
    }
}
