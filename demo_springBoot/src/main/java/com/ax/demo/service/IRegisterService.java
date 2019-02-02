package com.ax.demo.service;

/**
 * @author axing
 */
public interface IRegisterService {

    boolean register(String userName, String passWord, int userType);

    boolean checkUsername(String userName);

}
