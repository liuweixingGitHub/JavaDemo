package com.ax.demo;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    ///日志级别
    @Bean
    Logger.Level level() {
        return Logger.Level.FULL;
    }
}
