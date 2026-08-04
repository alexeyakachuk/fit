package com.fit.fit.service;

import com.fit.fit.controller.userMeal.CreateUserMealRequest;
import com.fit.fit.dto.UserMealDto;
import com.fit.fit.exception.NotFoundException;
import com.fit.fit.exception.ValidationException;
import com.fit.fit.model.Product;
import com.fit.fit.model.User;
import com.fit.fit.model.UserMeal;
import com.fit.fit.repository.UserMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserMealService {
    @Autowired
    private UserMealRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    //Создание записи употребленного продукта
    public UserMealDto create(CreateUserMealRequest newUserMeal) {

        User user = userService.findUser1(newUserMeal.getUserId());
        if (user == null) {
            throw new NotFoundException("Пользователь с id " + newUserMeal.getUserId() + " не найден");
        }

        Product product = productService.findProduct1(newUserMeal.getProductId());
        if (product == null) {
            throw new NotFoundException("Продукт с id " + newUserMeal.getProductId() + " не найден");
        }

        if (newUserMeal.getAmountGrams() <= 0) {
            throw new ValidationException("Количество граммов должно быть положительным числом");
        }
        UserMeal userMeal = new UserMeal();
        userMeal.setUser(user);
        userMeal.setProduct(product);
        userMeal.setAmountGrams(newUserMeal.getAmountGrams());
        userMeal.setMealType(newUserMeal.getMealType());
        if (newUserMeal.getMealDate() == null) {
            userMeal.setMealDate(LocalDate.now());
        } else {
            userMeal.setMealDate(newUserMeal.getMealDate());
        }

        repository.save(userMeal);
        return new UserMealDto(userMeal);
    }
    // получение всех съеденных продуктов за определенную дату
    public List<UserMealDto> findAllFoodsForPeriod(Integer id, LocalDate start, LocalDate end) {
        return repository.findAllFoodsForPeriod(id, start, end)
                .stream()
                .map(userMeal -> new UserMealDto(userMeal))
                .toList();
    }

    //Удоление
    public void delete (Integer id) {
        repository.deleteById(id);
    }

    //обновление
    public UserMealDto update(Integer id, CreateUserMealRequest newUserMeal) {
        UserMeal userMeal = repository.findById(id).orElseThrow(() -> new NotFoundException("Запись по id " + id + " не найдена"));
        Product product = productService.findProduct1(newUserMeal.getProductId());
        if (product == null) {
            throw new NotFoundException("Продукт с id " + newUserMeal.getProductId() + " не найден");
        }

        if (newUserMeal.getAmountGrams() <= 0) {
            throw new ValidationException("Количество граммов должно быть положительным числом");
        }

        userMeal.setProduct(product);

        userMeal.setAmountGrams(newUserMeal.getAmountGrams());
        userMeal.setMealType(newUserMeal.getMealType());
        if (newUserMeal.getMealDate() == null) {
            userMeal.setMealDate(LocalDate.now());
        } else {
            userMeal.setMealDate(newUserMeal.getMealDate());
        }

        return new UserMealDto(userMeal);
    }
}
