package com.example.security.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.GrantedAuthority;
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

    List<GrantedAuthority> grantedAuthorities;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {

        token = JWT.create().withAudience(this.id.toString()).withAudience(username)
                .sign(Algorithm.HMAC256(this.password));

        return token;
    }


    public void setGrantedAuthorities(List<GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
//        return new BCryptPasswordEncoder().encode(passWord); //返回加密的密码
        return password; //直接返回密码
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JSONField(serialize = false)
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JSONField(serialize = false)
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JSONField(serialize = false)
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    @JSONField(serialize = false)
    public boolean isEnabled() {
        return true;
    }
}