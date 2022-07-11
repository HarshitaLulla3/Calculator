package com.calculator.adder.exception;

import com.calculator.exception.CalcuatorException;

public class OverflowException extends CalcuatorException {

    public OverflowException(String message) {
        super(message);
    }
}
