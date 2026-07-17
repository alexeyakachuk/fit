package com.fit.fit.repository.userMeal;

import com.fit.fit.dto.UserMealDto;
import com.fit.fit.model.UserMeal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UserMealRepository extends JpaRepository<UserMeal, Integer> {

    List<UserMealDto> findAllFoodsForPeriod(Integer id, LocalDate start, LocalDate end);
}
