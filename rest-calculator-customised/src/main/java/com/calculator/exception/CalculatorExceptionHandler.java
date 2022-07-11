// Global exception handler
package com.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CalculatorExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value=CalcuatorException.class)
    protected ResponseEntity<Object> handleCalculatorException (CalcuatorException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
