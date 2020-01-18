package com.ax.content.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ContentServerCofig extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {

//        http
//                .authorizeRequests()
//                .antMatchers("/test","/oauth/token").permitAll()     // 这两个页面任何人都可以访问
//                .anyRequest().authenticated()                           // 其他任何请求都需要验证
//        ;
//        http.authorizeRequests().antMatchers("/").anonymous();

        /** /content 资源需要权限,其他的未说明,表示不需要权限*/
        http.authorizeRequests().antMatchers("/content").authenticated();

    }
}
//        /**开启授权认证 */
//        http.authorizeRequests()
//                //允许访问授权接口
//                .antMatchers("/oauth/**").permitAll()
//                //其他接口无需授权
//                .anyRequest().authenticated();