package com.baihy.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.distributed.uaa.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/26 16:26
 */
@Configuration
public class TokenConfig {

    /**
     * 配置令牌存策略
     */
    @Bean
    public TokenStore tokenStore() {
        // 采用的是内存方法，生成普通令牌
        return new InMemoryTokenStore();
    }

}
