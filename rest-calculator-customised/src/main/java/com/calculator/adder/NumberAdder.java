package com.calculator.adder;
;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

@Component
public class NumberAdder implements Adder {
    @Override
    public Boolean canAccept(String operand1, String operand2) {
        return NumberUtils.isCreatable(operand1) && NumberUtils.isCreatable(operand2);
    }

    @Override
    public String add(String operand1, String operand2) {
        return String.valueOf(Integer.parseInt(operand1) + Integer.parseInt(operand2));

    }
}
