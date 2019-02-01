package com.ax.demo.adapter;

import com.ax.demo.inteceptor.LoginInteceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个

        registry.addInterceptor(new LoginInteceptor()).addPathPatterns("/**");

    }

}
