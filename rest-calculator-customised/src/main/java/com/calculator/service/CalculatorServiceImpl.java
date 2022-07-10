package com.calculator.service;

import com.calculator.adder.Adder;
import com.calculator.adder.AdderFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalculatorServiceImpl implements CalculatorService{

    private final AdderFactory adderFactory;

    @Override
    public String add(String operand1, String operand2) {
        Adder adder =  adderFactory.getAdder(operand1, operand2);
        return adder.add(operand1, operand2);
    }
}
