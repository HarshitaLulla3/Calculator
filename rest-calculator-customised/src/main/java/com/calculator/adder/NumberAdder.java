package com.calculator.adder;

import com.calculator.exception.CalculatorOverflowException;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class NumberAdder implements Adder {
    @Override
    public Boolean canAccept(String operand1, String operand2) {
        return NumberUtils.isCreatable(operand1) && NumberUtils.isCreatable(operand2);
    }

    @Override
    public String add(String operand1, String operand2) {

        double number1 = Double.parseDouble(operand1);
        double number2 = Double.parseDouble(operand2);

        if (number1 == Double.POSITIVE_INFINITY || number1 == Double.NEGATIVE_INFINITY) {
            throw new CalculatorOverflowException(operand1 + " is out of supported numeric range");
        }

        if (number2 == Double.POSITIVE_INFINITY || number2 == Double.NEGATIVE_INFINITY) {
            throw new CalculatorOverflowException(operand2 + " is out of supported numeric range");
        }

        double sum = Double.sum(number1, number2);

        if (sum == Double.POSITIVE_INFINITY) {
            return String.valueOf(Double.POSITIVE_INFINITY);
        }

        if (sum == Double.NEGATIVE_INFINITY) {
            return String.valueOf(Double.NEGATIVE_INFINITY);
        }

        if ((int) sum == sum) {
            return String.valueOf((int)sum);
        }

        return String.valueOf(sum);
    }
}
