package com.fit.fit.service;

import com.fit.fit.controller.user.CreateUserRequest;
import com.fit.fit.dto.user.UserDto;
import com.fit.fit.exception.NotFoundException;
import com.fit.fit.model.User;
import com.fit.fit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;
// создание пользователя
    public UserDto create(CreateUserRequest newUser) {
        // если будет нужно сделать проверки на исключения имени и почты
        User user = User.builder()
                .userName(newUser.getUserName())
                .email(newUser.getEmail())
                // Потом обязательно за хешировать пароль
                .password(newUser.getPassword())
                .build();
        User save = repository.save(user);
        // Возврощаем созданного пользователя для проверки
        return new UserDto(save);
    }

    // возвращение пользователя по id
    public UserDto findUser(Integer id) {
        // выяснить почему работает только через лямду
        User user = repository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));
        return new UserDto(user);
    }

    // Получение всех пользователей
    public List<UserDto> findAll() {
        return repository.findAll().stream()
                .map(user -> new UserDto(user))
                .toList();
    }
}
