package com.calculator.controller;


import com.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Log4j2
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CalculatorController {

   private final CalculatorService calculatorService;

   @GetMapping
   public String home() {
       return "Calculator Application";
   }

   @GetMapping("/add")
   public String add(@RequestParam String operand1, @RequestParam String operand2) {
       return calculatorService.add(operand1, operand2);
   }
}
