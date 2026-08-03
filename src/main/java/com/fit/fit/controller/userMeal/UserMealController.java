package com.fit.fit.controller.userMeal;

import com.fit.fit.dto.UserMealDto;
import com.fit.fit.service.UserMealService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/userMeal")
public class UserMealController {

    @Autowired
    private UserMealService service;

    @PostMapping
    public UserMealDto crete(@Valid @RequestBody CreateUserMealRequest newUser) {
        return service.create(newUser);
    }

    @PostMapping("/forgotten")
    public UserMealDto createForgotten(@Valid @RequestBody CreateUserMealRequest newUser) {
        return service.create(newUser);

    }


    @GetMapping("/by-period")
    public List<UserMealDto> findAllFoodsForPeriod(
            @RequestParam Integer id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return service.findAllFoodsForPeriod(id, start, end);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        service.delete(id);
    }
}
