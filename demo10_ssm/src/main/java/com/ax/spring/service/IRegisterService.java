package com.ax.spring.service;

public interface IRegisterService {


    boolean register(String username, String password,int userType);

    Boolean checkUsername(String username);

}
