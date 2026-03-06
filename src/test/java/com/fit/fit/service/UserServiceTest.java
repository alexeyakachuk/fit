package com.fit.fit.service;

import com.fit.fit.controller.user.CreateUserRequest;
import com.fit.fit.dto.user.UserDto;
import com.fit.fit.exception.NotFoundException;
import com.fit.fit.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
    @Autowired
    public UserService userService;
    @Autowired
    private UserRepository repository;

    @BeforeEach
    void cleanup() {
        repository.deleteAll(); // или ваш репозиторий
    }

    // тест на создание пользователя
    @Test
    public void createTest() {
        CreateUserRequest request = CreateUserRequest.builder()
                .userName("Алексей")
                .email("box03-853@yandex.ru")
                .password("1111")
                .build();

        UserDto createdUserDto = userService.create(request);

        assertThat(createdUserDto).isNotNull();
        assertThat(createdUserDto.getId()).isNotNull();
        assertThat(createdUserDto.getUserName()).isEqualTo("Алексей");
        assertThat(createdUserDto.getEmail()).isEqualTo("box03-853@yandex.ru");

    }

    //Тест на возвращение пользователя по id
    @Test
    public void findUserTest() {
        CreateUserRequest request = CreateUserRequest.builder()
                .userName("Маша")
                .email("маша@yandex.ru")
                .password("2222")
                .build();

        UserDto createdUserDto = userService.create(request);
        userService.findAll();
        userService.findUser(1);

        assertThat(createdUserDto).isNotNull();
        assertThat(createdUserDto.getId()).isNotNull();
        assertThat(createdUserDto.getUserName()).isEqualTo("Маша");
        assertThat(createdUserDto.getEmail()).isEqualTo("маша@yandex.ru");

    }

    //Тест на возврощение всех пользователей
    @Test
    public void findAllTest() {
        CreateUserRequest request1 = CreateUserRequest.builder()
                .userName("Алексей")
                .email("box03-853@yandex.ru")
                .password("1111")
                .build();

        UserDto createdUserDto1 = userService.create(request1);

        CreateUserRequest request2 = CreateUserRequest.builder()
                .userName("Маша")
                .email("маша@yandex.ru")
                .password("2222")
                .build();

        UserDto createdUserDto2 = userService.create(request2);

        List<UserDto> users = userService.findAll();

        assertThat(users)
                .isNotNull()
                .isNotEmpty()
                .hasSize(2)
                .extracting(UserDto::getUserName, UserDto::getEmail)
                .containsExactlyInAnyOrder(
                        tuple("Алексей", "box03-853@yandex.ru"),
                        tuple("Маша", "маша@yandex.ru")
                );
    }

    // Тест на удаление пользователя
    @Test
    public void deleteUserTest() {
        CreateUserRequest request = CreateUserRequest.builder()
                .userName("Алексей")
                .email("box03-853@yandex.ru")
                .password("1111")
                .build();

        UserDto createdUser = userService.create(request);
        Integer userId = createdUser.getId();

        userService.deleteUser(userId);

        assertThatThrownBy(() -> userService.findUser(userId))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Пользователь с id " + userId + " не найден");
    }


    // Тест на обновление пользователя
    @Test
    public void updateUserTest() {
        // Arrange
        CreateUserRequest originalRequest = CreateUserRequest.builder()
                .userName("Алексей")
                .email("box03-853@yandex.ru")
                .password("1111")
                .build();

        UserDto createdUser = userService.create(originalRequest);
        Integer userId = createdUser.getId();

        CreateUserRequest updateRequest = CreateUserRequest.builder()
                .userName("Алексей1")
                .email("box03-853@yandex.ru")
                .password("1111")
                .build();

        UserDto updatedUser = userService.updateUser(userId, updateRequest);

        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getId()).isEqualTo(userId);
        assertThat(updatedUser.getUserName()).isEqualTo("Алексей1");
        assertThat(updatedUser.getEmail()).isEqualTo("box03-853@yandex.ru");

    }
}
