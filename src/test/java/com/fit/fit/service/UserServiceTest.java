package com.fit.fit.service;

import com.fit.fit.controller.user.CreateUserRequest;
import com.fit.fit.dto.user.UserDto;
import com.fit.fit.exception.NotFoundException;
import com.fit.fit.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    public UserService userService;
    @Autowired
    private UserRepository repository;

    private int userIdFirst;
    private int userIdSecond;

    @BeforeEach
    void cleanup() {
        repository.deleteAll();
        CreateUserRequest request = CreateUserRequest.builder()
                .userName("Алексей")
                .email("box03-853@yandex.ru")
                .password("1111")
                .build();
        UserDto userDto = userService.create(request);
        userIdFirst = userDto.getId();

        request = CreateUserRequest.builder()
                .userName("Маша")
                .email("маша@yandex.ru")
                .password("2222")
                .build();
        userDto = userService.create(request);
        userIdSecond = userDto.getId();

    }

    // тест на создание пользователя
    @Test
    public void createTest() {
        CreateUserRequest request = CreateUserRequest.builder()
                .userName("Алексей1")
                .email("box03-852@yandex.ru")
                .password("2222")
                .build();

        UserDto createdUserDto = userService.create(request);

        assertThat(createdUserDto).isNotNull();
        assertThat(createdUserDto.getId()).isNotNull();
        assertThat(createdUserDto.getUserName()).isEqualTo("Алексей1");
        assertThat(createdUserDto.getEmail()).isEqualTo("box03-852@yandex.ru");

    }

    //Тест на возвращение пользователя по id
    @Test
    public void findUserTest() {

        UserDto user = userService.findUser(userIdSecond);

        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotNull();
        assertThat(user.getUserName()).isEqualTo("Маша");
        assertThat(user.getEmail()).isEqualTo("маша@yandex.ru");

    }

    //Тест на возврощение всех пользователей
    @Test
    public void findAllTest() {

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
        userService.deleteUser(userIdFirst);

        assertThatThrownBy(() -> userService.findUser(userIdFirst))
                .isInstanceOf(NotFoundException.class)
                .hasMessage("Пользователь с id " + userIdFirst + " не найден");
    }


    // Тест на обновление пользователя
    @Test
    public void updateUserTest() {

        CreateUserRequest updateRequest = CreateUserRequest.builder()
                .userName("Алексей1")
                .email("box03-853@yandex.ru")
                .password("1111")
                .build();

        UserDto updatedUser = userService.updateUser(userIdFirst, updateRequest);

        assertThat(updatedUser).isNotNull();
        assertThat(updatedUser.getId()).isEqualTo(userIdFirst);
        assertThat(updatedUser.getUserName()).isEqualTo("Алексей1");
        assertThat(updatedUser.getEmail()).isEqualTo("box03-853@yandex.ru");

    }
}
