package com.example.security.handler;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.security.entity.Userinfo;
import com.example.security.service.ILoginService;
import com.example.security.util.AxJwtUtil;
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
 * @author gourd
 */
@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private ILoginService loginService;


    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {

                String token = request.getHeader("token");
        System.out.println("token111 = " + token);
        System.out.println("loginService = " + loginService);


        if (token != null) {

            if (!AxJwtUtil.validateJWT(token)) {
                System.out.println("AxJwtUtil.validateJWT(token) = " + AxJwtUtil.validateJWT(token));
                throw new ServletException("token失效");
            }
            DecodedJWT decodedJWT = AxJwtUtil.parseJWT(token);
            Long id = Long.valueOf(decodedJWT.getId());


            System.out.println("id = " + id);
            Userinfo userinfo = loginService.getById(id);

            System.out.println("userinfo = " + userinfo);

            if (userinfo != null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userinfo, null, userinfo.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        }

        chain.doFilter(request, response);
    }
}