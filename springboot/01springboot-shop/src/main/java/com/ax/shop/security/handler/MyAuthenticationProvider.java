package com.ax.shop.security.handler;


import com.ax.shop.entity.Userinfo;
import com.ax.shop.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
///AuthenticationProvider  和 UserDetailsService 任用一个
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    ILoginService loginService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();// 这个获取表单输入中返回的用户名;
        String password = (String) authentication.getCredentials();// 这个是表单中输入的密码；

        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println(" authentication.getPrincipal() = " +  authentication.getPrincipal());


        // 这里调用我们的自己写的获取用户的方法；
        Userinfo userInfo = loginService.getByUserName(username);

        if (userInfo == null) {
            throw new BadCredentialsException("用户名不存在");
        }

        if (!userInfo.getPassword().equals(password)) {
            throw new BadCredentialsException("密码不正确");
        }
        Collection<? extends GrantedAuthority> authorities = userInfo.getAuthorities();
        // 构建返回的用户登录成功的token
        return new UsernamePasswordAuthenticationToken(userInfo, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // TODO Auto-generated method stub
        // 这里直接改成retrun true;表示是支持这个执行
        return true;
    }
}
