package com.ax.shop.service.impl;

import com.ax.shop.service.HttpClientService;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @Author 冯战魁
 * @Date 2018/1/23 下午5:43
 */
@Service
public class HttpClientServiceImpl implements HttpClientService {

    //    Class<T> responseType, Object... uriVariables
    @Override
    public <T> T client(String url, HttpMethod method, MultiValueMap<String, String> params, Class<T> responseType) {


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));


        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        //  执行HTTP请求
        ResponseEntity<T> response = restTemplate.exchange(url, method, requestEntity, responseType);

        System.out.println("response = " + response);
        System.out.println("response.getBody() = " + response.getBody());
        return (T) response.getBody();
    }

    @Override
    public <T> T getClient(String url, MultiValueMap<String, String> params, Class<T> responseType) {

        return (T) this.client(url, HttpMethod.GET, params, responseType);
    }

    @Override
    public <T> T postClient(String url, MultiValueMap<String, String> params, Class<T> responseType) {

        return (T) this.client(url, HttpMethod.POST, params, responseType);
    }
}