package com.ax.demo.service;

/**
 * @author axing
 */
public interface IRegisterService {


    boolean register(String username, String password, int userType);

    Boolean checkUsername(String username);

}
