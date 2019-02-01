package com.ax.demo.inteceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author axing
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(new LoginInteceptor()).addPathPatterns("/**");

    }

}
