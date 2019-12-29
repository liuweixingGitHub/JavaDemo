//package com.ax.shop.security.service;
//
//
//import com.ax.shop.entity.Userinfo;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.annotation.Resource;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * token校验
// *
// * @author: JoeTao
// * createAt: 2018/9/14
// */
//@Component
//public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        String token = request.getHeader("token");
//
//        System.out.println("token = " + token);
//        System.out.println("response = " + response);
//
//        if (token != null) {
//
//            String username = "jim";
//            String password = "123456";
//            Userinfo userinfo = new Userinfo();
//            userinfo.setUserName(username);
//            userinfo.setPassWord("123456");
//
//
//            List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("read,ADMIN,ROLE_ADMIN");//设置权限和角色
//
//
//            userinfo.setGrantedAuthorities(authorityList);
//
////            List<GrantedAuthority> authorities = new ArrayList<>();
////            authorities.add(new SimpleGrantedAuthority("admin"));
////
////            userinfo.setGrantedAuthorities(authorities);
//
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userinfo.getUserName(), null, userinfo.getAuthorities());
//
//
//
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//
//        }
//
//
//        chain.doFilter(request, response);
//    }
//
//
//}

