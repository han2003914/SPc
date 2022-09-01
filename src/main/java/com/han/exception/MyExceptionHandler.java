package com.han.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

//@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("ex", ex);
        ModelAndView mv=null;
        if(ex instanceof ArithmeticException){
            return new ModelAndView("error_param", map);
        }
        if(ex instanceof BusinessException){
            return new ModelAndView("error_business", map);
        }
        return new ModelAndView("error", map);
    }
}