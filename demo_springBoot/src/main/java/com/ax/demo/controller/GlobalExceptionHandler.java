package com.ax.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)//异常全局处理
    @ResponseBody
//	 在@RequestMapping执行后执行
    public Object exception(HttpServletRequest request, HttpServletResponse response, Exception exception) {

        System.out.println("全局exception = " + exception);

        String method = request.getMethod();
        String path = request.getRequestURI();

        Map<String,Object> data = new HashMap<>();
        data.put("path",path);
        data.put("method",method);
        data.put("status",response.getStatus());

        /**
         * 404处理
         * */
        if (exception instanceof NoHandlerFoundException) {
            data.put("msg","方法找不到");
            return data;
        }

//        System.out.println("全局exception = " + exception);
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        System.out.println("全局exception = " + statusCode);
//        return "全局exception = " + statusCode+"response.getStatus = "+response.getStatus();


        data.put("全局exception",method);
        data.put("path",path);
        return data;


    }



    /**
     * 对方法参数校验异常处理方法
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
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
