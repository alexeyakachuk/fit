package com.fit.fit.repository;

import com.fit.fit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByProductType(String productType);

    // Используем @Query вместо findByProductType
//    @Query("SELECT p FROM Product p WHERE p.productType = :productType")
    default List<Product> findAllProductType(String productType) {
        return findByProductType(productType);
    }
}


