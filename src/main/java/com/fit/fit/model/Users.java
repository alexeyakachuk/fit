package com.fit.fit.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Users {
    private final Integer id;
    private final String userName;
    private final String email;
    private final String password;
    // поле для записи времени регистрации
    private final LocalDateTime created_ad;
    // поле для записи времени изменения пользвователя
    private final LocalDateTime update_at;
}
