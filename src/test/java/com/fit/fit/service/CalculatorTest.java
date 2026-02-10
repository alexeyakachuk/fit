package com.fit.fit.service;

import com.fit.fit.enums.Activity;
import com.fit.fit.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void calorieCalculationManTest() {
        int result = calculator.calorieCalculation(80, 180, 30, Activity.MODERATE, Gender.MAN);
        assertEquals(2759, result, "Расчёт калорий для мужчины с умеренной активностью должен быть ~2759");
    }
}
