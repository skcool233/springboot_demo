package com.sunkai.springboot_demo.exception;

import com.sunkai.springboot_demo.pojo.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice    //统一处理
public class GlobalExceptionHandleAdvice {

    Logger log = (Logger) LoggerFactory.getLogger(GlobalExceptionHandleAdvice.class);

    @ExceptionHandler(value = Exception.class)   //什么异常的统一处理
    public ResponseMessage hanlderException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        //记录日志
        log.error("统一异常:", e);
        return new ResponseMessage(500, "error", null);
    }
}
