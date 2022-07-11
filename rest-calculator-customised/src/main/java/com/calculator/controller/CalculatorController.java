package com.calculator.controller;

import com.calculator.model.ResultBuilder;

import com.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.model.ApiResult;


@Log4j2
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//@RequestMapping("/calculator")
public class CalculatorController {

   private final CalculatorService calculatorService;

   @GetMapping("/add")
   public ApiResult add(@RequestParam String operand1, @RequestParam String operand2) {
       return ResultBuilder.getResult(calculatorService.add(operand1, operand2));
   }
}
