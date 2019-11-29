package com.baihy.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.distributed.uaa.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/29 14:15
 */
@Configuration
public class ClientDetailsServiceConfig {


    @Bean
    public ClientDetailsService clientDetailsService(DataSource dataSource) {
        JdbcClientDetailsService jdbcClientDetailsService = new JdbcClientDetailsService(dataSource);
        // 注意:JdbcClientDetailsService的PasswordEncoder密码编码器是NoOpPasswordEncoder.getInstance()
        jdbcClientDetailsService.setPasswordEncoder(new BCryptPasswordEncoder());
        return jdbcClientDetailsService;
    }

}
