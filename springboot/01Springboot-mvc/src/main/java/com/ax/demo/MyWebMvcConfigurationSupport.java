package com.ax.demo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyWebMvcConfigurationSupport extends WebMvcConfigurationSupport {


    /**
     * 字符返回乱码
     *
     * @return
     */
    @Bean
    public HttpMessageConverter<String> stringHttpMessageConverterUtf8() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

    /**
     * json返回工具类及乱码
     *
     * @return
     */
    @Bean
    public HttpMessageConverter fastJsonHttpMessageConverters() {

        // 2.添加fastjson的配置信息，比如: 是否需要格式化返回的json数据
        FastJsonConfig config = new FastJsonConfig();

        config.setDateFormat("yyyy-MM-dd HH:MM:ss");

        config.setSerializerFeatures(

                //结果是否格式化,默认为false
                SerializerFeature.PrettyFormat,
                //枚举值使用名称或tosting
                SerializerFeature.WriteEnumUsingName,
                // 保留map空的字段
                SerializerFeature.WriteMapNullValue,
                // 将String类型的null转成""
                SerializerFeature.WriteNullStringAsEmpty,
                // 将Number类型的null转成0
                SerializerFeature.WriteNullNumberAsZero,
                // 将List类型的null转成[], List<String> list = new ArrayList<>(); 泛型不支持
                SerializerFeature.WriteNullListAsEmpty,
                // 将Boolean类型的null转成false
                SerializerFeature.WriteNullBooleanAsFalse,
                // 避免循环引用
                SerializerFeature.DisableCircularReferenceDetect);


        // 1.定义一个converters转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        // 3.在converter中添加配置信息
        fastConverter.setFastJsonConfig(config);


        // 4.中文乱码解决方案
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_PROBLEM_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(mediaTypes);
        // 5.返回HttpMessageConverters对象
        return fastConverter;
    }

    /**
     * 将.html 添加 到 resources目录下
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        super.addResourceHandlers(registry);

        /**将static下面的js，css文件加载出来 ,html引入文件就需要 ../static/ 这样前缀了*/
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        /// 使用这个,html引入文件就不需要 ../static/ 这样前缀了
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");


    }


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);

        converters.add(stringHttpMessageConverterUtf8());
        converters.add(fastJsonHttpMessageConverters());
    }


}
