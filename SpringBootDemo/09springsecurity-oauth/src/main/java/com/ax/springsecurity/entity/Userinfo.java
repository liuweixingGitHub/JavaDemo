package com.ax.springsecurity.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private List<UserRole> authorities;
    private int userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    public void setAuthorities(List<UserRole> authorities) {
        this.authorities = authorities;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    //
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
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 是否禁用
     *
     * @return
     */
    @Override
    @JSONField(serialize = false) //JSONObject对有JSONField(serialize = false)的不会返回，null的也不返回
    @JsonIgnore //ObjectMapper对有注解jsonIgnore的不会返回，其它全部返回
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
    @JsonIgnore
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
    @JsonIgnore
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
