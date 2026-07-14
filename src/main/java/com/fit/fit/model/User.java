package com.fit.fit.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @NotBlank(message = "Не может быть пустым")
    @Column(name = "password", nullable = false)
    private String password;
    // поле для записи времени регистрации
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    // поле для записи времени изменения пользвователя
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

// проверить будет ли создоватся время и обновлятся
    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now; // дата/время создания
        this.updatedAt = now;   // при создании обновление считается тем же, что и создание
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now(); // только дата/время обновления
    }
}

