package com.ax.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将templates目录下的CSS、JS文件映射为静态资源，防止Spring把这些资源识别成thymeleaf模版
//        registry.addResourceHandler("/templates/**.js").addResourceLocations("classpath:/templates/");
//        registry.addResourceHandler("/templates/**.css").addResourceLocations("classpath:/templates/");

        //其他静态资源

        /**将static下面的js，css文件加载出来 ,html引入文件就需要 ../static/ 这样前缀了*/
     /*   registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");*/
       /** 使用这个,html引入文件就不需要 ../static/ 这样前缀了 */
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

    }
}