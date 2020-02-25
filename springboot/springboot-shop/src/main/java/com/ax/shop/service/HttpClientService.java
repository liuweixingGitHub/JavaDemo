package com.ax.shop.service;

import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;

public interface HttpClientService {

//    Object client(String url, HttpMethod method, MultiValueMap<String, String> params);

    <T> T client(String url, HttpMethod method, MultiValueMap<String, String> params, Class<T> responseType);


    <T> T getClient(String url, MultiValueMap<String, String> params, Class<T> responseType);

    <T> T postClient(String url, MultiValueMap<String, String> params, Class<T> responseType);

}
