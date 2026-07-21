package com.fit.fit.repository;

import com.fit.fit.dto.UserMealDto;
import com.fit.fit.model.UserMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserMealRepository extends JpaRepository<UserMeal, Integer> {

    @Query("SELECT um FROM UserMeal um WHERE um.mealDate >= :start AND um.mealDate <= :end AND um.user.id = :id")
    List<UserMeal> findAllFoodsForPeriod(@Param("id") Integer id,
                                         @Param("start") LocalDate start,
                                         @Param("end")LocalDate end);
}

