package com.fit.fit.service;

import com.fit.fit.enums.Activity;
import com.fit.fit.enums.Gender;
import com.fit.fit.exception.IllegalArgumentException;
import com.fit.fit.exception.ValidationException;
import org.springframework.stereotype.Service;

@Service
public class Calculator {

    // метод для расчета калорий
    public int calorieCalculation(int weight, int height, int age, Activity activity, Gender gender) {
        //проверка, что возраст вес и рост указаны верно
        if (weight <= 0 || height <= 0 || age <= 0) {
            throw new ValidationException("Вес, рост и возраст должны быть больше 0");
        }

        // проверка, что пол указан пол и активность
        if (activity == null || gender == null) {
            throw new IllegalArgumentException("Укажите ваш пол и активность");
        }

        //Расчет BMR (базовый обмен веществ) по формуле Mifflin-St Jeor
        double bmr = switch (gender) {
            case MAN -> (10 * weight) + (6.25 * height) - (5 * age) + 5;
            case WOMAN -> (10 * weight) + (6.25 * height) - (5 * age) -161;
            default -> throw new IllegalArgumentException("Неизвестный пол: " + gender);
        };

        // Применение коэффициента активности (tdee - суточный общий расход энергии)
        double tdee = switch (activity) {
            case SEDENTARY -> bmr * 1.2;
            case MODERATE -> bmr * 1.55;
            case ACTIVE -> bmr * 1.725;
            default -> throw new IllegalArgumentException("Неизвестный уровень активности: " + activity);
        };

        return (int) Math.round(tdee);
    }
}
