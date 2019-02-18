package com.ax.study.all.inteceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author axing
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Bean
    public AuthenticationInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 可添加多个
        registry.addInterceptor(new LoginInteceptor()).addPathPatterns("/**");

        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");
    }


}
