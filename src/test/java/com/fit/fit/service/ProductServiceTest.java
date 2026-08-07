package com.fit.fit.service;

import com.fit.fit.controller.product.CreateProductRequest;
import com.fit.fit.dto.ProductDto;
import com.fit.fit.dto.UserDto;
import com.fit.fit.exception.NotFoundException;
import com.fit.fit.model.Product;
import com.fit.fit.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.tuple;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    public ProductService service;
    @Autowired
    public ProductRepository repository;

    public int productIdFirst;
    public int productIdSecond;

    @BeforeEach
    void cleanup() {
        repository.deleteAll();
        CreateProductRequest request = new CreateProductRequest("Овощи", "Огурец", 15.0,
                0.7, 0.2, 3.6);
        ProductDto productDto = service.create(request);
        productIdFirst = productDto.getId();

        request = new CreateProductRequest("Фрукты", "Яблоко", 52.0,
                0.3, 0.2, 13.8);
        productDto = service.create(request);
        productIdSecond = productDto.getId();
    }

    @Test
    public void createTest() {
        CreateProductRequest request = new CreateProductRequest("Рыба",
                "Лосось (сырой)", 180.0, 20.6, 8.5, 0.0);

        ProductDto product = service.create(request);

        assertThat(product).isNotNull();
        assertThat(product.getId()).isNotNull();
        assertThat(product.getProductType()).isEqualTo("Рыба");
        assertThat(product.getProductName()).isEqualTo("Лосось (сырой)");
        assertThat(product.getCalories()).isEqualTo(180.0);
        assertThat(product.getProtein()).isEqualTo(20.6);
        assertThat(product.getFat()).isEqualTo(8.5);
        assertThat(product.getCarbohydrate()).isEqualTo(0.0);
    }

    @Test
    public void findProductTest() {
        ProductDto product = service.findProduct(productIdFirst);

        assertThat(product).isNotNull();
        assertThat(product.getId()).isNotNull();
        assertThat(product.getProductType()).isEqualTo("Овощи");
        assertThat(product.getProductName()).isEqualTo("Огурец");
        assertThat(product.getCalories()).isEqualTo(15.0);
        assertThat(product.getProtein()).isEqualTo(0.7);
        assertThat(product.getFat()).isEqualTo(0.2);
        assertThat(product.getCarbohydrate()).isEqualTo(3.6);
    }

    @Test
    public void deleteProductTest() {
        service.deleteProduct(productIdFirst);

        assertThatThrownBy(() -> service.findProduct(productIdFirst))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Продукт с id " + productIdFirst + " не найден");

    }

    @Test
    public void findAllProductType() {
        List<Product> products = repository.findAllProductType("Овощи");
        assertThat(products)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .extracting(Product::getId ,Product::getProductType, Product::getProductName, Product::getCalories,
                        Product::getProtein, Product::getFat, Product::getCarbohydrate)
                .containsExactlyInAnyOrder(
                        tuple(productIdFirst, "Овощи", "Огурец", 15.0, 0.7, 0.2, 3.6)
                );

    }

}
