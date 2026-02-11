package com.fit.fit.service;

import com.fit.fit.enums.Activity;
import com.fit.fit.enums.Gender;
import com.fit.fit.exception.IllegalArgumentException;
import com.fit.fit.exception.ValidationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorTest {

    @Autowired
    public Calculator calculator;

    @Test
    public void calorieCalculationManTest() {
        int result = calculator.calculateCalories(80, 180, 30, Activity.MODERATE, Gender.MAN);
        assertEquals(2759, result,
                "Расчёт калорий для мужчины с умеренной активностью должен быть ~2759");

    }

    //проверка исключения на вес
    @Test
    public void calorieCalculationWeightTest() {
        ValidationException exception = assertThrows(
                ValidationException.class, () ->
                        calculator.calculateCalories(-80, 180, 30, Activity.MODERATE, Gender.MAN));
        assertEquals("Вес, рост и возраст должны быть больше 0", exception.getMessage());
    }

    // проверка исключения на рост
    @Test
    public void calorieCalculationHeightTest() {
        ValidationException exception = assertThrows(
                ValidationException.class, () ->
                        calculator.calculateCalories(80, -180, 30, Activity.MODERATE, Gender.MAN));
        assertEquals("Вес, рост и возраст должны быть больше 0", exception.getMessage());
    }

    // Проверка исключения на возраст
    @Test
    public void calorieCalculationAgeTest() {
        ValidationException exception = assertThrows(
                ValidationException.class, () ->
                        calculator.calculateCalories(80, 180, -30, Activity.MODERATE, Gender.MAN));
        assertEquals("Вес, рост и возраст должны быть больше 0", exception.getMessage());
    }

    // проверка что указана активность
    @Test
    public void calorieCalculationActivityTest() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () ->
                        calculator.calculateCalories(80, 180, 30, null, Gender.MAN));
        assertEquals("Укажите ваш пол и активность", exception.getMessage());

    }

    // Проверка что указан пол
    @Test
    public void calorieCalculationGenderTest() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, () ->
                        calculator.calculateCalories(80, 180, 30, Activity.MODERATE, null));
        assertEquals("Укажите ваш пол и активность", exception.getMessage());
    }
}