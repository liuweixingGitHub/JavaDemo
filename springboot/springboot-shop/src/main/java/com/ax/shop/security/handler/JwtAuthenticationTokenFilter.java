package com.ax.shop.security.handler;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.ax.shop.entity.Userinfo;
import com.ax.shop.service.IUserinfoService;
import com.ax.shop.util.axUtil.AxJwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liu
 * 一定用这个类 ,其他类无法注入
 */
@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private IUserinfoService userinfoService;


    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain) throws ServletException, IOException {

        String token = request.getHeader("token");

        if (token != null) {

            if (!AxJwtUtil.validateJWT(token)) {
                throw new ServletException("token失效");
            }

            DecodedJWT decodedJWT = AxJwtUtil.parseJWT(token);
            Long id = Long.valueOf(decodedJWT.getId());

            Userinfo userinfo = userinfoService.selectUserWithRelo(id);

            System.out.println("userinfo.getAuthorities(). = " + userinfo.getToken());

            if (userinfo != null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userinfo, null, userinfo.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}