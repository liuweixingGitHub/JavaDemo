package com.ax.shop.annotation;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

@ResponseResultBody //可以标记在类和方法上这样我们就可以跟自由的进行使用了
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ResponseResultBody {
}