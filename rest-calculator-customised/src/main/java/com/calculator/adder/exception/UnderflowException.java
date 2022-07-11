package com.calculator.adder.exception;

import com.calculator.exception.CalcuatorException;

public class UnderflowException extends CalcuatorException {

    public UnderflowException(String message) {
        super(message);
    }
}
