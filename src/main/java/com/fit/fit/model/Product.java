package com.fit.fit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "product_type", nullable = false)
    private String productType;
    @NonNull
    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;
    @NonNull
    @Min(value = 0, message = "Calories cannot be negative")
    @Column(name = "calories", nullable = false)
    private Double calories;
    @NonNull
    @Min(value = 0, message = "Proteins cannot be negative")
    @Column(name = "proteins", nullable = false)
    private Double protein;
    @NonNull
    @Min(value = 0, message = "Fats cannot be negative")
    @Column(name = "fat", nullable = false)
    private Double fat;
    @NonNull
    @Min(value = 0, message = "Carbohydrates cannot be negative")
    @Column(name = "carbohydrates", nullable = false)
    private Double carbohydrate;
}
