package com.calculator.service;

import com.calculator.adder.exception.OverflowException;
import com.calculator.adder.exception.UnderflowException;
import com.calculator.exception.CalcuatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorServiceImpl calculatorService;

    @Test
    @DisplayName("test if two integers are added successfully")
    void testAddIntegers() {
        final String operand1 = "1";
        final String operand2 = "2";
        final String sum = "3";

        assertThat(calculatorService.add(operand1, operand2)).isEqualTo(sum);
    }

    @Test
    @DisplayName("test if two fractions are added successfully")
    void testAddFractions() {
        final String operand1 = "1.5";
        final String operand2 = "2.3";
        final String sum = "3.8";

        assertThat(calculatorService.add(operand1, operand2)).isEqualTo(sum);
    }

    @Test
    @DisplayName("test if an integer and a fraction are added successfully")
    void testAddIntegerAndFraction() {
        final String operand1 = "1";
        final String operand2 = "2.3";
        final String sum = "3.3";

        assertThat(calculatorService.add(operand1, operand2)).isEqualTo(sum);
    }

    @Test
    @DisplayName("test if two fractions are added to an integer when decimal part of sum is 0")
    void testAddFractionsWithIntegerSum() {
        final String operand1 = "1.5";
        final String operand2 = "2.5";
        final String sum = "4";

        assertThat(calculatorService.add(operand1, operand2)).isEqualTo(sum);
    }

    @Test
    @DisplayName("test if adding a non-number raises CalculatorException")
    void testAddNonNumberException() {
        final String operand1 = "a";
        final String operand2 = "2.5";
        final String expectedMessage = "Addition not supported for " + operand1 + " and " + operand2;

        CalcuatorException exception = assertThrows(CalcuatorException.class,
                                                    () -> {calculatorService.add(operand1, operand2);}
        );

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("test if adding very large postive numbers raises OverflowException")
    void testAddOverflowException() {
        final String operand1 = String.valueOf(Double.MAX_VALUE);
        final String operand2 = String.valueOf(Double.MAX_VALUE);
        final String expectedMessage = "Sum of " + operand1 + " and " + operand2 + "is out of supported numeric range";

        CalcuatorException exception = assertThrows(OverflowException.class,
                                                    () -> {calculatorService.add(operand1, operand2);}
        );

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("test if adding 2 large negative numbers raises UnderflowException")
    void testAddUnderflowException() {
        final String operand1 = String.valueOf(-Double.MAX_VALUE);
        final String operand2 = String.valueOf(-Double.MAX_VALUE);
        final String expectedMessage = "Sum of " + operand1 + " and " + operand2 + "is out of supported numeric range";

        CalcuatorException exception = assertThrows(UnderflowException.class,
                                                    () -> {calculatorService.add(operand1, operand2);}
        );

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("test if passing an out of range positive number raises OverflowException")
    void testAddPositiveNumberOutOfRangeException() {
        final String operand1 = "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
        final String operand2 = "1";
        final String expectedMessage = operand1 + " is out of supported numeric range";

        CalcuatorException exception = assertThrows(OverflowException.class,
                                                    () -> {calculatorService.add(operand1, operand2);}
        );

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }

    @Test
    @DisplayName("test if passing an out of range positive number raises UnderflowException")
    void testAddNegativeNumberOutOfRangeException() {
        final String operand1 = "-999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
        final String operand2 = "1";
        final String expectedMessage = operand1 + " is out of supported numeric range";

        CalcuatorException exception = assertThrows(UnderflowException.class,
                                                    () -> {calculatorService.add(operand1, operand2);}
        );

        assertThat(exception.getMessage()).isEqualTo(expectedMessage);
    }
}
