package com.calculator.service;

import com.calculator.adder.Adder;
import com.calculator.adder.AdderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdderService implements CalculatorService {

    @Autowired private AdderFactory adderFactory;

    @Override
    public String operation(String operand1, String operand2) {
        Adder adder =  adderFactory.getAdder(operand1, operand2);
        return adder.add(operand1, operand2);
    }
}
