package com.fit.fit.controller.userMeal;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NonNull;

import java.time.LocalDate;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate mealDate;

    public CreateUserMealRequest(@NonNull Integer userId, @NonNull Integer amountGrams, @NonNull Integer productId,
                                 @NonNull String mealType, LocalDate mealDate) {
        this.userId = userId;
        this.amountGrams = amountGrams;
        this.productId = productId;
        this.mealType = mealType;
        this.mealDate = mealDate;
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

    public LocalDate getMealDate() {
        return mealDate;
    }

    public void setMealDate(LocalDate mealDate) {
        this.mealDate = mealDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CreateUserMealRequest that = (CreateUserMealRequest) o;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getProductId(), that.getProductId()) && Objects.equals(getAmountGrams(), that.getAmountGrams()) && Objects.equals(getMealType(), that.getMealType()) && Objects.equals(getMealDate(), that.getMealDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getProductId(), getAmountGrams(), getMealType(), getMealDate());
    }

    @Override
    public String toString() {
        return "CreateUserMealRequest{" +
                "userId=" + userId +
                ", productId=" + productId +
                ", amountGrams=" + amountGrams +
                ", mealType='" + mealType + '\'' +
                ", mealDate=" + mealDate +
                '}';
    }
}
