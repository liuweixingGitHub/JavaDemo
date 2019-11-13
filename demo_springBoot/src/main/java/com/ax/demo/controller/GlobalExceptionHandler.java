package com.ax.demo.controller;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)//异常全局处理
//	 在@RequestMapping执行后执行
    public void exception(Exception exception) {
        System.out.println("全局exception = " + exception);
    }
    
    /**
     * 对方法参数校验异常处理方法
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    @ResponseBody
    public Object handlerNotValidException(Exception validException) {

        System.out.println("对方法参数校验异常处理方法exception = " + validException);

        List<ObjectError> objectErrorList = new LinkedList<>();

        if (validException instanceof MethodArgumentNotValidException) {
            objectErrorList = ((MethodArgumentNotValidException) validException).getBindingResult().getAllErrors();
        } else if (validException instanceof BindException) {
            objectErrorList = ((BindException) validException).getBindingResult().getAllErrors();
        }

        Map<String, Object> resultMap = new HashMap<>();

        for (ObjectError oe : objectErrorList) {
            String key = null;
            // 字段错误
            if (oe instanceof FieldError) {
                key = ((FieldError) oe).getField();// 获取错误验证字段名
            } else {
                // 非字段错误
                key = oe.getObjectName();// 获取验证对象名称
            }
            // 错误信息
            String msg = oe.getDefaultMessage();
            resultMap.put(key, msg);
        }

//        for (ObjectError oe : objectErrorList) {
//            String key = null;
//            String msg = null;
//            // 字段错误
//            if (oe instanceof FieldError) {
//                FieldError fe = (FieldError) oe;
//                key = fe.getField();// 获取错误验证字段名
//            } else {
//                // 非字段错误
//                key = oe.getObjectName();// 获取验证对象名称
//            }
//            // 错误信息
//            msg = oe.getDefaultMessage();
//            resultMap.put(key, msg);
//        }
        System.out.println("resultMap = " + resultMap);

        return resultMap;

    }


}
