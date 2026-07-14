package com.fit.fit.controller.product;

import com.fit.fit.dto.product.ProductDto;
import com.fit.fit.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {
    @Autowired
    private ProductService service;

    //Создание продукта
    @PostMapping
    public ProductDto create(@Valid @RequestBody CreateProductRequest newProduct) {return service.create(newProduct);
    }

    //Возвращение продукта по id
    @GetMapping("/{id}")
    public ProductDto findProduct(@PathVariable Integer id, HttpServletRequest request) {
        return service.findProduct(id);
    }

    //Возвращение продуктов по категории
    @GetMapping("/by-type/{productType}")
    public List<ProductDto> findAllProductType(@PathVariable String productType, HttpServletRequest request) {
        return service.findAllProductType(productType);
    }

    //Удаление продукта
    @DeleteMapping("{id}")
    private void deleteProduct(@PathVariable Integer id) {
        service.deleteProduct(id);
    }
}
