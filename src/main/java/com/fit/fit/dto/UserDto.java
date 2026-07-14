package com.fit.fit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fit.fit.model.User;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;
    private String userName;
    private String email;
//    private String password;
    // поле для записи времени регистрации
    private LocalDateTime createdAt;
    // поле для записи времени изменения пользвователя
    private LocalDateTime updatedAt;

    public UserDto(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
//        this.password = user.getPassword();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}
