package com.fit.fit.service;

import com.fit.fit.controller.user.CreateUserRequest;
import com.fit.fit.dto.UserDto;
import com.fit.fit.exception.NotFoundException;
import com.fit.fit.exception.ValidationException;
import com.fit.fit.model.User;
import com.fit.fit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    // создание пользователя
    public UserDto create(CreateUserRequest newUser) {

        // Проверка имени
        if (newUser.getUserName() == null || newUser.getUserName().trim().isEmpty()) {
            throw new ValidationException("Имя пользователя не может быть пустым");
        }
        // Проверка email
        if (newUser.getEmail() == null || newUser.getEmail().trim().isEmpty()) {
            throw new ValidationException("Email не может быть пустым");
        }
        // Проверка уникальности email
        if (repository.findEmail(newUser.getEmail()) != null) {
            throw new ValidationException("Такой email уже существует");
        }

        // Хешируем пароль (например, через BCryptPasswordEncoder)
        String hashedPassword = new BCryptPasswordEncoder().encode(newUser.getPassword());

        User user = User.builder()
                .userName(newUser.getUserName())
                .email(newUser.getEmail())
                // Потом обязательно за хешировать пароль
                .password(hashedPassword)
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

    // Удоление пользователя
    public void deleteUser(Integer id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Пользователя с id " + id + " не найден");
        }
        repository.deleteById(id);
    }

    // обновление пользователя
    public UserDto updateUser(Integer id, CreateUserRequest newUser) {
        User user = repository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));
        user.setUserName(newUser.getUserName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());

        repository.save(user);
        return new UserDto(user);
    }

    // приватный метод для получения user по id
    protected User findUser1(Integer id) {
        User user = repository.findById(id).orElseThrow(() -> new NotFoundException("Пользователь с id " + id + " не найден"));
        return user;
    }
}
