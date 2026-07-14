package com.fit.fit.controller.userMeal;

import lombok.NonNull;

import java.util.Objects;

public class CreateUserMealRequest {
    @NonNull
    private Integer userId;
    @NonNull
    private Integer productId;
    @NonNull
    private Integer amountGrams;
    @NonNull
    private String mealType;

    public CreateUserMealRequest(@NonNull Integer userId, @NonNull Integer amountGrams, @NonNull Integer productId, @NonNull String mealType) {
        this.userId = userId;
        this.amountGrams = amountGrams;
        this.productId = productId;
        this.mealType = mealType;
    }

    public @NonNull Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
    }

    public @NonNull Integer getAmountGrams() {
        return amountGrams;
    }

    public void setAmountGrams(@NonNull Integer amountGrams) {
        this.amountGrams = amountGrams;
    }

    public @NonNull Integer getProductId() {
        return productId;
    }

    public void setProductId(@NonNull Integer productId) {
        this.productId = productId;
    }

    public @NonNull String getMealType() {
        return mealType;
    }

    public void setMealType(@NonNull String mealType) {
        this.mealType = mealType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CreateUserMealRequest that = (CreateUserMealRequest) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getProductId(), that.getProductId()) && Objects.equals(getAmountGrams(), that.getAmountGrams()) && Objects.equals(getMealType(), that.getMealType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getProductId(), getAmountGrams(), getMealType());
    }

    @Override
    public String toString() {
        return "CreateUserMealRequest{" +
                "userId=" + userId +
                ", productId=" + productId +
                ", amountGrams=" + amountGrams +
                ", mealType='" + mealType + '\'' +
                '}';
    }
}
