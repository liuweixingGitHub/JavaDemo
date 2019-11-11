package com.ax.demo.entity;

import javax.validation.constraints.NotNull;

/**
 * @author axing
 */

public class LoginEntity  {

    @NotNull(message = "姓名不能空")
    private  String username;

    @NotNull(message = "密码不能空")
    private  String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}