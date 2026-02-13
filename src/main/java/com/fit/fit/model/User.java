package com.fit.fit.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
@Data
@Builder
public class User {
    private final Integer id;
    @NonNull
    private final String userName;
    @NonNull
    @Email
    private final String email;
    @NonNull
    @NotBlank(message = "Не может быть пустым")
    private final String password;
    // поле для записи времени регистрации
    private final LocalDateTime created_ad;
    // поле для записи времени изменения пользвователя
    private final LocalDateTime update_at;
}
