package com.fit.fit.repository;

import com.fit.fit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT email FROM User u WHERE u.email = :email")
    String findEmail(String email);

}
