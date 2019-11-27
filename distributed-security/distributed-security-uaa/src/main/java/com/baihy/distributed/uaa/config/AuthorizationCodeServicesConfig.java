package com.baihy.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;

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
    public AuthorizationCodeServices authorizationCodeServices() {
        //设置授权码模式的授权码如何存取，暂时采用内存方式
        return new InMemoryAuthorizationCodeServices();
    }

}
