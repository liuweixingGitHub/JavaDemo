package com.example.security.service;


import com.example.security.entity.Userinfo;

/**
 * @author axing
 */
public interface ILoginService {


    Userinfo getByUserName(String userName);

}
