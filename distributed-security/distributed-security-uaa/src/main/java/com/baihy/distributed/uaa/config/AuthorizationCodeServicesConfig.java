package com.baihy.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;

import javax.sql.DataSource;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.distributed.uaa.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/27 10:05
 */
@Configuration
public class AuthorizationCodeServicesConfig {

    /**
     * 配置令牌的授权码服务
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(DataSource dataSource) {
        //设置授权码模式的授权码如何存取?
        // AuthorizationCodeServices authorizationCodeServices = new InMemoryAuthorizationCodeServices();
        // 授权码保存到内存中
        AuthorizationCodeServices authorizationCodeServices = new JdbcAuthorizationCodeServices(dataSource);
        // 授权码保存到数据库中
        return authorizationCodeServices;
    }

}
