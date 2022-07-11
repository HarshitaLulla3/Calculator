package com.calculator.service;

public interface CalculatorService {
    /**
     * Adds 2 operands
     * @param operand1
     * @param operand2
     * @return Sum of given operands
     * @throws com.calculator.exception.CalcuatorException
     */
    String add (String operand1, String operand2);
}
