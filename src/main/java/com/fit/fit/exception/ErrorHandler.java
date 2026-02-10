package com.fit.fit.exception;

//import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {
//    private static final Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handValidationException(final ValidationException e) {
        log.error("Произошла ошибка не корректно ведены данные");
        return Map.of("Произошла ошибка", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handIllegalArgumentException(final IllegalArgumentException e) {
        log.error("Произошла ошибка не указаны пол или активность");
        return Map.of("Произошла ошибка", e.getMessage());
    }
}
