package com.example.security.configuration;


import com.example.security.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 3、@EnableGlobalMethodSecurity详解
 *
 * 3.1、@EnableGlobalMethodSecurity(securedEnabled=true) 开启@Secured 注解过滤权限
 *
 * 3.2、@EnableGlobalMethodSecurity(jsr250Enabled=true)开启@RolesAllowed 注解过滤权限
 *
 * 3.3、@EnableGlobalMethodSecurity(prePostEnabled=true) 使用表达式时间方法级别的安全性         4个注解可用
 *
 *@PreAuthorize 在方法调用之前, 基于表达式的计算结果来限制对方法的访问
 *
 * @PostAuthorize 允许方法调用, 但是如果表达式计算结果为false, 将抛出一个安全性异常
 *
 * @PostFilter 允许方法调用, 但必须按照表达式来过滤方法的结果
 *
 * @PreFilter 允许方法调用, 但必须在进入方法之前过滤输入值
 *
 */

@Configuration
@EnableWebSecurity
//Spring Security默认是禁用注解的
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


//    @Autowired
//    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;        //认证成功处理类

    @Autowired
    MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;        //认证失败处理类


    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;  //注入我们自己的AuthenticationProvider

    @Autowired
    MyAccessDeniedHandler myAccessDeniedHandler;



    @Autowired
    MyAuthenticationEntryPoint myAuthenticationEntryPoint;


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/api/**", "/resources/**", "/static/**", "/public/**", "/webui/**", "/h2-console/**"
                        , "/configuration/**", "/swagger-resources/**", "/api-docs", "/api-docs/**", "/v2/api-docs/**"
                        , "/**/*.css", "/**/*.js", "/**/*.ftl", "/**/*.png ", "/**/*.jpg", "/**/*.gif ", "/**/*.svg", "/**/*.ico", "/**/*.ttf", "/**/*.woff");
        super.configure(web);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**使用框架的判断规则*/
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());//passwoldEncoder是对密码的加密处理，如果user中密码没有加密，则可以不加此方法。注意加密请使用security自带的加密方式。

        /**使用自定义的判断规则*/
        auth.authenticationProvider(myAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//禁用了 csrf 功能
                .authorizeRequests()//限定签名成功的请求
//                .antMatchers("/decision/**", "/govern/**", "/employee/*").hasAnyRole("EMPLOYEE", "ADMIN")//对decision和govern 下的接口 需要 USER 或者 ADMIN 权限
//                .antMatchers("/employee/login").permitAll()///employee/login 不限定
//                .antMatchers("/admin/**").hasAnyRole("ADMIN","MANAGER")//对admin下的接口 需要ADMIN权限
//                .antMatchers("/oauth/**").permitAll()//不拦截 oauth 开放的资源
                .anyRequest().permitAll()//其他没有限定的请求，允许访问
                .and().anonymous()//对于没有配置权限的其他请求允许匿名访问
                .and().formLogin()//使用 spring security 默认登录页面
                .and().httpBasic()//启用http 基础验证
                .and().formLogin().loginPage("/login.html")
                .loginProcessingUrl("/login.do")
                .successHandler(myAuthenctiationSuccessHandler) // 自定义登录成功处理
                .failureHandler(myAuthenctiationFailureHandler) // 自定义登录失败处理
                .and().exceptionHandling()
                .authenticationEntryPoint(myAuthenticationEntryPoint)
                .accessDeniedHandler(myAccessDeniedHandler)


        ;
      http
               .addFilter(new JWTAuthenticationFilter(authenticationManager()))
        ;
    }

}
