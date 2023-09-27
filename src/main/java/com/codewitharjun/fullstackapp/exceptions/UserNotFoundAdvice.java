package com.codewitharjun.fullstackapp.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> exceptionHandle(UserNotFoundException exception){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("error", exception.getMessage());
        return errorMap;
    }

}
