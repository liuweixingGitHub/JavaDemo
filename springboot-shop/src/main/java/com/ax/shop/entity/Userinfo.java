package com.ax.shop.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.ax.shop.util.axUtil.AxJwtUtil;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author axing
 */
public class Userinfo implements UserDetails {


    private Long id;
    private String token;
    private String password;
    private String username;
    /**
     * 用户权限
     **/
    List<UserRole> authorities;

    private int userType;

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;

//        if (id > 0 && username != null && password != null) {
//            token = AxJwtUtil.createJWT(id.toString(),username,password,0);
//        }
    }

    public String getToken() {
        token = AxJwtUtil.createJWT(id.toString(),username,password,0);
        return token;
    }

//    public void setToken(String token) {
//        this.token = token;
//    }

    public void setPassword(String password) {
        this.password = password;
//        if (id > 0 && username != null && password != null) {
//            token = AxJwtUtil.createJWT(id.toString(),username,password,0);
//        }
    }

    public void setUsername(String username) {
        this.username = username;
//        if (id > 0 && username != null && password != null) {
//            token = AxJwtUtil.createJWT(id.toString(),username,password,0);
//        }
    }

    public void setAuthorities(List<UserRole> authorities) {
        this.authorities = authorities;
    }

    /**
     * 添加用户拥有的权限和角色
     *
     * @return
     */
    @Override
    public Collection<UserRole> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
//        return new BCryptPasswordEncoder().encode(password); //返回加密的密码
        return password; //直接返回密码
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 账户是否过期
     *
     * @return
     */
    @Override
    @JSONField(serialize = false)
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 是否禁用
     *
     * @return
     */
    @Override
    @JSONField(serialize = false)
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否过期
     *
     * @return
     */
    @Override
    @JSONField(serialize = false)
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否启用
     *
     * @return
     */
    @Override
    @JSONField(serialize = false)
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"token\":\"")
                .append(token).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"authorities\":")
                .append(authorities);
        sb.append('}');
        return sb.toString();
    }
}
