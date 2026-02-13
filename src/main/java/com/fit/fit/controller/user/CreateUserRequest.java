package com.fit.fit.controller.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserRequest {
    private final Integer id;
    private final String userName;
    private final String email;
    private final String password;

}
