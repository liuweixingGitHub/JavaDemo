package com.ax.springsecurity.config;//package com.ax.springsecurity.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;


/*授权码 服务*/
@Configuration
@EnableAuthorizationServer
public class AuthConfig extends AuthorizationServerConfigurerAdapter {

//    http://localhost:8080/oauth/authorize?client_id=client&&response_type=code




    //数据源,存储在数据库中
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource oauthDataSource() {
//        return DataSourceBuilder.create().build();
        /*连接池 Druid*/
        return DruidDataSourceBuilder.create().build();
    }

    //数据源,存储在数据库中
    @Bean
    public TokenStore tokenStore1(){
        return new JdbcTokenStore(oauthDataSource());
    }

    //数据源,存储在数据库中
    @Bean
    public ClientDetailsService jdbc_clientDetailsService(){
       return new JdbcClientDetailsService(oauthDataSource());
    }

//DruidDataSourceBuilder.create().build()

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//                .inMemory()
//                .withClient("client")
////                    secret 加密的秘钥
//                .secret(passwordEncoder().encode("secret"))
//
//                // 授权码模式("authorization_code", "refresh_token", "password")
//                .authorizedGrantTypes("authorization_code")
//                /*范围*/
//        .scopes("app")
//                /*回调地址*/
//        .redirectUris("http://localhost:8080/code")
                ;

        clients.withClientDetails(jdbc_clientDetailsService())
               ;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints.tokenStore(tokenStore1());
    }
}

