package com.fit.fit.service;

import com.fit.fit.controller.userMeal.CreateUserMealRequest;
import com.fit.fit.dto.UserMealDto;
import com.fit.fit.model.Product;
import com.fit.fit.model.User;
import com.fit.fit.model.UserMeal;
import com.fit.fit.repository.userMeal.UserMealRepository;
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

        Product product = productService.findProduct1(newUserMeal.getProductId());

        UserMeal userMeal = new UserMeal();
        userMeal.setUser(user);
        userMeal.setProduct(product);
        userMeal.setAmountGrams(newUserMeal.getAmountGrams());
        userMeal.setMealType(newUserMeal.getMealType());

//        repository.save(userMeal);
        return new UserMealDto(userMeal);
    }

    // получение всех съеденных продуктов за определенную дату
    public List<UserMealDto> findAllFoodsForPeriod(Integer id, LocalDate start, LocalDate end) {
        return null;
    }

}
