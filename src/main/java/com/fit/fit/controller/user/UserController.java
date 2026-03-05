package com.fit.fit.controller.user;

import com.fit.fit.dto.user.UserDto;
import com.fit.fit.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private UserService service;
// создание пользователя
    @PostMapping
    public UserDto create(@Valid @RequestBody CreateUserRequest newUser) {
        return service.create(newUser);
    }
// получение пользователя по id
    @GetMapping("/{id}")
    public UserDto findUser(@PathVariable Integer id, HttpServletRequest request) {
        return service.findUser(id);
    }
    // получение всех пользователей
    @GetMapping
    public List<UserDto> findAll() {
        return service.findAll();
    }
// удоление пользователя по id
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        service.deleteUser(id);
    }
}
