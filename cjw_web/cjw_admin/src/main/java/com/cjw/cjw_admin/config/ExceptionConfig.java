package com.cjw.cjw_admin.config;

import com.cjw.cjw_admin.vo.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice

public class ExceptionConfig {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHander(Exception e){

        return AjaxResult.erro(e.getMessage());
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public String handlerException(NoHandlerFoundException e){

        return "404";

    }
}
