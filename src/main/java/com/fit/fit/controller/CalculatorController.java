package com.fit.fit.controller;

import com.fit.fit.enums.Activity;
import com.fit.fit.enums.Gender;
import com.fit.fit.model.CalculatorRequest;
import com.fit.fit.service.Calculator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final Calculator calculator = new Calculator();

    @PostMapping("/calories")
    public String calculateCalories(@RequestBody CalculatorRequest request) {

        int result = calculator.calculateCalories(
                request.getWeight(),
                request.getHeight(),
                request.getAge(),
                request.getActivity(),
                request.getGender()
        );

        // Форматируем красивый текст
        return String.format(
                "расчет калорий:\n" +
                        " Вес: %d кг\n" +
                        " Рост: %d см\n" +
                        " Возраст: %d лет\n" +
                        " Активность: %s\n" +
                        " Пол: %s\n" +
                        " Результат: %d калорий/день",
                request.getWeight(),
                request.getHeight(),
                request.getAge(),
                request.getActivity().getLabel(),
                request.getGender().getLabel(),
                result
        );
    }
}
