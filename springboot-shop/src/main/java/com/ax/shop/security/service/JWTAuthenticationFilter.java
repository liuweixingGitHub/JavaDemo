package com.ax.shop.security.service;

import com.ax.shop.entity.Userinfo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * token的校验
 * 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 * 从http头的Authorization 项读取token数据，然后用Jwts包提供的方法校验token的合法性。
 * 如果校验通过，就认为这是一个取得授权的合法请求
 *
 * @author zhaoxinguo on 2017/9/13.
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String header = request.getHeader("token");

        if (header == null) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);

    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("token");

        System.out.println("token = " + token);

        if (token != null) {
            // parse the token.
//   String user = Jwts.parser()
//     .setSigningKey("MyJwtSecret")
//     .parseClaimsJws(token.replace("Bearer ", ""))
//     .getBody()
//     .getSubject();

            String username = null;
            String password = null;
            List<GrantedAuthority> authorityList = new ArrayList<>();
            Userinfo userinfo = new Userinfo();


            if (token.equals("1")) {

                authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");//设置权限和角色
                username = "jim";
                password = "1234567";
            } else if (token.equals("2")) {

                authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_MANAGER");//设置权限和角色
                username = "tom";
                password = "1234567";
            }


            userinfo.setUserName(username);
            userinfo.setPassWord(password);

            userinfo.setGrantedAuthorities(authorityList);

            System.out.println("userinfo.getAuthorities() = " + userinfo.getAuthorities());


            if (username != null)
                return new UsernamePasswordAuthenticationToken(username, null, userinfo.getAuthorities());
        }
        return null;

    }
}