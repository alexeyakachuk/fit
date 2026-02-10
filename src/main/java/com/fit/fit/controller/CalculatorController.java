package com.fit.fit.controller;

import com.fit.fit.enums.Activity;
import com.fit.fit.enums.Gender;
import com.fit.fit.service.Calculator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final Calculator calculator = new Calculator();

    @GetMapping("/calories")
    public String calculateCalories(
            @RequestParam int weight,
            @RequestParam int height,
            @RequestParam int age,
            @RequestParam Activity activity,
            @RequestParam Gender gender) {

        int result = calculator.calorieCalculation(weight, height, age, activity, gender);

        // Форматируем красивый текст
        return String.format(
                "расчет калорий:\n" +
                        " Вес: %d кг\n" +
                        " Рост: %d см\n" +
                        " Возраст: %d лет\n" +
                        " Активность: %s\n" +
                        " Пол: %s\n" +
                        " Результат: %d калорий/день",
                weight,
                height,
                age,
                activity.getLabel(),  // предполагаем, что у Activity есть метод getLabel()
                gender.getLabel(),    // аналогично для Gender
                result
        );
    }
}
