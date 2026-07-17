package com.fit.fit.model;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "user_meal")
public class UserMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Column(name = "amount_grams", nullable = false)
    private Integer amountGrams;
    @Column(name = "meal_type", nullable = false)
    private String mealType;
    @Column(name = "meal_date", nullable = false)
    private LocalDate mealDate;

    public UserMeal(User user, Product product, Integer amountGrams, String mealType, LocalDate mealDate) {
        this.user = user;
        this.product = product;
        this.amountGrams = amountGrams;
        this.mealType = mealType;
        this.mealDate = mealDate;
    }

    public UserMeal() {
        this.mealDate = LocalDate.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        UserMeal userMeal = (UserMeal) o;
        return Objects.equals(getId(), userMeal.getId()) && Objects.equals(getUser(), userMeal.getUser()) && Objects.equals(getProduct(), userMeal.getProduct()) && Objects.equals(getAmountGrams(), userMeal.getAmountGrams()) && Objects.equals(getMealType(), userMeal.getMealType()) && Objects.equals(getMealDate(), userMeal.getMealDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getProduct(), getAmountGrams(), getMealType(), getMealDate());
    }

//    @PrePersist
//    protected void onCreate() {
//        this.mealDate = LocalDate.now();
//    }

        @Override
    public String toString() {
        return "UserMeal{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", amountGrams=" + amountGrams +
                ", mealType='" + mealType + '\'' +
                ", mealDate=" + mealDate +
                '}';
    }
}
