package com.baihy.distributed.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.distributed.uaa.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/27 10:03
 */
@Configuration
public class TokenServiceConfig {

    /**
     * 配置令牌管理服务
     */

    @Autowired
    private TokenStore tokenStore;
    // 注入客户端详情服务
    @Autowired
    private ClientDetailsService clientDetailsService;

    @Bean
    public AuthorizationServerTokenServices authorizationServerTokenServices() {
        /**
         * 配置令牌管理服务
         */
        DefaultTokenServices service = new DefaultTokenServices();
        service.setClientDetailsService(clientDetailsService); // 设置客户端信息服务
        service.setSupportRefreshToken(true);  // 是否产生刷新令牌
        service.setTokenStore(tokenStore);// 指定token的存储策略
        service.setAccessTokenValiditySeconds(7200); // 令牌默认有效期2小时 单位是秒
        service.setRefreshTokenValiditySeconds(259200); // 刷新令牌默认有效期3天  单位是秒
        return service;
    }

}
