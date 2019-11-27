package com.baihy.distributed.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.distributed.uaa.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/27 10:03
 */
@Configuration
public class AuthorizationServerTokenServiceConfig {

    /**
     * 配置令牌管理服务
     */

    @Autowired
    private TokenStore tokenStore;
    // 注入客户端详情服务
    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Bean
    public AuthorizationServerTokenServices authorizationServerTokenServices() {
        /**
         * 配置令牌管理服务
         */
        DefaultTokenServices service = new DefaultTokenServices();
        service.setClientDetailsService(clientDetailsService); // 设置客户端信息服务
        service.setSupportRefreshToken(true);  // 是否产生刷新令牌
        service.setTokenStore(tokenStore);// 指定token的存储策略

        // 设置令牌的增强
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter));
        service.setTokenEnhancer(tokenEnhancerChain);

        service.setAccessTokenValiditySeconds(7200); // 令牌默认有效期2小时 单位是秒
        service.setRefreshTokenValiditySeconds(259200); // 刷新令牌默认有效期3天  单位是秒
        return service;
    }

}
