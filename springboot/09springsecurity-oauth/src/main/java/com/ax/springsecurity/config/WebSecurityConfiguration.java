package com.ax.springsecurity.config;//package com.ax.springsecurity.config;

import com.ax.springsecurity.handler.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 3、@EnableGlobalMethodSecurity详解
 * <p>
 * 3.1、@EnableGlobalMethodSecurity(securedEnabled=true) 开启@Secured 注解过滤权限
 * <p>
 * 3.2、@EnableGlobalMethodSecurity(jsr250Enabled=true)开启@RolesAllowed 注解过滤权限
 * <p>
 * 3.3、@EnableGlobalMethodSecurity(prePostEnabled=true) 使用表达式时间方法级别的安全性         4个注解可用
 *
 * @PreAuthorize 在方法调用之前, 基于表达式的计算结果来限制对方法的访问
 * @PostAuthorize 允许方法调用, 但是如果表达式计算结果为false, 将抛出一个安全性异常
 * @PostFilter 允许方法调用, 但必须按照表达式来过滤方法的结果
 * @PreFilter 允许方法调用, 但必须在进入方法之前过滤输入值
 *
 *
 * 一、五个handler一个filter两个User
 *
 * 5个handler，分别是
 *
 *     实现AuthenticationEntryPoint接口,当匿名请求需要登录的接口时,拦截处理
 *     实现AuthenticationSuccessHandler接口,当登录成功后,该处理类的方法被调用
 *     实现AuthenticationFailureHandler接口,当登录失败后,该处理类的方法被调用
 *     实现AccessDeniedHandler接口,当登录后,访问接口没有权限的时候,该处理类的方法被调用
 *     实现LogoutSuccessHandler接口,注销的时候调用
 *
 */

@Configuration
@EnableWebSecurity
//Spring Security默认是禁用注解的
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


//    @Autowired
//    private UserDetailsService userDetailsService;



    @Autowired
    MyLoginSuccessHandler myLoginSuccessHandler;        //认证成功处理类

    @Autowired
    MyLoginFailureHandler myLoginFailureHandler;        //认证失败处理类


    @Autowired
    private MyAuthenticationProvider myAuthenticationProvider;  //注入我们自己的AuthenticationProvider

    @Autowired
    MyAccessDeniedHandler myAccessDeniedHandler;


    @Autowired
    MyAuthenticationEntryPoint myAuthenticationEntryPoint;

    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/api/**", "/resources/**", "/static/**", "/public/**", "/webui/**", "/h2-console/**"
                        , "/configuration/**", "/swagger-resources/**", "/api-docs", "/api-docs/**", "/v2/api-docs/**"
                        , "/**/*.css", "/**/*.js", "/**/*.ftl", "/**/*.png ", "/**/*.jpg", "/**/*.gif ", "/**/*.svg", "/**/*.ico", "/**/*.ttf", "/**/*.woff");
        super.configure(web);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        /**使用框架的判断规则*/
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());//passwoldEncoder是对密码的加密处理，如果user中密码没有加密，则可以不加此方法。注意加密请使用security自带的加密方式。

        /**使用自定义的判断规则*/
//        auth.authenticationProvider(myAuthenticationProvider);

        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")

;

    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//
//        /**
//         * 禁用了 csrf 功能,不然总是跳转到登陆页面
//         */
//        http.csrf().disable();
//
//        /**
//         * 自定义登陆页面
//         */
////        http.formLogin().loginPage("/login.html").permitAll()
////                .loginProcessingUrl("/login.do")
////            .defaultSuccessUrl("/home.do")
//        //// 自定义登陆接口参数
//        http.formLogin().loginPage("/login.html").usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login.do");
//
//
//        /**
//         * 登陆成功后跳转页面
//         */
//        http.formLogin()
//                // 自定义登录成功页面,也可以在 SimpleUrlAuthenticationSuccessHandler 重定向
////                .defaultSuccessUrl("home")
//                // 自定义登录成功处理
//                .successHandler(myLoginSuccessHandler)
//                // 自定义登录失败处理
//                .failureHandler(myLoginFailureHandler)
//        ;
//
//        http.exceptionHandling()
//                /**用户未登陆**/
//                .authenticationEntryPoint(myAuthenticationEntryPoint)
//                /**用户权限不足**/
//                .accessDeniedHandler(myAccessDeniedHandler);
//
//        /*** 退出 */
//        /**退出成功处理器 */
//        http.logout().logoutUrl("/logout.do").permitAll()
//                .invalidateHttpSession(true)
//                .logoutSuccessHandler(new MyLogoutSuccessHandler());
//
//
//        /**授权配置*/
////        http.authorizeRequests().anyRequest().fullyAuthenticated();
//        http.authorizeRequests().anyRequest().permitAll();//其他没有限定的请求，允许访问
//
//
//        http.addFilterAfter(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//
//
//        ;
//
//    }
//


}
