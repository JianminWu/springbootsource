package com.cdt.handler;

import com.cdt.dto.BaseResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * @Author: wujianmin
 * @Date: 2019/11/7 15:51
 * @Function:
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public BaseResult constraintViolationException(ConstraintViolationException exs){
        exs.printStackTrace();
        StringBuffer sb = new StringBuffer();
        Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
        for(ConstraintViolation<?> item:violations){
            sb.append(item.getMessage()+"/");
        }
        return new BaseResult(sb.replace(sb.length()-1,sb.length(),"").toString(),null);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResult methodArgumentNotValidException(MethodArgumentNotValidException exs){
        exs.printStackTrace();
        BindingResult bindingResult = exs.getBindingResult();
        StringBuffer sb = new StringBuffer();
        for(FieldError fieldError :bindingResult.getFieldErrors()){
            sb.append(fieldError.getDefaultMessage()+"/");
        }
        return new BaseResult(sb.replace(sb.length()-1,sb.length(),"").toString(),null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResult exception(Exception e){
        e.printStackTrace();
        return new BaseResult("failed"+e.getMessage(),null);
    }
}
