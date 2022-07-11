package com.calculator.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@RestController
@Log4j2
public class CalculatorErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status == null) {
            status = HttpStatus.NOT_FOUND.value();
        }
        return "error " + status;
    }

    // ToDo: Redundant method, required by the current spring-boot version. Remove after spring-boot removes it as mandatory
    public String getErrorPath() {
        return null;
    }
}
