package com.fit.fit.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.fit.fit.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@Builder// Узнать для чего нужны три ниже аннотации
@AllArgsConstructor
@NoArgsConstructor
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
