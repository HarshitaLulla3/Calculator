package com.calculator.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Data
public class CalcuatorException extends RuntimeException {
    private String message;

    public CalcuatorException(String message) {
        this.message = message;
    }
}
