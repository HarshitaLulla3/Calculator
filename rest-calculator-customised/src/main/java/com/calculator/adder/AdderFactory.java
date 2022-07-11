package com.calculator.adder;

import com.calculator.exception.CalcuatorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class AdderFactory {

    private List<Adder> adderList;

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    private void init() {
        adderList =
                new ArrayList<>(context.getBeansOfType(Adder.class).values());
    }

    //use getAdder method to get required Adder Type
    public Adder getAdder(String operand1, String operand2) throws CalcuatorException {
        return adderList
                .stream()
                .filter(consumer -> consumer.isApplicable(operand1, operand2))
                .findAny()
                .orElseThrow(
                        () -> new CalcuatorException("Addition not supported for " + operand1 + " and " + operand2)
                );
    }
}
