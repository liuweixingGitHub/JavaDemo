package com.ax.shop.dto;

import com.ax.shop.entity.valid.PasswordGroup;
import com.ax.shop.entity.valid.UsernameGroup;

import javax.validation.constraints.NotNull;

/**
 * @author axing
 */



public class LoginDto {

    @NotNull(message = "姓名不能空",groups = UsernameGroup.class)
    private  String username;

    @NotNull(message = "密码不能空",groups = PasswordGroup.class)
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append('}');
        return sb.toString();
    }
}