/*
package com.example.demo.controller;
import com.example.demo.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


*/
/**
  *@description:TODO
  *param
  *@return Result
  *@throws
  *@author wang_zhina
  *@date 2022/3/28 17:48
  *//*

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    */
/**
     * 方法参数校验
     *//*

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        System.out.println(e.getBindingResult().getFieldError().getDefaultMessage());

        return Result.error(e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
*/
