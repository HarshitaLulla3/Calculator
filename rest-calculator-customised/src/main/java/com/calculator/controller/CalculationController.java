package com.calculator.controller;

import static com.calculator.model.ResultBuilder.getResult;
import static com.calculator.model.ResultBuilder.getResultFromError;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.model.ApiResult;


@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/calculator")
public class CalculationController {

   private final CalculatorService calculatorService;

   @GetMapping("/add")
   public ApiResult add(@RequestParam String operand1, @RequestParam String operand2) {
     return getResult(calculatorService.add(operand1, operand2));
   }
}
