package com.fit.fit.controller.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    //    private Integer id;
    @NonNull
    private String userName;
    @Email
    private String email;
    //    @NonNull
    private String password;
}
