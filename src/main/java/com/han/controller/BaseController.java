package com.han.controller;

import com.han.exception.BusinessException;
import com.han.exception.ParamsException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {
    @ExceptionHandler
    public String exc(HttpServletRequest request, HttpServletResponse
            response, Exception ex){
        request.setAttribute("ex", ex);
        if(ex instanceof ParamsException){
            return "error_param";
        }
        if(ex instanceof BusinessException){
            return "error_business";
        }
        return "error";
    }
}
