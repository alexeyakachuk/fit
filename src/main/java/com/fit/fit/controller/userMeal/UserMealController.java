package com.fit.fit.controller.userMeal;

import com.fit.fit.dto.UserMealDto;
import com.fit.fit.service.UserMealService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/userMeal")
public class UserMealController {

    @Autowired
    private UserMealService service;

    @PostMapping
    public UserMealDto crete(@Valid @RequestBody CreateUserMealRequest newUser) {
        return service.create(newUser);
    }
}
